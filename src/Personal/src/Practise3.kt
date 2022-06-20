import kotlin.math.pow

fun main() {

    // option + command + L   ----> yazılan kodları hizaya sokar

/* fonksiyon yaratmak icin asagidaki syntax kullanilir ;

    1- fun keyword'u ile baslar
    2- fonksiyon ismi verilir
    3- parametre parantezi acilir ve parantezler girilir --->   ()
    4- : operatoru ile geri donus degeri giriliz     ----->   String / Int / Unit (deger donmeyecekse --> javadaki void)
            PS: Geri donus degeri tanimlamazsak otomatik olarak Unit (bos) tanimlanir

    5- fonksiyonun bodysi acilir ve kapatilir    ----->  {}


    fun <fonksiyon ismi> () : String {   }

 */

//----------------------------------------------------------------------------------------------------------------------

    fun takeSquare(number: Int): Int {
        return number * number
    }

    println(takeSquare(5))

//----------------------------------------------------------------------------------------------------------------------

    // Fonksiyon icinde fonksiyon cagirabiliriz    -----> kodun anlasilirligi bozulur, cok tercih edilmez
    // reflection ( class 'larda gorecegiz) kisminda kullaniyoruz daha cok


    fun takeCube(number: Int): Int {

        fun takeSquare(number: Int): Int {
            return number * number
        }

        return takeSquare(number) * number
    }

    println(takeCube(3))

//----------------------------------------------------------------------------------------------------------------------

    // Baska bir class 'in icindeki fonksiyonunu cagirirken nokta (.) isareti kullanilir

    Math.pow(2.0, 3.0)    //  2^3                          ---> degerlerin double olmasina dikkat et !!!
    2.0.pow(3.0)      // bu sekilde de kullanilabilir  ---> degerlerin double olmasina dikkat et !!!

//----------------------------------------------------------------------------------------------------------------------
    /**
     *
     *                          ONEMLI KONU
     *
     *               ------  fonkisyon overloading  ------
     *
     *
     */


    fun reformatMessage(message: String, isUpperCase: Boolean = false, size: Int, lang: String = "tr") {
        println("Message : $message isUpperCase : $isUpperCase Size : $size Language : $lang")
    }

    reformatMessage("kuday", false, 5)

    // Default olarak deger verilen kisimlara, fonksiyon olusturulurken atama yapilmak zorunda degildir


    // Eger opsiyonel parametreler varsa, ve o kisma deger vermeden sonraki parametreye deger veriyorsak bunu belirtmemiz gerekir

    // Normalde asagidaki parametreler -fonksiyon olusturulurken bu sekilde tanimlandigi icin- sirasiyla soyle olmalidir;
    // 1- Message   2- isUpperCase  3- Size    4- lang
    // Fakat biz opsiyonel kismi atlayip da deger atayabiliriz, sunun gibi;
    // 1- Message 2- Size
    // Bunun icin, IDE 'nin bunu anlayabilmesi icin, normalde siraya gore opsiyonel olan degiskeni DEGIL deger atadigimiz yazmaliyiz.

    reformatMessage("Mesaj", true, 5, "tr")

    reformatMessage("mesaj", size = 5, lang = "tr")   // burada isUpperCase default degerini degistirmedigimiz icin,
    // sonraki parametreye atama yapmak istedik ve bunu IDE 'ye soyledik.

    reformatMessage("mesaj", size = 10)             // bu yazmis oldugumuz degisken adlari 'size' 'lang' vb
    // " named argument "olarak adlandirilir


// Java'da boyle bir kullanim yok. Bunun icin kullanmak istedigimiz her overload fonksiyonu ayri ayri tanimlamamiz gerekiyor.

    //fun reformatMessage(message: String, size: Int, lang: String = "tr") {}  ----> isUpperCase olmadan overload edildi
    //fun reformatMessage(message: String, isUpperCase: Boolean = false, size: Int) {}  -----> lang olmadan overload edildi


//----------------------------------------------------------------------------------------------------------------------

    /**
     *
     *                          ONEMLI KONU
     *
     *                    ------ " vararg "  ------
     *
     *
     */

// Cok fazla sayida ayni cinsten parametremiz olacaksa "variable number of arguments" --vararg-- tanimlanabilir
    // Bu sayede fonksiyon tek bir parametre aliyor gibi gozuksede, birden fazla degisken atanabilir
    //Bu degiskenlere array 'e erisir gibi erisebiliriz ------> [index]  ya .get(index)
    // vararg 'in bittigini ve sonraki parametreye gectimizi belirtmek icin yine name argument kullanmamiz gerekir

    fun getUserInfo(vararg userInfo: String, key: Int) {
        userInfo[3]
        userInfo.get(3)

    }

    getUserInfo("Kuday", "Ogunlu", "Turk vatandasi", " ", key = 4)

    // vararg parametresi olarak arrayOf kullanmak istenirse * operastoru eklenmelidir.
    getUserInfo(*arrayOf("kuday", "ogunlu", "Izmir", "Turkiye"), key = 4)




    fun getUserInfo2(vararg userInfo: String, isUpperCase: Boolean, age: Double) {
        userInfo[3]
        userInfo.get(3)
    }
    getUserInfo2("eylem", "ogunlu", "luleburgaz", isUpperCase = false, age = 26.5)



    fun getUserInfo3(vararg userInfo: Any) {
        userInfo[3]
        userInfo.get(3)
    }
    getUserInfo3("kuday", 26, true)


//----------------------------------------------------------------------------------------------------------------------

    // Bir fonksiyon bir degiskene direkt deger atamasi olarak verilebilir

    val userList = arrayOfNulls<String>(5)

    fun getListCount(): Int = userList.size      // asagidaki ile aynidir.
    // Buna fonksiyonlar icin expression kullanimi denir.


    fun getListCount2(): Int {
        return userList.size
    }

//----------------------------------------------------------------------------------------------------------------------
}