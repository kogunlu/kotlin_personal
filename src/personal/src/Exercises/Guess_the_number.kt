package personal.src.Exercises

fun main() {

    val number = (Math.random() * 100).toInt()
    println(number)

    var isTure = false
    var guessLimit = 5


    do {
        print("Tahmininizi giriniz (0-100) : ")
        val selectedNumber = readLine()!!.toInt()

        if (selectedNumber !in 1..100) {
            println("Girdiğiniz sayi 0-100 arasinda olmalidir, tekrar deneyin.")
        } else if (selectedNumber == number) {
            println("Tebrikler! $number sayisini dogru tahmin ettiniz!")
            isTure = true

        } else {
            guessLimit -= 1
            println("Kalan deneme hakkiniz: $guessLimit")
        }

    } while (!isTure && guessLimit > 0)

    if (guessLimit == 0) {
        println("Deneme hakkiniz bitti, kaybettiniz.")
    }

}