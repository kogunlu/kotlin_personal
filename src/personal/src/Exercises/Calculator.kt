import kotlin.math.pow

fun main() {

    println(
        """"
    =============================================
    |                                           |
    |                                           |
    |        HESAP MAKINESINE HOSGELDINIZ       |
    |                                           |
    |                                           |
    =============================================
    |  Lutfen yapmak istediginiz islemi secin   |
    |  1- Toplama                               |
    |  2- Cikarma                               |
    |  3- Carpma                                |
    |  4- Bolme                                 |
    |  5- Us Alma                               |
    |  6- Faktoriyel Alma                       |
    |  0- Cikis                                 |
    =============================================
        """
    )

    do {
        println("-------------------------------------------------------------------------------------------------------")

        print("Islem numarasi : ")
            val number: Int = readLine()!!.toInt()

        if (number != 0) {
            print("1. sayiyi giriniz : ")
            val number1 = readLine()!!.toInt()
            print("2. sayiyi giriniz : ")
            val number2 = readLine()!!.toInt()

            var result: Int = 0

            when (number) {
                1 -> {
                    result = number1 + number2
                    println(result)
                }
                2 -> {
                    result = number1 - number2
                    println(result)
                }
                3 -> {
                    result = number1 * number2
                    println(result)
                }
                4 -> {
                    if (number2 != 0) {
                        result = number1 / number2
                        println(result)
                    } else {
                        println("Hata! Bolen 0 olamaz. Tekrar deneyin.")
                    }
                }
                5 -> {
                    result = number1.toDouble().pow(number2.toDouble()).toInt()
                    println(result)
                }
                6 -> {
                    result = 1

                    println("Hangi sayinin faktoriyelini almak istiyorsun ?\n1 -> 1. sayi = $number1 \n2 -> 2. sayi = $number2")
                    val selectedNumber = readLine()!!.toInt()

                    if (selectedNumber == 1) {
                        for (value in 1..number1) {
                            result *= value
                        }
                        println(result)
                    } else if (selectedNumber == 2) {
                        for (value in 1..number2) {
                            result *= value
                        }
                        println(result)
                    } else {
                        println("Hatali giris yaptiniz!")
                    }
                }
            }
        }else{
            println("Program bitti.")
        }

    }while(number != 0)




}