fun main() {


    /**
     *                       Extension FONKSIYONLAR
     */


    /*      Uzerinde degisiklik yapilamayan ya da bizim yapmak istemedigimiz durumlarda kullanilir

            Yapisal olarak;

            fun Numbers.extCalculateSquare (value : Int) : Unit {

            }

     */
//----------------------------------------------------------------------------------------------------------------------

    // normalde degiskenlere deger atayip print islemini asagidaki gibi yapariz

    val pi: Double = 3 + 0.14
    println(pi)

    val schoolNumber: Int = 2014434
    println(schoolNumber)

    val tcIdentityNumber: Long = 2469112312123
    println(tcIdentityNumber)


    // yukaridaki kullanimlarin yerine normal bir log2 fonksiyonu yazabilir ve asagidaki gibi kullanabiliriz.

    fun log2(number: Number) {
        println(number)
    }

    log2(pi)
    log2(schoolNumber)
    log2(tcIdentityNumber)

//----------------------------------------------------------------------------------------------------------------------

    // extension fonksiyonlar ister direkt ister value'lar uzerinden cagiralabilir

    infix fun Number.log(emptyParam: String) {
        println(emptyParam + this)
    }

    // yukaridaki fonksiyonla number sinifina bir fonksiyon ekledik

    (3 + 0.14).log("")
    (3 + 0.14) log ("")

    pi log ("")
    pi.log("")

    tcIdentityNumber log ("")
    tcIdentityNumber.log("")

//----------------------------------------------------------------------------------------------------------------------

    // farkli bir extension function deneyelim


    // tek parametre ile yazdigimiz icin infix yapabildik yoksa infix olmazdi

    infix fun String.extPlus(otherString: String): Int {
        return this.toInt() + otherString.toInt()
    }

    val result: Int = "3" extPlus "5"
    println(result)

    ("3" extPlus "5") log ("")


    // coklu parametre oldugu icin infix yapamadik

    fun String.ExtPlus2(value1: String, value2: String): Int {
        return this.toInt() + value1.toInt() + value2.toInt()
    }

    val result2: Int = "5".ExtPlus2("10", "15")
    println(result2)

//----------------------------------------------------------------------------------------------------------------------

    // baska bir ornek


    infix fun Int.ExtTimes(value: Int): Int {
        return this * value
    }


    val result3: Int = 15 ExtTimes 3
    println(result3)


//----------------------------------------------------------------------------------------------------------------------

    // degisken de extend edilebilir. Bunun sebebi kotlin'de aslinda degisken degil property tanimlamamizdir.

    /*

    var Shape.type
    get() = "Rectangle"
    set(value) {
        type = value
    }

    gibi

     */


//----------------------------------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------------------------------


}