package model

import StoreInventory

data class CheeseBlock(
    val name: String = "",
    val pricePerKg: Double = 0.0
) {
    fun getCheeseBlock(cheese: Cheese, weight: Double): Cheese{
        return Cheese(
            name = name,
            price = pricePerKg,
            weight = weight,
            isVege = cheese.isVege
        )
    }
}