import java.io.File
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun main(args: Array<String>) {
    Runtime.getRuntime().addShutdownHook(saveProductListOnExit);
    StoreRunner().mainStart()
}

// this function will run in the middle of a shutdown
var saveProductListOnExit = Thread {
    val json = Json.encodeToString(StoreInventory.productList)
    val fileName = "productList.txt"
    File("src/main/resources", fileName).writeText(json)
}
