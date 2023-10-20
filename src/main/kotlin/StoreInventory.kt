class StoreInventory {
    companion object Inventory {
        val productList: MutableList<Product> = ArrayList()
    }

    fun addProduct(product: Product) {
        productList.add(product)
    }

}