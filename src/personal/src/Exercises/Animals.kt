package personal.src.Exercises


open class Animal(name: String, isKiller: Boolean) {

    constructor(name: String, age: Int, sex: String, isKiller: Boolean) : this(name, isKiller)

    val mName = name
    fun eatingHabit(isKiller: Boolean) {
        if (isKiller) {
            println("$mName eats meat")
            println("-----------")

        } else {
            println("$mName eats grass")
            println("-----------")

        }
    }

    open fun livesIn() {
        println("Animals need to feed to live.")
        println("-----------")

    }

}

open class Monkey(name: String, age: Int, sex: String) : Animal(name, age, sex, true) {


    val MonkeyName = name
    val MonkeySex = sex

    override fun livesIn() {
        println("$MonkeyName is ${MonkeySex.toLowerCase()} and it lives in the forest")
        println("-----------")

    }


}


open class Bird(name: String, isKiller: Boolean = false) : Animal(name, isKiller) {

    val BirdName = name

    override fun livesIn() {
        super.livesIn()
        println("$BirdName lives in rainforests and they are not killer")
        println("-----------")
    }

}

final class Eagle(name: String, isKiller: Boolean = true) : Bird(name) {

    val EagleName = name

    override fun livesIn() {
        println("$EagleName lives in Blacksea region and it is a killer")
        println("-----------")

    }
}


fun main() {


    val George = Monkey("George", 15, "Male")
    George.livesIn()
    George.eatingHabit(true)


    val Sugar = Bird("Sugar")
    Sugar.livesIn()
    Sugar.eatingHabit(false)

    val Pyke = Eagle("Pyke")
    Pyke.livesIn()
    Pyke.eatingHabit(true)

}