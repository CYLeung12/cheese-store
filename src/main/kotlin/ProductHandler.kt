import model.Cheese
import model.CheeseBlock
import model.Hamper
import model.Product

class ProductHandler {
    fun createNewHamper(name: String, price: Double) : Hamper {
        val newHamper = Hamper(name = name, price = price);

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


    private fun Hamper.buildHamperProductList(productId: Int) {
        this.hamperProductList.add(StoreInventory.productList[productId - 1])
    }

    fun createCheeseBlock() {
        println(StoreInventory.productList.filterIsInstance<Cheese>())
        val cheeseID = UIManager.getInput("ID of the Cheese for Cheese Block:", false).toString().toInt()
        val cheese = StoreInventory.productList.filter { product -> product.id == cheeseID }.single()
        val name = UIManager.getInput("Cheese Block Name", false).toString()
        val weight = UIManager.getInput("Cheese Block Weight", false).toString().toDouble()
        val cheeseBlock = CheeseBlock(
            name = name,
            pricePerKg = cheese.price / weight
        )
        println("Cheese Block has created: $cheeseBlock")
    }
}