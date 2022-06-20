fun main() {

    // Basit for dongusu icin asagidaki syntax'i kullanabiliriz

    for (value: Int in 1..10) {
        println(value)              // eger bir ozellik kullanilacaksa ${value} seklinde de yazilabilir
    }

    val countryCodeArray = arrayOf("tr", "az", "ing", "ru", "fr")

    for (value in countryCodeArray) {
        println(value)              // eger bir ozellik kullanilacaksa ${value} seklinde de yazilabilir
    }


    // Index degerlerini almak icin asagideki syntax kullanilabilir

    for (index in countryCodeArray.indices) {
        println(index)
    }

    for (index in countryCodeArray.indices) {
        println("${index}. degeri: ${countryCodeArray[index]} ")
    }


    // Hem index hem value degerlerini ayni anda cagirabiliriz

    for ((index, value) in countryCodeArray.withIndex()) {
        println("$index. degeri : $value")
    }

//----------------------------------------------------------------------------------------------------------------------


    // repeat(size) fonksiyonu ile herhangi bir listeye ihtiyac duymadan tekrarlayan islemler yapilabilir

    repeat(10) {
        println("Daha çok pratik yapmam lazım!")
    }

//----------------------------------------------------------------------------------------------------------------------

    // Faktoriyel hesaplayan kod blogu yazalim

    println("Bir sayi giriniz : ")
    val x: Int = readLine()!!.toInt()

    var faktoriyelX = 1

    for (i: Int in 1..x) {
        faktoriyelX *= i
    }

    println(faktoriyelX)

//----------------------------------------------------------------------------------------------------------------------

    // Haftanin gunlerini yazan kod blogu yazalim

    val weekDays = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    for ((index, value) in weekDays.withIndex()) {
        println("Haftanin ${index + 1}. gunu : $value")
    }

//----------------------------------------------------------------------------------------------------------------------

    // continue kullanarak ilgili sart saglaninca, dongude o degeri atlayarak devam edebiliriz

    for (value in 1..50) {
        if (value % 2 == 1) {
            continue
        } else {
            println(value)
        }
    }


    // break kullanarak donguden cilabiliriz

    for (valueX in 2..50) {
        if (valueX % 5 == 1) {
            break
        }
        println(valueX)
    }

//----------------------------------------------------------------------------------------------------------------------

    // ic ice for donguleri kullanirken bir ustteki for'a degil de iki veya daha ustteki for dongusune donmek icin
    // label kullanabiliriz.
    // bunun icin   labelname@ ifadesini ilgili for'un onune yazip, return ya da continue yapacagimiz yere ise
    // @labelname seklinde yazmamiz yeterlidir.


    returnLabel@ for (value in 1..50) {
        for (value2 in 0..10) {
            if (value2 == 5) {
                continue@returnLabel
            }
            println("continue2 : $value2 | ")
        }
    }

    // Asagidaki ornekte break komutu dogrudan 1. donguyu durduracagi icin donguler tekrar donmeyecektir.
    // cikti ---> 0, 1, 2, 3, 4 olup kapanacak
    returnLabel@ for (value in 1..50) {
        for (value2 in 0..10) {
            if (value2 == 5) {
                break@returnLabel
            }
            println("break2 : $value2 | ")
        }
    }


    // Asagidaki ornekte break komutu 2. for dongusunu durduracak fakat 1. for dongusu kaldigi yerden devam edecek dolayisiyla 2. for dongusu tekrar calisacaktir.
    // cikti ---> 0, 1, 2, 3, 4 olup bunu 1. dongu suresince yazdiracaktir.
    // 0, 1, 2, 3, 4      0, 1, 2, 3, 4     0, 1, 2, 3, 4     0, 1, 2, 3, 4     seklinde

    for (value in 1..50) {
        for (value2 in 0..10) {
            if (value2 == 5) {
                break
            }
            println("break2 : $value2 | ")
        }
    }

//----------------------------------------------------------------------------------------------------------------------


    // Eger bir dongude, dongu icinde if-else kullaniyorsak bunun yerine while da kullanabiliriz

    for (value in 0..100) {
        if (value < 5) {
            println("$value")
        } else {
            return
        }
    }


    var number = 0
    while (number < 5) {
        println("$number ")     // ---> su sekilde de yazilabilir :   ${number++}
        number++
    }


}