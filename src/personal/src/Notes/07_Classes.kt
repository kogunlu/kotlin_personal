package personal.src


/**
 *
 *                      CLASSES
 *                      (Basics)
 */


//----------------------------------------------------------------------------------------------------------------------

class Car(
    wheelCount: Int,
    color: String = "Red"
) {         // primary constructor  --> "constructor" kelimesini yazmak zorunda degiliz
    //class Car constructor (wheelCount: Int, color: String = "Red")

    private val mWheelCount: Int

    init {                                                  // secondary constructorların içinde {} ile işlem yapiliyor
        mWheelCount =
            wheelCount                            // primary icin bu parantezler butun sinifi kapsiyor bu nedenle
        println("Primary const. created")                   // primary'e ozel bir sey yapacaksak init icinde yazmamiz gerekiyor

    }


    constructor(name: String) : this(4) {                     // secondary constructorlar mutlaka sonunda this() ile primary'i isaret edip
        println("1st secondary const. created")                         // primary'de zorunlu olan parametreyi atamamiz gerekir
    }


    constructor(name: String, madeOf: String) : this(4) {                     // secondary constructor
        println("2nd secondary const. created")
    }


    // madeOf parametresi zorunlu degil opsiyonel, overload yapildi ister kullan ister kullanma diyebilmek icin

    // constructor 'ın icinde parametreyi nullable yapip null deger vererek de opsiyonel kilinabilir fakat
    // dogru kullanim onun yerine yeni constructor yazmaktir. Business logic degisebilir cunku.


    constructor(
        wheelCount: Int,
        madeOf: String?,
        brand: Int?
    ) : this(4) {         // secondary constructor, yukarida aciklanan yanlis kullanim
        println("3nd secondary const. created")
    }


}


class Foo() {

    private val name: String = "Kuday"
    // private degiskene erismek icin public fonksiyon yazıyoruz, disaridan bu fonksiyonu cagirmamiz gerekir.
    // Bune "encapsulation" diyoruz

    public fun getName(): String {
        return name
    }
}

//----------------------------------------------------------------------------------------------------------------------
fun main() {

    val car0 = Car(4)
    val car1 = Car(4, "Blue")


    val foo = Foo()
    foo.getName()     // ---> yukarida private olan degiskeni nesne olusturup cagirdik


}


//----------------------------------------------------------------------------------------------------------------------



//----------------------------------------------------------------------------------------------------------------------


/*
        visibility modifiers
        1- private
        2- public
        3- protacted
        4- internal (javada yoktu)



        1- ilgili class disindan bu private degiskene erisilmez
        2- class disindan da bu degiskene erisilir
        3- sadece miras alan child class'lar kullanabilir (inheritance = miras)
        4- ayni modul icinde public ama disinda, harici modullerde private gibi davranacak


 */


// top level declaration = herhangi bir class icinde olmadan tanimlama yapabilmeye denir (main'in vs ustunde)

// protected haricindekiler top level fakat protected top class kullanilamaz / tanimlanamaz
// cunku miras alinabilmesi icin class icinde olmasi gerekir

//----------------------------------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------------------------------
