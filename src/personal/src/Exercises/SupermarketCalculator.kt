package personal.src.Exercises

import kotlin.math.roundToInt

abstract class ProductCategories {

    abstract val vatRate: Double
}

abstract class PrimaryNeeds : ProductCategories()

abstract class SecondaryNeeds : ProductCategories()

abstract class LuxuryProducts : ProductCategories()

open class BreadCategory(val price: Double) : PrimaryNeeds() {

    final override val vatRate: Double = 0.08
    val vat: Double = price * vatRate

}

open class MilkCategory(val price: Double) : PrimaryNeeds() {
    final override val vatRate: Double = 0.08
    val vat: Double = price * vatRate

}

open class SnacksCategory(val price: Double) : SecondaryNeeds() {
    final override val vatRate: Double = 0.18
    val vat: Double = price * vatRate

}

open class BevarageCategory(val price: Double) : SecondaryNeeds() {
    final override val vatRate: Double = 0.18
    val vat: Double = price * vatRate

}

open class TobaccoProducts(val price: Double) : LuxuryProducts() {
    final override val vatRate: Double = 0.28
    val vat: Double = price * vatRate

}

open class TechnologyCategory(val price: Double) : LuxuryProducts() {
    final override val vatRate: Double = 0.28
    val vat: Double = price * vatRate

}


fun main() {

    val bread = BreadCategory(3.0)

    val bagel = BreadCategory(4.5)

    val milk = MilkCategory(15.0)

    val chips = SnacksCategory(12.5)

    val xphone13 = TechnologyCategory(850.0)


    val totalPrice = xphone13.price + chips.price + milk.price + bread.price + bagel.price
    val totalVatAmount = xphone13.vat + chips.vat + bread.vat + bagel.vat + milk.vat
    val grandTotal = totalPrice + totalVatAmount

    println("Total amount before VAT: ${totalPrice.roundToInt()} TL")
    println("Total VAT amount: ${totalVatAmount.roundToInt()} TL")
    println("Grand total: ${grandTotal.roundToInt()} TL")


}
