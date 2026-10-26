package com.example.recipeapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp.data.SampleData
import com.example.recipeapp.model.Category
import com.example.recipeapp.model.Recipe
import com.example.recipeapp.model.ShoppingItem
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

enum class AppNavTab {
    DISCOVER,
    FAVORITES,
    SHOPPING_LIST
}

data class TimerUiState(
    val isVisible: Boolean = false,
    val isRunning: Boolean = false,
    val remainingSeconds: Int = 0,
    val totalSeconds: Int = 0,
    val title: String = ""
) {
    val progress: Float
        get() = if (totalSeconds > 0) 1f - (remainingSeconds.toFloat() / totalSeconds.toFloat()) else 0f

    val formattedTime: String
        get() {
            val minutes = remainingSeconds / 60
            val seconds = remainingSeconds % 60
            return String.format("%02d:%02d", minutes, seconds)
        }
}

data class RecipeUiState(
    val currentTab: AppNavTab = AppNavTab.DISCOVER,
    val searchQuery: String = "",
    val selectedCategory: Category = Category.ALL,
    val favoriteRecipeIds: Set<String> = setOf("braised_pork", "vongole_pasta"), // Default a couple favorites
    val selectedRecipe: Recipe? = null,
    val currentServings: Int = 2,
    val completedSteps: Set<Int> = emptySet(),
    val checkedIngredients: Set<String> = emptySet(),
    val shoppingItems: List<ShoppingItem> = emptyList(),
    val timerState: TimerUiState = TimerUiState()
)

class RecipeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(RecipeUiState())
    val uiState: StateFlow<RecipeUiState> = _uiState.asStateFlow()

    private val allRecipes: List<Recipe> = SampleData.recipes
    private var timerJob: Job? = null

    init {
        // Initialize sample shopping items from first favorite recipe
        val sampleRecipe = allRecipes.firstOrNull { it.id == "braised_pork" }
        if (sampleRecipe != null) {
            val initialShopping = sampleRecipe.ingredients.take(4).map { ing ->
                ShoppingItem(
                    id = "init_${ing.name}",
                    recipeTitle = sampleRecipe.title,
                    ingredientName = ing.name,
                    amountWithUnit = "${ing.getFormattedAmount(1.0)} ${ing.unit}",
                    isChecked = false
                )
            }
            _uiState.update { it.copy(shoppingItems = initialShopping) }
        }
    }

    // Navigation
    fun setTab(tab: AppNavTab) {
        _uiState.update { it.copy(currentTab = tab) }
    }

    // Search and Category Filters
    fun setSearchQuery(query: String) {
        _uiState.update { it.copy(searchQuery = query) }
    }

    fun setCategory(category: Category) {
        _uiState.update { it.copy(selectedCategory = category) }
    }

    // Favorites
    fun toggleFavorite(recipeId: String) {
        _uiState.update { state ->
            val updated = if (state.favoriteRecipeIds.contains(recipeId)) {
                state.favoriteRecipeIds - recipeId
            } else {
                state.favoriteRecipeIds + recipeId
            }
            state.copy(favoriteRecipeIds = updated)
        }
    }

    // Recipe Details
    fun openRecipe(recipe: Recipe) {
        _uiState.update {
            it.copy(
                selectedRecipe = recipe,
                currentServings = recipe.defaultServings,
                completedSteps = emptySet(),
                checkedIngredients = emptySet()
            )
        }
    }

    fun closeRecipe() {
        _uiState.update { it.copy(selectedRecipe = null) }
    }

    fun updateServings(newServings: Int) {
        if (newServings in 1..20) {
            _uiState.update { it.copy(currentServings = newServings) }
        }
    }

    fun toggleStepCompleted(stepNumber: Int) {
        _uiState.update { state ->
            val updated = if (state.completedSteps.contains(stepNumber)) {
                state.completedSteps - stepNumber
            } else {
                state.completedSteps + stepNumber
            }
            state.copy(completedSteps = updated)
        }
    }

    fun toggleIngredientChecked(ingredientName: String) {
        _uiState.update { state ->
            val updated = if (state.checkedIngredients.contains(ingredientName)) {
                state.checkedIngredients - ingredientName
            } else {
                state.checkedIngredients + ingredientName
            }
            state.copy(checkedIngredients = updated)
        }
    }

    // Shopping List
    fun addRecipeToShoppingList(recipe: Recipe, servingsMultiplier: Double) {
        val newItems = recipe.ingredients.map { ing ->
            ShoppingItem(
                id = "${recipe.id}_${ing.name}_${System.currentTimeMillis()}",
                recipeTitle = recipe.title,
                ingredientName = ing.name,
                amountWithUnit = "${ing.getFormattedAmount(servingsMultiplier)} ${ing.unit}",
                isChecked = false
            )
        }
        _uiState.update { state ->
            state.copy(shoppingItems = state.shoppingItems + newItems)
        }
    }

    fun toggleShoppingItem(itemId: String) {
        _uiState.update { state ->
            val updatedList = state.shoppingItems.map { item ->
                if (item.id == itemId) item.copy(isChecked = !item.isChecked) else item
            }
            state.copy(shoppingItems = updatedList)
        }
    }

    fun removeShoppingItem(itemId: String) {
        _uiState.update { state ->
            state.copy(shoppingItems = state.shoppingItems.filterNot { it.id == itemId })
        }
    }

    fun clearCheckedShoppingItems() {
        _uiState.update { state ->
            state.copy(shoppingItems = state.shoppingItems.filterNot { it.isChecked })
        }
    }

    // Cooking Timer Controls
    fun startTimerForStep(minutes: Int, title: String) {
        timerJob?.cancel()
        val totalSecs = minutes * 60
        _uiState.update {
            it.copy(
                timerState = TimerUiState(
                    isVisible = true,
                    isRunning = true,
                    remainingSeconds = totalSecs,
                    totalSeconds = totalSecs,
                    title = title
                )
            )
        }
        runTimerCountdown()
    }

    fun openManualTimer() {
        if (!_uiState.value.timerState.isVisible) {
            _uiState.update {
                it.copy(
                    timerState = TimerUiState(
                        isVisible = true,
                        isRunning = false,
                        remainingSeconds = 300,
                        totalSeconds = 300,
                        title = "自訂烹飪計時"
                    )
                )
            }
        } else {
            _uiState.update { it.copy(timerState = it.timerState.copy(isVisible = true)) }
        }
    }

    fun toggleTimerRunning() {
        val currentState = _uiState.value.timerState
        if (currentState.isRunning) {
            timerJob?.cancel()
            _uiState.update { it.copy(timerState = currentState.copy(isRunning = false)) }
        } else {
            if (currentState.remainingSeconds > 0) {
                _uiState.update { it.copy(timerState = currentState.copy(isRunning = true)) }
                runTimerCountdown()
            }
        }
    }

    fun addTimerMinute(minutesToAdd: Int = 1) {
        val additionalSeconds = minutesToAdd * 60
        _uiState.update {
            val newRemaining = it.timerState.remainingSeconds + additionalSeconds
            val newTotal = it.timerState.totalSeconds + additionalSeconds
            it.copy(timerState = it.timerState.copy(remainingSeconds = newRemaining, totalSeconds = newTotal))
        }
    }

    fun resetTimer() {
        timerJob?.cancel()
        _uiState.update {
            it.copy(
                timerState = it.timerState.copy(
                    remainingSeconds = it.timerState.totalSeconds,
                    isRunning = false
                )
            )
        }
    }

    fun closeTimerDialog() {
        _uiState.update { it.copy(timerState = it.timerState.copy(isVisible = false)) }
    }

    private fun runTimerCountdown() {
        timerJob = viewModelScope.launch {
            while (true) {
                delay(1000L)
                val currentRemaining = _uiState.value.timerState.remainingSeconds
                if (currentRemaining > 1) {
                    _uiState.update {
                        it.copy(timerState = it.timerState.copy(remainingSeconds = currentRemaining - 1))
                    }
                } else {
                    _uiState.update {
                        it.copy(
                            timerState = it.timerState.copy(
                                remainingSeconds = 0,
                                isRunning = false
                            )
                        )
                    }
                    break
                }
            }
        }
    }

    // Filtered lists
    fun getFilteredRecipes(): List<Recipe> {
        val state = _uiState.value
        return allRecipes.filter { recipe ->
            val matchesCategory = (state.selectedCategory == Category.ALL) ||
                    (recipe.category == state.selectedCategory)

            val matchesSearch = if (state.searchQuery.isBlank()) {
                true
            } else {
                val q = state.searchQuery.trim().lowercase()
                recipe.title.lowercase().contains(q) ||
                        recipe.subtitle.lowercase().contains(q) ||
                        recipe.description.lowercase().contains(q) ||
                        recipe.tags.any { it.lowercase().contains(q) } ||
                        recipe.ingredients.any { it.name.lowercase().contains(q) }
            }
            matchesCategory && matchesSearch
        }
    }

    fun getFavoriteRecipes(): List<Recipe> {
        val favIds = _uiState.value.favoriteRecipeIds
        return allRecipes.filter { favIds.contains(it.id) }
    }
}
