package com.example.recipeapp.model

enum class Difficulty(val label: String, val stars: String) {
    EASY("新手入門", "★☆☆"),
    MEDIUM("家常進階", "★★☆"),
    HARD("大廚挑戰", "★★★")
}

enum class Category(val id: String, val title: String, val icon: String) {
    ALL("all", "全部", "🍽️"),
    CHINESE("chinese", "經典中菜", "🥢"),
    WESTERN("western", "異國料理", "🍝"),
    JAPANESE("japanese", "日韓和風", "🍱"),
    BAKING("baking", "甜點烘焙", "🧁"),
    FITNESS("fitness", "減脂輕食", "🥗"),
    QUICK("quick", "快手省時", "⏱️")
}

data class Ingredient(
    val name: String,
    val baseAmount: Double,
    val unit: String,
    val note: String = ""
) {
    fun getFormattedAmount(multiplier: Double): String {
        val calculated = baseAmount * multiplier
        return if (calculated <= 0.0) {
            ""
        } else if (calculated % 1.0 == 0.0) {
            calculated.toInt().toString()
        } else {
            String.format("%.1f", calculated).trimEnd('0').trimEnd('.')
        }
    }
}

data class CookingStep(
    val stepNumber: Int,
    val title: String,
    val description: String,
    val timerMinutes: Int? = null,
    val tip: String? = null
)

data class Recipe(
    val id: String,
    val title: String,
    val subtitle: String,
    val description: String,
    val category: Category,
    val emoji: String,
    val prepTimeMinutes: Int,
    val cookTimeMinutes: Int,
    val defaultServings: Int = 2,
    val difficulty: Difficulty,
    val calories: Int,
    val rating: Double,
    val reviewCount: Int,
    val tags: List<String>,
    val ingredients: List<Ingredient>,
    val steps: List<CookingStep>,
    val chefTips: List<String>,
    val primaryColorHex: Long = 0xFFFF7043L,
    val secondaryColorHex: Long = 0xFFFFB74DL
) {
    val totalTimeMinutes: Int
        get() = prepTimeMinutes + cookTimeMinutes
}

data class ShoppingItem(
    val id: String,
    val recipeTitle: String,
    val ingredientName: String,
    val amountWithUnit: String,
    val isChecked: Boolean = false
)
