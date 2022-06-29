package personal.src.Exercises

fun main() {

    print("Brutten nete hesaplamak istediginiz maas tutarini girin: ")
    val grossSalary = readLine()!!.toDouble()

    val sgkPayment = 0.14 * grossSalary
    val unemployementPayment = if (0.01 * grossSalary < 375.30) {
        grossSalary * 0.01
    } else {
        375.30
    }
    val stampTax = 0.00759 * grossSalary

    var incomeTaxRate = 0.0
    var cumIncomeTaxMatrah = 0.0
    val incomeTaxMatrah = grossSalary - (sgkPayment + unemployementPayment)




    for (value: Int in 1..12) {
        println("$value. ay")
        if (cumIncomeTaxMatrah < 32_000) {
            incomeTaxRate = 0.15
        } else if (cumIncomeTaxMatrah >= 32_000 && cumIncomeTaxMatrah < 70_000) {
            incomeTaxRate = 0.20
        } else if (cumIncomeTaxMatrah >= 70_000 && cumIncomeTaxMatrah < 250_000) {
            incomeTaxRate = 0.27
        } else if (cumIncomeTaxMatrah >= 250_000 && cumIncomeTaxMatrah < 880_000) {
            incomeTaxRate = 0.35
        } else
            incomeTaxRate = 0.40

        val incomeTax = incomeTaxMatrah * incomeTaxRate
        println("income tax amount of this month: $incomeTax")

        cumIncomeTaxMatrah += incomeTaxMatrah
        println("cumulative income tax amount is : $cumIncomeTaxMatrah")

        val netSalary: Double =
            grossSalary - (+(sgkPayment) + (unemployementPayment) + (stampTax) + (incomeTax))
        println("net salary for this month: $netSalary\n-------------")


    }

}



