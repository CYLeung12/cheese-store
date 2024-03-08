import model.Cheese
import model.Product

object UIManager {
    fun getWelcomeMessageInput(): String {
        val welcomeMessage = """
            |Please choose one of the followings options by providing 1-3:
            |   (1): Add a Product 
            |   (2): View all product
            |   (3): Exit
        """.trimMargin()
        println(welcomeMessage)
        return readln()
    }

    fun getProductTypeChoice(): String {
        val productTypeMessage = """
            |Please choose from the following product type that you want to create by providing 1-4:
            |   (1): Add a Cheese
            |   (2): Add a Savoury Biscuit
            |   (3): Add a Chutney
            |   (4): Add a Hamper
            |   (5): Generate a Cheese Block
        """.trimMargin()
        println(productTypeMessage)
        return readln()
    }

    fun getInput(property: String, isBoolean: Boolean): Any {
        return if (!isBoolean) {
            println("Please enter the $property")
            readln()
        } else {
            println("Is it $property, please enter true or false")
            readln()
        }
    }

    fun getCheeseTypeForBlock(cheeseList: List<Cheese>): Cheese {
        println(cheeseList)
        val cheeseID = getInput("ID of the Cheese for Cheese Block:", false).toString().toInt()
        println(cheeseList[cheeseID as Int - 1])
        return cheeseList[cheeseID as Int - 1]
    }
}