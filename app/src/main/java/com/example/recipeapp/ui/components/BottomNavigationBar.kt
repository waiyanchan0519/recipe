package com.example.recipeapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recipeapp.viewmodel.AppNavTab

@Composable
fun BottomNavigationBar(
    currentTab: AppNavTab,
    onTabSelected: (AppNavTab) -> Unit,
    favoriteCount: Int,
    shoppingCount: Int,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = 6.dp
    ) {
        // Tab 1: Discover
        NavigationBarItem(
            selected = currentTab == AppNavTab.DISCOVER,
            onClick = { onTabSelected(AppNavTab.DISCOVER) },
            icon = {
                Icon(
                    imageVector = if (currentTab == AppNavTab.DISCOVER) Icons.Filled.Restaurant else Icons.Outlined.Restaurant,
                    contentDescription = "食譜探索"
                )
            },
            label = { Text("食譜探索") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                selectedTextColor = MaterialTheme.colorScheme.primary,
                indicatorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)
            )
        )

        // Tab 2: Favorites
        NavigationBarItem(
            selected = currentTab == AppNavTab.FAVORITES,
            onClick = { onTabSelected(AppNavTab.FAVORITES) },
            icon = {
                BadgedBox(
                    badge = {
                        if (favoriteCount > 0) {
                            Badge { Text(favoriteCount.toString()) }
                        }
                    }
                ) {
                    Icon(
                        imageVector = if (currentTab == AppNavTab.FAVORITES) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                        contentDescription = "我的收藏"
                    )
                }
            },
            label = { Text("我的收藏") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                selectedTextColor = MaterialTheme.colorScheme.primary,
                indicatorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)
            )
        )

        // Tab 3: Shopping / Prep List
        NavigationBarItem(
            selected = currentTab == AppNavTab.SHOPPING_LIST,
            onClick = { onTabSelected(AppNavTab.SHOPPING_LIST) },
            icon = {
                BadgedBox(
                    badge = {
                        if (shoppingCount > 0) {
                            Badge { Text(shoppingCount.toString()) }
                        }
                    }
                ) {
                    Icon(
                        imageVector = if (currentTab == AppNavTab.SHOPPING_LIST) Icons.Filled.ShoppingCart else Icons.Outlined.ShoppingCart,
                        contentDescription = "備料清單"
                    )
                }
            },
            label = { Text("備料清單") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                selectedTextColor = MaterialTheme.colorScheme.primary,
                indicatorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)
            )
        )
    }
}
