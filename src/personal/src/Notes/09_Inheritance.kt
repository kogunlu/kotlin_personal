package personal.src.Notes


/**
 *
 *                  Inheritance
 *
 */


//----------------------------------------------------------------------------------------------------------------------

/*

Ozetle bir parent class'in ozelliklerini (fonksiyon ya da degisken) alt siniflara (child class) aktarmaya denir.

Erisim duzenleyiciler;
open --> miras alinacak sinifin open olmasi gerekiyor. ( Javada tum siniflar zaten open )
final --> Kotlin'de default olarak siniflar final, yani miras alinamaz.
internal --> Yalnizca alt siniflarin erisebildigi tip



 */

//----------------------------------------------------------------------------------------------------------------------

open class Shape(val name: String) {                // open goruyoruz yani parent class

    internal var mColor: String =  " "                // default zaten public, istersek internal yapabiliriz buradaki gibi. Cunku alt siniftan erisim istiyoruz.
    open var mEdgeCount: Int = 0

    constructor(name: String, color: String) : this(name) {
        mColor = color
    }

    constructor(name: String, color: String, edgeCount: Int) : this(name) {
        mColor = color
        mEdgeCount = edgeCount
    }

    open fun drawShape() {
        println("Name: $name")
        println("Color: $mColor")
        println("EdgeCount: $mEdgeCount")
    }


    fun calculateArea(): Int = if (mEdgeCount != 0) {
        mEdgeCount * mEdgeCount
    } else {
        0
    }


}


//----------------------------------------------------------------------------------------------------------------------


class Rectangle(name: String) : Shape(name, "Red") {
    // miras almak icin : kullaniyoruz.
    // Miras aliyorsak miras alinacak min. 1 constructor almamiz gerekiyor.
    // Ya primary constructor ya da secondary constructor almamiz gerekli

    override fun drawShape() {
        // drawShape()
        // this.drawShape()
        super.drawShape()                                   // super.drawShape() --> ust siniftaki drawShape() 'in yaptigini yapmasi icin yazilir.
    }


    fun main() {
        // Asagidaki degisken ve fonksiyonlari miras aldik.
        calculateArea()
        drawShape()
        mColor
        mEdgeCount

        this.drawShape()      // -----> this kullanimi bu classi isaret eder
        super.drawShape()    // ----> super kullanimi bu class'taki degil, ust siniftaki fonksiyonu calistirir
    }

    override var mEdgeCount: Int                    // override edebilmek icin degisken ya da fonksiyonun open olmasi gerekiyor.
        get() = super.mEdgeCount                   // parent class 'takinden farkli bir is yapacak sekilde tekrar duzenlemek icin override ediyoruz.
        set(value) {}
}


//----------------------------------------------------------------------------------------------------------------------


open class Circle(name: String, color: String) : Shape(name) {

    open override fun drawShape() {
        super.drawShape()


        val circle = """
            
        CEMBER CIZDIK VARSAYALIM
        
        """.trimIndent()

        println(circle)
    }


}


//----------------------------------------------------------------------------------------------------------------------

open class Square(name: String, color: String, edgeCount: Int) : Shape(name, color, edgeCount) {

    final override fun drawShape() {
        // Final keyword koyarsak,
        // bunu miras alan bunun child class'inda bu fonksiyonun override edilmesini kapatmis oluruz

        val square = """
            
            *****************
            *               *
            *               *
            *               * 
            *****************
            
            """.trimIndent()
        println(square)
    }

}


//----------------------------------------------------------------------------------------------------------------------


class OneMeterSquare : Square("OneMeterSquare", "Blue", 4) {

    /*

    Asagidakileri override edemiyoruz cunku parent class'ta final olarak tanimladik.
    Bu fonksiyonlar cagrilabilir fakar overload edilemez.

    override fun drawShape(){
        super.drawShape()
        super.super.drawShape()
    }

    */

    fun main() {
        drawShape()             // cagirabildik, fakat override edemedik
    }

}


//----------------------------------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------------------------------

fun main() {

    val shape = Shape("Shape")
    val rectangle = Rectangle("Rectangle")
    val circle = Circle("Circle", "Magenta")
    val square = Square("Square", "Blue", 4)


    shape.drawShape()
    rectangle.drawShape()
    circle.drawShape()
    square.drawShape()

    // ONEMLI
// Child class'larda super.drawShape yazdigimiz icin once ust sinifin printi sonra alt sinifin printi yazilacak

}


//----------------------------------------------------------------------------------------------------------------------


/*

Polimorfizim -> ust sinifa yazilan bir islemin child class ta override edilerek farklı bi islem yaptirilmasina denir
Turkcesi = "Cok Bicimlilik"

 */

//----------------------------------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------------------------------
