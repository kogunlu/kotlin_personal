package personal.src.Notes

import java.util.*

/**
 *
 *      ENUM CLASS
 *
 */

//----------------------------------------------------------------------------------------------------------------------

/*

Tip guvenligini (type-safety) saglar
Kullanim amaci ayni veri kumelerinin gruplanabilir olmasini saglar
Opsiyonlarin tamamaminin neler oldugunu rahatca gorebilmemizi saglar

abstract, openi inner, sealed olamazlar
yapisi geregi zaten final'dir. Final keyword'u kullanmak redundant uyarisi verir

ozunde class olduklari icin, constructor kullanabilirler ve bu constructor icersinde veri tutabilirler
java karsiliginda bu enum sabitleri static final class'lar seklinde tutulurlar
    bu sayede, kullanirken bu sabitlerin nesnesini olusturmak zorunda kalmayiz.

enum class'larin nesnesi olusuturulmaz.

Her enum sabiti final name: String ve final ordinal: Int degiskenler default olarak sahiptir
name ifadesi, enum'in kendisinin string halini verir
ordinal ifadesi, enum'daki sabitin index'ini verir ve 0'dan baslar.
bu degiskenler final olduklari icin, enum sabitleri icerisinde override edilemezler

enum class'lar herhangi baska bir class'i miras alamazlar
enum class'lar herhangi baska bir interface'i implement edebilirler.

enum class'lar abstract  property'ler ya da abstract func'lar alabilir
Bunlari aldiklarinda tum sabitler bu abstract yapilari override etmek zorundadir.

bir open function da yazilabilir. open olmasindan dolayi override etme zorunlulugu yoktur.
Ancak open olarak belirtilen func'nun body'si olmak zorundadir.

kullanim sekli;

enum class xxxType{
NAME1,
NAME2,
NAME3
}


Onemli not:
Tum enum sabitleri aslinda bir alt class'tir, ust sinifi yani enum class'i miras alir (class ya da interface).
Bu nedenle bu alt class'lari soyle cagirabiliriz
Teams.BESIKTAS
----Teams().BESIKTAS seklinde degil, nesne olusturmadan cagrilir


 */

enum class ColorType {
    RED, BLUE, WHITE, GREEN
}


//----------------------------------------------------------------------------------------------------------------------

interface TeamsFunctionality {
    fun practice()
}


enum class Teams(val starCount: Int) : TeamsFunctionality {

    FENERBAHCE(3) {
        override fun practice() {
            TODO("Not yet implemented")
        }
    },

    GALATASARAY(4) {
        override fun practice() {
            TODO("Not yet implemented")
        }
    },

    BESIKTAS(3) {
        override fun practice() {
            TODO("Not yet implemented")
        }
    },

    TRABZONSPOR(2) {
        override fun practice() {
            TODO("Not yet implemented")
        }
    }
}

//----------------------------------------------------------------------------------------------------------------------

enum class DaysOfWeek(val dayNumber: Int) {

    PAZARTESI(1) {
        override fun toString(): String {
            return "PAZARTESİ"                  // normalde gerek olmayan bir sey, cunku zaten DaysOfWeek.PAZARTESI.name yazınca degeri verecek
        }                                       // ekstra bir şey (türkçe karakter gibi) yapmak istersek override edelim, keko olmayalım
    },

    SALI(2),

    CARSAMBA(3),

    PERSEMBE(4),

    CUMA(5),

    CUMARTESI(6),

    PAZAR(7)
}


//----------------------------------------------------------------------------------------------------------------------

enum class Sex{
    Male {
        override val typeCount: Int
            get() = TODO("Not yet implemented")

        override fun isOptional() {
            TODO("Not yet implemented")
        }
    },

    Female {
        override val typeCount: Int
            get() = TODO("Not yet implemented")

        override fun isOptional() {
            TODO("Not yet implemented")
        }
    },
     Other{
         override val typeCount: Int
             get() = TODO("Not yet implemented")

         override fun isOptional() {
             TODO("Not yet implemented")
         }

     };

// bir enum class'ina, her bir unem sabitinde override edilmesini istedigimiz seyler varsa
    // mecburen interface implement etmek zorunda degiliz
    // asagidaki gibi abstract val veya fun olusturabiliriz
    // bu enum sabitleri aslinda bir CLASS oldugu icin, ust sinifin (Sex) abstract'larini override etmek zorunda kaliyor

    abstract val typeCount : Int
    abstract fun isOptional()
    open fun log() {}       // open, override zorunlulugu yok
}

//----------------------------------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------------------------------

fun main() {

    val fb = "FENERBAHCE"
    val gs = "GALATASARAY"
    val bjk = "BESIKTAS"
    val ts = "TRABZONSPOR"

    val pzt = "PAZARTESI"
    val sal = "SALI"
    val car = "CARSAMBA"
    val per= "PERSEMBE"
    val cum = "CUMA"
    val cmt = "CUMARTESI"
    val paz = "PAZAR"

    val male = "MALE"
    val female = "FEMALE"

//----------------------------------------------------------------------------------------------------------------------

    println("4 buyuk takimdan birini yaziniz: ")
    val team: String = readLine()!!

    val starCount = when {
        team == fb ->{
            3
        }
        team == gs ->{
            4
        }
        team == bjk -> {
            3
        }
        team == ts -> {
            2
        }else -> {
            -1
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    val starCount2 = when (team){

      //  Alttaki kodun daha temiz yazilmis hali
      //
      //  Teams.FENERBAHCE.name.uppercase() -> {
      //
      //  }


        Teams.FENERBAHCE.toString() -> {
            Teams.FENERBAHCE.starCount
        }
        Teams.GALATASARAY.toString() -> {
            Teams.GALATASARAY.starCount
        }
        Teams.BESIKTAS.toString() -> {
            Teams.BESIKTAS.starCount
        }
        Teams.TRABZONSPOR.toString() -> {
            Teams.TRABZONSPOR.starCount
        }
        else -> {
            -1
        }
    }

//----------------------------------------------------------------------------------------------------------------------

println(DaysOfWeek.CARSAMBA.name)
println(DaysOfWeek.CARSAMBA.toString())

println(Teams.BESIKTAS.name)
println(Teams.BESIKTAS.toString())
println(Teams.BESIKTAS.starCount)

println(DaysOfWeek.CARSAMBA.ordinal)
println(DaysOfWeek.CARSAMBA.dayNumber)

    // FENERBAHCE degeri enum olarak yoksa, error firlatir.
    Teams.valueOf("FENERBAHCE")
    // Teams icerisindeki tum enum constant'larini bir liste halinde doner.
    Teams.values()






//----------------------------------------------------------------------------------------------------------------------


    val bestTeam = getBestTeam(Teams.BESIKTAS)

}

//----------------------------------------------------------------------------------------------------------------------

fun getBestTeam(team: Teams): Teams {
    return team
}
