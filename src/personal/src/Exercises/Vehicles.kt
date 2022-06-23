package personal.src.Exercises

/*
    Vehicle adinda bir parent class olusturuldu.
    Bu class icinde 3 farkli constructor tanimlandi.
    Bu class icinde 2 adet fonksiyon tanimlandi.

    Cars adinda bir child class olusturuldu
    Bu class icinde parent classtaki fonksiyonlardan biri override edildi.

    Ilgili classlar icin obje olusturup fonksiyonlar ile birlikte cagirildi.
 */

open class Vehicles(var brand: String, var year: Int){

    internal var mColor = " "
    internal var mMaxSpeed = 0

    constructor(brand: String, color: String, maxSpeed: Int) : this(" ", 2000 ){
        mColor = color
        mMaxSpeed = maxSpeed

        println(" $brand marka taşıt oluşturuldu -> 1")
    }

    constructor(brand: String) : this(" ", 2000){
        this.brand = brand
        mMaxSpeed = 150
        println("$brand marka tasit olusturuldu -> 2")
    }

    constructor(brand: String, year: Int, color: String): this(" ", 2000){
        this.brand = brand
        this.year = year
        println("$brand marka arac olusturuldu -> 3")

    }

    open fun calculateValue(): Int{
        if ( (year in 2001..2009) && (mMaxSpeed > 120) ){
            println("Aracin bugunku degeri 200_000 TL")
            return 200_000
        }
        else if ( (year in 2001..2009) && (mMaxSpeed <= 120) ){
            println("Aracin bugunku degeri 175_000 TL")
            return 175_000
        }
        else if( (year in 2010..2022) && (mMaxSpeed > 120) ){
            println("Aracin bugunku degeri 300_000 TL")
            return 300_000
        }
        else if( (year in 2010..2022) && (mMaxSpeed <= 120) ){
            println("Aracin bugunku degeri 250_000 TL")
            return 250_000
        }
        else if ( (year <= 2000) && (mMaxSpeed > 120) ){
            println("Aracin bugunku degeri 150_000 TL")
            return 150_000
        }
        else if ( (year <= 2000) && (mMaxSpeed <= 120) ){
            println("Aracin bugunku degeri 125_000 TL")
            return 125_000
        }
        else{
            return 0
        }
    }


    open fun buy(){
        println("$brand marka arac ${this.calculateValue()}TL karsiliginde satin alindi.")
        println("-------")
    }


}

open class Cars(brand: String) : Vehicles(brand, "Red", 120){

    val mBrand = brand

    override fun buy() {
        println("Yasinizi giriniz: ")
        val age = readLine()!!.toInt()

        if(age >= 18){
            println("${this.mBrand} marka arac ${this.calculateValue()}TL karsiliginde satin alindi.")
            println("-------")
        }else{
            println("18 yasindan kucuk kisiler arac alamaz!")
        }
    }

}






fun main() {

    val Fiesta = Vehicles("Ford")
    Fiesta.buy()

    val Kangoo = Vehicles("Renault", "Grey", 120 )
    Kangoo.buy()

    val Golf = Vehicles("Volkswagen",2020,"Red")
    Golf.buy()

    val Passat = Cars("Volkswagen")
    Passat.buy()


}