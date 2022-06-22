package personal.src.Exercises
/*
    Bu alistirmada bir "Car" sinifi olusturup, farkli modeller icin nesne olusturdum.
    Sonrasinda bu sinif icinde arac degeri hesaplayan bir fonksiyon yazdim.
    Sinifin disindan "extension function" kullanarak sinifa bir fonksiyon ekledim.
    Ekledigim fonksiyonu ve icerideki fonksiyonu olusturdugum nesneler icin cagirdim.

 */

class Car constructor(year: Int, maxSpeed: Int) {

    private var mMaxSpeed: Int
    private var mYear: Int

    init {
        mMaxSpeed = maxSpeed
        mYear = year
        println("Primary constructor created.")
    }

    constructor(model: String, year: Int, color: String, maxSpeed: Int) : this(2010, maxSpeed = 120) {
        this.mMaxSpeed = maxSpeed
        this.mYear = year
        println("1st secondary constructor created.")
    }

    constructor(model: String, color: String, year: Int, maxSpeed: Int, madeOf: String) : this(2010, maxSpeed = 120) {
        this.mMaxSpeed = maxSpeed
        this.mYear = year
        println("2nd secondary constructor created.")
    }

    fun sellingPrice(): Int {
        if (mYear >= 2010 && mMaxSpeed > 120) {
            println("Arabanın bugünkü degeri: 200_000 TL")
            println("--------------------------------")
            return 200_000

        } else if (mYear >= 2010 && mMaxSpeed <= 120) {
            println("Arabanın bugünkü degeri: 150_000 TL")
            println("--------------------------------")
            return 150_000

        } else if (mYear < 2010 && mMaxSpeed > 120) {
            println("Arabanın bugünkü degeri: 175_000 TL")
            println("--------------------------------")
            return 175_000

        } else if (mYear < 2010 && mMaxSpeed <= 120) {
            println("Arabanın bugünkü degeri: 125_000 TL")
            println("--------------------------------")
            return 125_000
        } else {
            println("Arac hurda sinifinda degerlendirildi, degeri: 100_000 TL")
            println("--------------------------------")
            return 100_000
        }
    }
}

fun main() {

    val Focus = Car("Ford_Focus", 2012, "grey", 150)
    Focus.sellingPrice()

    val Fiesta = Car(2012, 120)
    Fiesta.sellingPrice()

    val Megane = Car(2010, 150)
    Megane.sellingPrice()

    val Doblo = Car(2010, 120)
    Doblo.sellingPrice()

    val Clio = Car(2009, 150)
    Clio.sellingPrice()

    val Ibiza = Car(2009, 120)
    Ibiza.sellingPrice()

    val Fabia = Car(1990,100)
    Fabia.sellingPrice()
    println("================================================")

    fun Car.sell() {
        println("Arabaniz ${this.sellingPrice()} TL karsiliginda satildi.")
        println("================================================")

    }

    Ibiza.sell()
    Fabia.sell()

}
