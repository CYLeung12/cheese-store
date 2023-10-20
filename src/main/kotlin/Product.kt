interface Product {
    val name: String
    val price: Double
}

data class Cheeses(
    override val name: String,
    override val price: Double,
    val weight: Double,
    val isVege: Boolean
) : Product

data class SavouryBiscuits(
    override val name: String,
    override val price: Double,
    val packetSize: Int
) : Product

data class Hampers(
    override val name: String,
    override val price: Double,
    val productList: List<Product>
) : Product {
    fun getSaving(): Double {
        var originalPrice = 0.0
        this.productList.forEach{originalPrice += it.price}
        return originalPrice - this.price
    }
}