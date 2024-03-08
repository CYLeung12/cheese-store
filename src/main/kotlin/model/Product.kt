package model

import StoreInventory
import com.fasterxml.jackson.annotation.*
import kotlinx.serialization.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes(value = [
    JsonSubTypes.Type(Cheese::class, name = "model.Cheese"),
    JsonSubTypes.Type(SavouryBiscuit::class, name = "model.SavouryBiscuit"),
    JsonSubTypes.Type(Chutney::class, name = "model.Chutney"),
    JsonSubTypes.Type(Hamper::class, name = "model.Hamper") ]
)
interface Product {
    val id: Int
    val name: String
    val price: Double
}

@Serializable
data class Cheese(
    @JsonProperty("id")
    override val id: Int = StoreInventory.productList.size + 1,
    @JsonProperty("name")
    override val name: String,
    @JsonProperty("price")
    override val price: Double,
    @JsonProperty("weight")
    val weight: Double,
    @JsonProperty("isVege")
    val isVege: Boolean
) : Product

@Serializable
data class SavouryBiscuit(
    @JsonProperty("id")
    override val id: Int = StoreInventory.productList.size + 1,
    @JsonProperty("name")
    override val name: String,
    @JsonProperty("price")
    override val price: Double,
    @JsonProperty("packetSize")
    val packetSize: Int
) : Product

@Serializable
data class Chutney(
    override val id: Int = StoreInventory.productList.size + 1,
    override val name: String,
    override val price: Double,
    val weight: Double
) : Product

@Serializable
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
