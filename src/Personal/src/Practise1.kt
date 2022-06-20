fun main() {

    val number1 = 10
    val number2 = 5

    println("${number1 * number2}")
    println(number1.times(number2))

//----------------------------------------------------------------------------------------------------------------------

    // Sınav notlarını hesaplayan çalışma

    print("Matematik vize notunuzu giriniz: ")
    val matMidTerm = readLine()!!.toInt()

    print("Matematik final notunuzu giriniz: ")
    val matFinal = readLine()!!.toInt()

    print("Fizik vize notunuzu giriniz: ")
    val fizMid = readLine()!!.toInt()

    print("Fizik final notunuzu giriniz: ")
    val fizFinal = readLine()!!.toInt()

    val finalGrade: Double = ( ((fizMid * 0.4) + (fizFinal * 0.6) ) + ( (matMidTerm * 0.4) + (matFinal * 0.6)) ) / 2
    val letterGrade: Char

    var result = true


    if(finalGrade in 85.0..100.0){
        letterGrade = 'A'
    }else if(finalGrade in 70.0..84.99){
        letterGrade = 'B'
    }else if(finalGrade in 55.0..59.99){
        letterGrade = 'C'
    }else if(finalGrade in 40.0..54.99){
        letterGrade = 'D'
    }else{
        letterGrade = 'F'
        result = false
    }


    if(result){
        println("Tebrikler! Sınıfı başarılı bir şekilde geçtiniz\nNot ortalamanız: $finalGrade \nHarf notunuz: $letterGrade")
    }else{
        println("Üzgünüz, sınıfı geçemediniz.\nNot ortalamanız: $finalGrade \nHarf notunuz: $letterGrade")
    }

//----------------------------------------------------------------------------------------------------------------------

    // If-else yapısı 2 şekilde kullanılabilir.
    // State kullanımı : sadece if else kullanarak sartli durumlarimizi kodlamaktir.
    // Expression kullanimi : bir value'ya deger olarak esitligin karsi tarafina if-else kodlarini yazmaktir.


        println("Öğrenci misin?")
        val answer = readLine()!!

    // State kullanımı
        if (answer.contains("Evet", ignoreCase = true)){
            println("Öğrenci")
        }else{
            println("Öğrenci değil!")
        }


    // Expression kullanimi
        val result1: String = if (answer == "Evet"){
            "Öğrenci"
        }else{
            "Öğrenci değil!!"
        }

        println(result1)

//----------------------------------------------------------------------------------------------------------------------
    // When kullanimi Java'daki swich-case kullanimi yerine gelmiştir.

    println("Ülke kodu giriniz: ")
    val countryCode = readLine()!!

    when(countryCode.lowercase()){

        "tr" -> println("Türkiye")
        "ru" -> println("Rusya")
        "ing" -> println("İngiltere")
        "fr" -> println("Fransa")
        "uk" -> println("Birleşik Krallık")
    }

//----------------------------------------------------------------------------------------------------------------------
    // When'in yanina karislastirma ifadesi eklemeden, bunu case'lerin yanina da ekleyebiliriz
    // Bu şekilde && || and or xor gibi ifadeleri kullanabiliriz

    when{
        countryCode.lowercase() == "ing" || countryCode.lowercase() == "fr" -> println("Avrupa Birliği vatandaşı")
        countryCode.lowercase() == "tr" || countryCode.lowercase() == "az" -> println("Türk (tek millet iki devlet)")
        countryCode.lowercase() == "ru" || countryCode.lowercase() == "uk" || countryCode.lowercase() == "bel" -> println("Eski Sovyetler Birliği ülkesi")
    }

//----------------------------------------------------------------------------------------------------------------------
    // Expression kullanimi when ile de yapilabilir

    println("Ülke kodu giriniz: ")
     var countryCode2: String = readLine()!!

     countryCode2 =  when (countryCode2.lowercase()) {
            "tr", "az" -> {
                println("Türk vatandaşı")
                "90"
            }
            "ar" -> {
                println("Arab vatandaşı")
                "80"
            }
            "fr" -> {
                println("Fransız vatandaşı")
                "70"
            }
         else -> {"40"}
     }
    println(countryCode2)  // Çıktı en son atadığımız alan kodu değeri olacak.


//----------------------------------------------------------------------------------------------------------------------
    // Yine benzer şekilde ifade caselerin yanina da eklenebilir.

    countryCode2 = when {
        countryCode2.lowercase() == "tr" || countryCode2.lowercase() == "az" -> {
            println("Türk vatandaşı")
            "90"
        }
        countryCode2.lowercase() == "ru" || countryCode2.lowercase() == "uk" -> {
            println("Eski Sovyetler ülkesi")
            "45"
        }
        else -> {
            "40"
        }
    }

//----------------------------------------------------------------------------------------------------------------------
    // Karsilastirilacak sey deger yerine degisken de olabilir.

    val trCode = "tr"
    val ingCode = "ing"
    val ruCode = "ru"
    val frCode = "fr"

    when (countryCode2.lowercase()){
        trCode -> println("Türk vatandaşı")
        ingCode -> println("İngiltere vatandaşı")
        ruCode -> println("Rusya vatandaşı")
        frCode -> println("Fransa vatandaşı")
    }

//----------------------------------------------------------------------------------------------------------------------
    // range'lerin !in seklinde kontrolu yapilabilir

    println("Bir sayi giriniz: ")

    when(readLine()!!.toInt()) {
        in 0..10 -> {
            println("0-10 arasinda")
        }
        in 11..20 -> {
            println("11-20 arasinda")
        }
        !in 0..20 -> {
            println("0-20 arasinda degil")
        }
    }







}
