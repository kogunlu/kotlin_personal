fun main() {

    /**
     *
     *
     *                      KOTLIN GIRIS
     *
     *
     */

//---------------------------------------------------------------------------------------------------------------------

    //                  Öncelikle değişkenlere numara, harf, yazı ve liste-array atayalım.

    val number1: Int = 15
    val number2 = 10
    val letter1: Char = 'x'
    val string1: String = "Bu bir stringdir."
    val isStudent: Boolean = false

    println("$number1 + $number2") // output: 15 + 10
    println(number1 + number2) // output: 25

    println(letter1)
    println(string1)

//---------------------------------------------------------------------------------------------------------------------
    //                          Array atamaları birden fazla şekilde yapılabilir.

    val array1 = arrayOf(10, 20, 30, 40, 50)
    val array2 = arrayOf<Any>(10, 20, 30, 'k', "keko", false)

    val array3 = arrayOfNulls<String>(7) // Önce array yaratıldı, atamaları sonra yapılacak.
    array3[0] = "Monday"
    array3[1] = "Tuesday"
    array3[2] = "Wednesday"

    println(array3[0] + " " + array3[2])
    println(array3.indices) // 0..6 olarak, index numaraları dönecek
    println(array3.indices.first) // 0 dönecek
    println(array3.indices.last) // 6 dönecek


//---------------------------------------------------------------------------------------------------------------------

    val value1: String = "Kuday"
    val numberX: Int = 25

    // Eger degiskenin bir ozelligine ihtiyac duyacaksaniz ${} seklinde kullanilir.

    println("$numberX + ${value1.length}") // "25 + 5" dönecek
    print(numberX + value1.length) // 30 dönecek


//---------------------------------------------------------------------------------------------------------------------
    val rawPineTree = """
        
                    *
                   ***
    $             *****
                 *******
                *********
        
        """.trimIndent()

    //Yukarıdaki örnekte 3 tane ( " ) kullanarak çıktıya istediğimiz şeyi yazdırabiliriz.
    // .trimIndent() kullanımıyla $ işareti olan yere kadarki satırlar trimlenir-silinir.

    println(rawPineTree)

//---------------------------------------------------------------------------------------------------------------------
    val rawPineTree2 = """
        
                    *
                   ***
    $             *****
                 *******
                *********
        
        """.trimMargin("$")

    //.trimMargin("symbol") kullanımıyla sembolün olduğu satırda, sembole kadarki kısım silinir.
    println(rawPineTree2)

//---------------------------------------------------------------------------------------------------------------------

    val range = 1..100  // Intrange türünde değişken/aralık
    val range2 = 1.rangeTo(100) // Yukarıdaki ifadenin farklı bir şekilde yazımı
    val alphabet = 'a'..'z' // Char'lardan oluşan bir dizi de tanımlanabilir

    val reverseRange = 100.downTo(1)
    val reverseRange2 = 100 downTo 1

    println("$reverseRange  $reverseRange2")

    val gradeNumbers = 10.until(100)
    val gradeNumbers2 = 10 until 100 // Until anahtar kelimesi son sayıyı dahil etmeden kullanım imkanı sağlar
    println(gradeNumbers)
    println(gradeNumbers2)


//----------------------------------------------------------------------------------------------------------------------
    val stepedNumbers = 1..100 step (2)
    val stepedNumbers2 = 1..100 step 3

    val reversedStepedNumbers = 100 downTo 1 step 2
    val reversedStepedNumbers2 = 100.downTo(1) step (3)

    reversedStepedNumbers2.forEach { print(" $it") } // ( " " + it ) ---> şeklinde de yazılabiliyor

//----------------------------------------------------------------------------------------------------------------------
    val numberList = 1 until 100
    val numberList2: IntRange = 1..100

    numberList.first
    numberList2.last

//----------------------------------------------------------------------------------------------------------------------

    val name: String? = null
    val number: Int? = null

    val number5 = null // IDE değişeni nullable yapmadan null değer atadığımız için bu değeri nothing olarak anlar

//----------------------------------------------------------------------------------------------------------------------
    val number12 = readLine()!!.toInt()
    val number14 = readLine()!!.toInt()

// nullable bir değişkenin methodlarını kullanacaksak bu ifadenin null olursa programın crash olması için !! verilir
// Kotlin Null Pointer Exception ---> bu durumda oluşan duruma verilen ad


    val number13 = readLine()?.toInt()
    val number15 = readLine()?.toInt()

// ?. verilmesi halinde, null değerde ilgili kod parçacığı çalışmaz ama program devam eder

    val result1 = number12 + number14
    val result2 = number13

    println(result1)
    println(result2)


}