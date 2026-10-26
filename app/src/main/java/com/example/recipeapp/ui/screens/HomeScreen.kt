package com.example.recipeapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material.icons.filled.SearchOff
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipeapp.model.Category
import com.example.recipeapp.model.Recipe
import com.example.recipeapp.ui.components.CategoryChipBar
import com.example.recipeapp.ui.components.RecipeCard
import com.example.recipeapp.ui.components.TopSearchBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    recipes: List<Recipe>,
    featuredRecipe: Recipe?,
    searchQuery: String,
    onSearchChange: (String) -> Unit,
    selectedCategory: Category,
    onCategoryChange: (Category) -> Unit,
    favoriteIds: Set<String>,
    onFavoriteToggle: (String) -> Unit,
    onRecipeClick: (Recipe) -> Unit,
    onOpenTimer: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "🍳 美味食譜",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                    }
                },
                actions = {
                    FilledTonalIconButton(
                        onClick = onOpenTimer,
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Timer,
                            contentDescription = "烹調計時",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
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
            contentPadding = PaddingValues(bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // Search Input
            item {
                TopSearchBar(
                    query = searchQuery,
                    onQueryChange = onSearchChange
                )
            }

            // Category Chips Bar
            item {
                CategoryChipBar(
                    selectedCategory = selectedCategory,
                    onCategorySelected = onCategoryChange
                )
            }

            // Featured Hero Card (Shown only when not searching and category is ALL)
            if (searchQuery.isBlank() && selectedCategory == Category.ALL && featuredRecipe != null) {
                item {
                    FeaturedHeroCard(
                        recipe = featuredRecipe,
                        onClick = { onRecipeClick(featuredRecipe) }
                    )
                }
            }

            // Section Header
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp, vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.RestaurantMenu,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = if (searchQuery.isNotBlank()) "搜尋結果 (${recipes.size})" else "精選食譜 (${recipes.size})",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            // Recipe Items or Empty Search Result
            if (recipes.isEmpty()) {
                item {
                    EmptySearchState(
                        query = searchQuery,
                        onClear = {
                            onSearchChange("")
                            onCategoryChange(Category.ALL)
                        }
                    )
                }
            } else {
                items(recipes, key = { it.id }) { recipe ->
                    Box(modifier = Modifier.padding(horizontal = 16.dp)) {
                        RecipeCard(
                            recipe = recipe,
                            isFavorite = favoriteIds.contains(recipe.id),
                            onFavoriteToggle = { onFavoriteToggle(recipe.id) },
                            onClick = { onRecipeClick(recipe) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun FeaturedHeroCard(
    recipe: Recipe,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(22.dp))
            .clickable { onClick() },
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.horizontalGradient(
                        listOf(
                            Color(0xFFE65100),
                            Color(0xFFFFB300)
                        )
                    )
                )
                .padding(18.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Color.Black.copy(alpha = 0.25f)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.LocalFireDepartment,
                                contentDescription = null,
                                tint = Color(0xFFFFD54F),
                                modifier = Modifier.size(14.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "今日主廚推薦",
                                color = Color.White,
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = recipe.title,
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = recipe.subtitle,
                        color = Color.White.copy(alpha = 0.9f),
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 2
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "⏱️ ${recipe.totalTimeMinutes} 分鐘 • ${recipe.difficulty.label} • ★ ${recipe.rating}",
                        color = Color.White.copy(alpha = 0.95f),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Medium
                    )
                }

                Text(
                    text = recipe.emoji,
                    fontSize = 62.sp,
                    modifier = Modifier.padding(start = 12.dp)
                )
            }
        }
    }
}

@Composable
fun EmptySearchState(
    query: String,
    onClear: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.SearchOff,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.4f),
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "找不到「$query」的相關食譜",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "試試搜尋其他食材，如：牛肉、蛤蜊、義大利麵",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(18.dp))
        Button(onClick = onClear) {
            Text("清除搜尋篩選")
        }
    }
}
