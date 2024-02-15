package model

import StoreInventory

interface Product {
    val id: Int
    val name: String
    val price: Double
}

data class Cheese(
    override val id: Int = StoreInventory.productList.size + 1,
    override val name: String,
    override val price: Double,
    val weight: Double,
    val isVege: Boolean
) : Product

data class SavouryBiscuit(
    override val id: Int = StoreInventory.productList.size + 1,
    override val name: String,
    override val price: Double,
    val packetSize: Int
) : Product

data class Chutney(
    override val id: Int = StoreInventory.productList.size + 1,
    override val name: String,
    override val price: Double,
    val weight: Double
) : Product

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