package com.example.recipeapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.recipeapp.ui.components.BottomNavigationBar
import com.example.recipeapp.ui.components.CookingTimerDialog
import com.example.recipeapp.ui.screens.FavoritesScreen
import com.example.recipeapp.ui.screens.HomeScreen
import com.example.recipeapp.ui.screens.RecipeDetailScreen
import com.example.recipeapp.ui.screens.ShoppingListScreen
import com.example.recipeapp.ui.theme.RecipeAppTheme
import com.example.recipeapp.viewmodel.AppNavTab
import com.example.recipeapp.viewmodel.RecipeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecipeAppTheme {
                MainRecipeApp()
            }
        }
    }
}

@Composable
fun MainRecipeApp(
    viewModel: RecipeViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val filteredRecipes = viewModel.getFilteredRecipes()
    val favoriteRecipes = viewModel.getFavoriteRecipes()
    val context = LocalContext.current

    // Handle system back button when recipe detail is open
    BackHandler(enabled = uiState.selectedRecipe != null) {
        viewModel.closeRecipe()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        if (uiState.selectedRecipe != null) {
            val recipe = uiState.selectedRecipe!!
            RecipeDetailScreen(
                recipe = recipe,
                isFavorite = uiState.favoriteRecipeIds.contains(recipe.id),
                currentServings = uiState.currentServings,
                completedSteps = uiState.completedSteps,
                checkedIngredients = uiState.checkedIngredients,
                onBackClick = { viewModel.closeRecipe() },
                onFavoriteToggle = { viewModel.toggleFavorite(recipe.id) },
                onServingsChange = { viewModel.updateServings(it) },
                onToggleStep = { viewModel.toggleStepCompleted(it) },
                onToggleIngredient = { viewModel.toggleIngredientChecked(it) },
                onAddToShoppingList = { rec, mult ->
                    viewModel.addRecipeToShoppingList(rec, mult)
                    Toast.makeText(context, "已將食材加入備料清單！", Toast.LENGTH_SHORT).show()
                },
                onStartTimer = { minutes, title ->
                    viewModel.startTimerForStep(minutes, title)
                }
            )
        } else {
            Scaffold(
                bottomBar = {
                    BottomNavigationBar(
                        currentTab = uiState.currentTab,
                        onTabSelected = { viewModel.setTab(it) },
                        favoriteCount = uiState.favoriteRecipeIds.size,
                        shoppingCount = uiState.shoppingItems.count { !it.isChecked }
                    )
                }
            ) { innerPadding ->
                Box(modifier = Modifier.padding(innerPadding)) {
                    when (uiState.currentTab) {
                        AppNavTab.DISCOVER -> {
                            HomeScreen(
                                recipes = filteredRecipes,
                                featuredRecipe = filteredRecipes.firstOrNull(),
                                searchQuery = uiState.searchQuery,
                                onSearchChange = { viewModel.setSearchQuery(it) },
                                selectedCategory = uiState.selectedCategory,
                                onCategoryChange = { viewModel.setCategory(it) },
                                favoriteIds = uiState.favoriteRecipeIds,
                                onFavoriteToggle = { viewModel.toggleFavorite(it) },
                                onRecipeClick = { viewModel.openRecipe(it) },
                                onOpenTimer = { viewModel.openManualTimer() }
                            )
                        }

                        AppNavTab.FAVORITES -> {
                            FavoritesScreen(
                                favoriteRecipes = favoriteRecipes,
                                onRecipeClick = { viewModel.openRecipe(it) },
                                onFavoriteToggle = { viewModel.toggleFavorite(it) },
                                onNavigateToDiscover = { viewModel.setTab(AppNavTab.DISCOVER) }
                            )
                        }

                        AppNavTab.SHOPPING_LIST -> {
                            ShoppingListScreen(
                                items = uiState.shoppingItems,
                                onToggleItem = { viewModel.toggleShoppingItem(it) },
                                onRemoveItem = { viewModel.removeShoppingItem(it) },
                                onClearChecked = { viewModel.clearCheckedShoppingItems() },
                                onNavigateToDiscover = { viewModel.setTab(AppNavTab.DISCOVER) }
                            )
                        }
                    }
                }
            }
        }

        // Global Cooking Timer Dialog
        CookingTimerDialog(
            timerState = uiState.timerState,
            onTogglePlayPause = { viewModel.toggleTimerRunning() },
            onAddMinute = { viewModel.addTimerMinute(1) },
            onReset = { viewModel.resetTimer() },
            onClose = { viewModel.closeTimerDialog() }
        )
    }
}
