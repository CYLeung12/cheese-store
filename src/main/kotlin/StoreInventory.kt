import model.Product

class StoreInventory {
    companion object Inventory {
        val productList: MutableList<Product> = ArrayList()
    }

    fun addProduct(product: Product) {
        productList.add(product)
        //TODO use Java object serialisation to write product data to a file and read it back in when the program starts up.
    }
}