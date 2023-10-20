import model.Cheeses
import model.Chutney
import model.Hampers
import model.SavouryBiscuits

class StoreRunner {
    val storeInventory = StoreInventory()
    val productHandler = ProductHandler()


    fun mainStart() {
        while (true) {
            val welcomeMessageInput = UIManager.getWelcomeMessageInput()
            when (welcomeMessageInput) {
                "1" -> createProduct()
                "2" -> println(StoreInventory.productList)
            }
        }
    }

    fun createProduct() {
        val productTypeChoice = UIManager.getProductTypeChoice()
        when (productTypeChoice) {
            "1" -> storeInventory.addProduct(
                Cheeses(
                    name = UIManager.getInput("name", false).toString(),
                    price = UIManager.getInput("price", false).toString().toDouble(),
                    weight = UIManager.getInput("weight", false).toString().toDouble(),
                    isVege = UIManager.getInput("vegeterian", true).toString().toBoolean(),
                )
            )

            "2" -> storeInventory.addProduct(
                SavouryBiscuits(
                    name = UIManager.getInput("name", false).toString(),
                    price = UIManager.getInput("price", false).toString().toDouble(),
                    packetSize = UIManager.getInput("packet size", false).toString().toInt()
                )
            )

            "3" -> storeInventory.addProduct(
                Chutney(
                    name = UIManager.getInput("name", false).toString(),
                    price = UIManager.getInput("price", false).toString().toDouble(),
                    weight = UIManager.getInput("weight", false).toString().toDouble()
                )
            )
            "4" -> productHandler.creatNewHamper()

        }

    }


}