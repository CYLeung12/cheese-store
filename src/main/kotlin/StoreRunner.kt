import model.Cheese
import model.Chutney
import model.SavouryBiscuit

class StoreRunner {
    val storeInventory = StoreInventory()
    val productHandler = ProductHandler()

    fun mainStart() {
        while (true) {
            when (UIManager.getWelcomeMessageInput()) {
                "1" -> createProduct()
                "2" -> {
                    if (StoreInventory.productList.isEmpty()) {
                        println("Product list is empty.")
                    } else {
                        println(StoreInventory.productList)
                    }
                }
                "3" -> break;
            }
        }
    }

    private fun createProduct() {
        when (UIManager.getProductTypeChoice()) {
            "1" -> storeInventory.addProduct(
                Cheese(
                    name = UIManager.getInput("name", false).toString(),
                    price = UIManager.getInput("price", false).toString().toDouble(),
                    weight = UIManager.getInput("weight", false).toString().toDouble(),
                    isVege = UIManager.getInput("vegeterian", true).toString().toBoolean(),
                )
            )

            "2" -> storeInventory.addProduct(
                SavouryBiscuit(
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
            "4" -> productHandler.createNewHamper(
                name = UIManager.getInput("name", false).toString(),
                price = UIManager.getInput("price", false).toString().toDouble()
            )
            "5" -> {
                if (StoreInventory.productList.isEmpty() || StoreInventory.productList.filterIsInstance<Cheese>()
                        .isEmpty()
                ) {
                    println("There is no Cheese product. Please add at lease one Cheese product.")
                } else {
                    productHandler.createCheeseBlock()
                }

            }

        }

    }
}