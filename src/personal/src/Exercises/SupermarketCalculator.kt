package personal.src.Exercises

import kotlin.math.roundToInt

abstract class productCategories {

    abstract val VatRate: Double
}

abstract class primaryNeeds : productCategories()

abstract class secondaryNeeds : productCategories()

abstract class luxuryProducts : productCategories()

open class breadCategory(val price: Double) : primaryNeeds() {

    final override val VatRate: Double = 0.08
    val vat: Double = price * VatRate

}

open class milkCategory(val price: Double) : primaryNeeds() {
    override val VatRate: Double = 0.08
    val vat: Double = price * VatRate

}

open class snacksCategory(val price: Double) : secondaryNeeds() {
    override val VatRate: Double = 0.18
    val vat: Double = price * VatRate

}

open class bevarageCategory(val price: Double) : secondaryNeeds() {
    override val VatRate: Double = 0.18
    val vat: Double = price * VatRate

}

open class tobaccoProducts(val price: Double) : luxuryProducts() {
    override val VatRate: Double = 0.28
    val vat: Double = price * VatRate

}

open class technologyCategory(val price: Double) : luxuryProducts() {
    override val VatRate: Double = 0.28
    val vat: Double = price * VatRate

}


fun main() {

    val bread = breadCategory(3.0)

    val bagel = breadCategory(4.5)

    val milk = milkCategory(15.0)

    val chips = snacksCategory(12.5)

    val xphone13 = technologyCategory(850.0)


    val totalPrice = xphone13.price + chips.price + milk.price + bread.price + bagel.price
    val totalVatAmount = xphone13.vat + chips.vat + bread.vat + bagel.vat
    val grandTotal = totalPrice + totalVatAmount

    println("Total amount before VAT: ${totalPrice.roundToInt()} TL")
    println("Total VAT amount: ${totalVatAmount.roundToInt()} TL")
    println("Grand total: ${grandTotal.roundToInt()} TL")


}
