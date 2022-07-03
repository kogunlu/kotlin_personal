package personal.src.Exercises

import kotlin.math.max

data class Teams(
    val name: String,
    var point: Int,
    val winChance: Double,
)


val teamOne = Teams(
    "Fenerbahce",
    0,
    0.60,
)

val teamTwo = Teams(
    "Besiktas",
    0,
    0.65,
)

val teamThree = Teams(
    "Galatasaray",
    0,
    0.55
)

val teamFour = Teams(
    "Trabzonspor",
    0,
    0.50
)

fun playGame(name1: Teams, name2: Teams) {

    val biggerChance = maxOf(name1.winChance, name2.winChance) * 100
    val smallerChance = 100 - biggerChance


    val whoWin = Math.random() * 100

    val winner: String =
        if (whoWin >= biggerChance) {
            if (name1.winChance != biggerChance) {
                name1.point += 3
                name1.name
            } else {
                name2.point += 3
                name2.name
            }
        } else {
            if (name1.winChance == biggerChance) {
                name1.point += 3
                name1.name
            } else {
                name2.point += 3
                name2.name
            }
        }


    println("${name1.name} ile ${name2.name} arasindaki mac tamamlandi.")
    println("Kazanan $winner\n=====================")

}


fun main() {

    println("Lige hoş geldiniz!\n-------------")


    playGame(teamOne, teamTwo)
    playGame(teamThree, teamFour)
    playGame(teamOne, teamThree)
    playGame(teamTwo, teamFour)
    playGame(teamOne, teamFour)
    playGame(teamTwo, teamThree)

    println(
        "${teamOne.name} sezon sonu puani: ${teamOne.point}\n" +
                "${teamTwo.name} sezon sonu puani: ${teamTwo.point}\n" +
                "${teamThree.name} sezon sonu puani: ${teamThree.point}\n" +
                "${teamFour.name} sezon sonu puani: ${teamFour.point}"
    )

}