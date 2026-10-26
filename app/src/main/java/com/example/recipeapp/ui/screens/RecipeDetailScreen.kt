package com.example.recipeapp.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipeapp.model.CookingStep
import com.example.recipeapp.model.Ingredient
import com.example.recipeapp.model.Recipe

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun RecipeDetailScreen(
    recipe: Recipe,
    isFavorite: Boolean,
    currentServings: Int,
    completedSteps: Set<Int>,
    checkedIngredients: Set<String>,
    onBackClick: () -> Unit,
    onFavoriteToggle: () -> Unit,
    onServingsChange: (Int) -> Unit,
    onToggleStep: (Int) -> Unit,
    onToggleIngredient: (String) -> Unit,
    onAddToShoppingList: (Recipe, Double) -> Unit,
    onStartTimer: (Int, String) -> Unit,
    modifier: Modifier = Modifier
) {
    val servingsMultiplier = currentServings.toDouble() / recipe.defaultServings.toDouble()
    val completedCount = completedSteps.size
    val totalSteps = recipe.steps.size
    val progress = if (totalSteps > 0) completedCount.toFloat() / totalSteps.toFloat() else 0f

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = recipe.title,
                        maxLines = 1,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = onFavoriteToggle) {
                        Icon(
                            imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            contentDescription = "Favorite",
                            tint = if (isFavorite) Color(0xFFE53935) else MaterialTheme.colorScheme.onSurface
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Hero Visual Box
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .background(
                            Brush.verticalGradient(
                                listOf(
                                    Color(recipe.primaryColorHex),
                                    Color(recipe.secondaryColorHex)
                                )
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = recipe.emoji,
                        fontSize = 80.sp
                    )
                }
            }

            // Title, Subtitle, Tags & Description
            item {
                Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                    Text(
                        text = recipe.title,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = recipe.subtitle,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = recipe.description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        lineHeight = 22.sp
                    )
                    Spacer(modifier = Modifier.height(12.dp))

                    // Tags
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        recipe.tags.forEach { tag ->
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = MaterialTheme.colorScheme.surfaceVariant
                            ) {
                                Text(
                                    text = "#$tag",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                                )
                            }
                        }
                    }
                }
            }

            // Quick Stats Card (Prep, Cook, Calories, Difficulty)
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 14.dp, horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        StatItem(label = "備料", value = "${recipe.prepTimeMinutes} 分鐘")
                        StatDivider()
                        StatItem(label = "烹飪", value = "${recipe.cookTimeMinutes} 分鐘")
                        StatDivider()
                        StatItem(label = "熱量", value = "${recipe.calories} 大卡")
                        StatDivider()
                        StatItem(label = "難易度", value = recipe.difficulty.label)
                    }
                }
            }

            // Servings Adjuster & Shopping List Action
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(
                                    text = "食材清單",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "點擊可劃掉已備好的食材",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }

                            // Servings Adjuster
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .background(
                                        MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
                                        RoundedCornerShape(20.dp)
                                    )
                                    .padding(horizontal = 6.dp, vertical = 4.dp)
                            ) {
                                FilledTonalIconButton(
                                    onClick = { onServingsChange(currentServings - 1) },
                                    enabled = currentServings > 1,
                                    modifier = Modifier.size(28.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Remove,
                                        contentDescription = "Decrease",
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                                Text(
                                    text = "$currentServings 人份",
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(horizontal = 10.dp)
                                )
                                FilledTonalIconButton(
                                    onClick = { onServingsChange(currentServings + 1) },
                                    enabled = currentServings < 20,
                                    modifier = Modifier.size(28.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Add,
                                        contentDescription = "Increase",
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(14.dp))

                        // Ingredients list
                        recipe.ingredients.forEach { ingredient ->
                            val isChecked = checkedIngredients.contains(ingredient.name)
                            val formattedAmount = ingredient.getFormattedAmount(servingsMultiplier)

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(8.dp))
                                    .clickable { onToggleIngredient(ingredient.name) }
                                    .padding(vertical = 6.dp, horizontal = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Checkbox(
                                    checked = isChecked,
                                    onCheckedChange = { onToggleIngredient(ingredient.name) },
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = MaterialTheme.colorScheme.primary
                                    ),
                                    modifier = Modifier.size(28.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = ingredient.name,
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontWeight = if (isChecked) FontWeight.Normal else FontWeight.Medium,
                                        textDecoration = if (isChecked) TextDecoration.LineThrough else TextDecoration.None,
                                        color = if (isChecked) MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f) else MaterialTheme.colorScheme.onSurface
                                    )
                                    if (ingredient.note.isNotBlank()) {
                                        Text(
                                            text = ingredient.note,
                                            style = MaterialTheme.typography.labelSmall,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    }
                                }
                                Text(
                                    text = "$formattedAmount ${ingredient.unit}",
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.SemiBold,
                                    color = if (isChecked) MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f) else MaterialTheme.colorScheme.primary
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        // Button to add all to shopping list
                        OutlinedButton(
                            onClick = { onAddToShoppingList(recipe, servingsMultiplier) },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.AddShoppingCart,
                                contentDescription = null,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("將食材加入備料清單")
                        }
                    }
                }
            }

            // Step-by-Step Cooking Guide with Progress
            item {
                Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "料理步驟",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "進度 $completedCount / $totalSteps 步",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    LinearProgressIndicator(
                        progress = { progress },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(6.dp)
                            .clip(RoundedCornerShape(3.dp)),
                        color = MaterialTheme.colorScheme.primary,
                        trackColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                }
            }

            // Steps
            itemsIndexed(recipe.steps) { index, step ->
                val isCompleted = completedSteps.contains(step.stepNumber)
                StepItemCard(
                    step = step,
                    isCompleted = isCompleted,
                    onToggleComplete = { onToggleStep(step.stepNumber) },
                    onStartTimer = { minutes -> onStartTimer(minutes, "${recipe.title} - 步驟 ${step.stepNumber}") }
                )
            }

            // Chef's Secrets Tips Card
            if (recipe.chefTips.isNotEmpty()) {
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        shape = RoundedCornerShape(18.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                        )
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.Lightbulb,
                                    contentDescription = "Tips",
                                    tint = Color(0xFFFFA000),
                                    modifier = Modifier.size(22.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "主廚私房美味秘訣",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            recipe.chefTips.forEach { tip ->
                                Row(
                                    modifier = Modifier.padding(vertical = 4.dp),
                                    verticalAlignment = Alignment.Top
                                ) {
                                    Text(
                                        text = "• ",
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = MaterialTheme.colorScheme.primary,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = tip,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun StepItemCard(
    step: CookingStep,
    isCompleted: Boolean,
    onToggleComplete: () -> Unit,
    onStartTimer: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable { onToggleComplete() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isCompleted) MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f) else MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = if (isCompleted) 0.dp else 1.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(28.dp)
                            .background(
                                if (isCompleted) Color(0xFF43A047) else MaterialTheme.colorScheme.primary,
                                CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        if (isCompleted) {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = "Done",
                                tint = Color.White,
                                modifier = Modifier.size(16.dp)
                            )
                        } else {
                            Text(
                                text = step.stepNumber.toString(),
                                color = Color.White,
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = step.title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        textDecoration = if (isCompleted) TextDecoration.LineThrough else TextDecoration.None
                    )
                }

                Checkbox(
                    checked = isCompleted,
                    onCheckedChange = { onToggleComplete() },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xFF43A047)
                    )
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = step.description,
                style = MaterialTheme.typography.bodyMedium,
                color = if (isCompleted) MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f) else MaterialTheme.colorScheme.onSurface,
                lineHeight = 22.sp
            )

            // Step tip
            if (step.tip != null) {
                Spacer(modifier = Modifier.height(8.dp))
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "💡 秘訣: ${step.tip}",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                    )
                }
            }

            // Step Timer Button
            if (step.timerMinutes != null) {
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = { onStartTimer(step.timerMinutes) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Default.Timer,
                        contentDescription = "Timer",
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("啟動 ${step.timerMinutes} 分鐘烹調計時")
                }
            }
        }
    }
}

@Composable
fun StatItem(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun StatDivider() {
    Box(
        modifier = Modifier
            .width(1.dp)
            .height(28.dp)
            .background(MaterialTheme.colorScheme.surfaceVariant)
    )
}
