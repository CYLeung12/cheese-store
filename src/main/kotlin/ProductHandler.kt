import model.Hampers

class ProductHandler {
    fun creatNewHamper() : Hampers{
        val newHamper = Hampers(
            name = UIManager.getInput("name", false).toString(),
            price = UIManager.getInput("price", false).toString().toDouble()
        )
        while (true) {
            println(StoreInventory.productList)
            println("Please enter the product id that you want to end to the Hamper, or enter \"e\" to quit")
            val productIdForHamper = readln()
            if (productIdForHamper.lowercase() == "e")
                break
            newHamper.buildHamperProductList(productIdForHamper.toInt())
        }
        println("""This is the new Hamper product: $newHamper""")
        return newHamper
    }

    fun createCheeseBlock() {
        // TODO handle the cheese block creation
        UIManager.getInput("Cheese Block Weight", false)

    }

    private fun Hampers.buildHamperProductList(productId: Int) {
        this.hamperProductList.add(StoreInventory.productList[productId - 1])
    }
}