package model

import StoreInventory
import kotlinx.serialization.Serializable

@Serializable
sealed interface Product {
    val id: Int
    val name: String
    val price: Double
}

@Serializable
data class Cheese(
    override val id: Int = StoreInventory.productList.size + 1,
    override val name: String,
    override val price: Double,
    val weight: Double,
    val isVege: Boolean
) : Product

@Serializable
data class SavouryBiscuit(
    override val id: Int = StoreInventory.productList.size + 1,
    override val name: String,
    override val price: Double,
    val packetSize: Int
) : Product

@Serializable
data class Chutney(
    override val id: Int = StoreInventory.productList.size + 1,
    override val name: String,
    override val price: Double,
    val weight: Double
) : Product

@Serializable
data class Hamper(
    override val id: Int = StoreInventory.productList.size + 1,
    override val name: String,
    override val price: Double,
    val hamperProductList: MutableList<Product> = ArrayList()
) : Product {
    fun getSaving(): Double {
        var originalPrice = 0.0
        this.hamperProductList.forEach{originalPrice += it.price}
        return originalPrice - this.price
    }
}