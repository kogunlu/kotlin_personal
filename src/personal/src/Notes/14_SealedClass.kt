package personal.src.Notes


/**
 *
 *      Sealed Class
 *
 */

//----------------------------------------------------------------------------------------------------------------------

/*

Sinirli kumede, gruplanabilir, class'lar yazmayi saglar.
kisitlanmis bir class hiyerarsisi kurabilmemizi saglar
bu Class'lar arka planda static olarak tutulmazlar. Enumaration'lardan en buyuk farki budur.
Enum'lar verileri gruplarken, sealed class'lar class'lari gruplar.

Sealed class'lar abstract class'lardir ayni zamanda. Abstract olduklari icin open olamazlar, anlamsizdir.
Sealed class'lar abstract class olduklari icin final olamazlar. Anlamsal olarak zaten sacmadir.

Sealed class'larin nesnesi olusturulamaz. Constructor'lari protected ve private olarak bulunur.

Sealed class'lari miras alan subClass'lar final olduklari icin miras alinamazlaar. SDK'ler icin onemlidir.

Sealed class'in subclass'larinin neler oldugu compiletime'da bilinmektedir. Bundan dolayi when ve if yapilari kullanildiginda
else case'lerinin yazimina ihtiyac duymazlar.

sealed class'lari extends alan subclass'lar eskiden ayni dosya uzerinde bulunma zorunlulugu vardi.
Bu zorunluluk esnetilerek ayni package icerisinde olmaya kadar genisletildi.
Ancak ayni package disina cikip, bir sub class'a selaed class'i miras oalrak vermek isterseniz buna izin verilmeyecek.
Ozellikle SDK yazarken bu kisitlama onemlidir

sealed class'lar icersiinde object tanimlamalari da yapilabilir
sealed class'lar icerisinde sadece object tanimi yaparsaniz, bu kullanimin enumration'dan teknik olarak hicbir farki olamyacaktir.



-- Kullandigimiz yapilar kendi icinde ayrisip, farkli seyler yapacaksa, sealed class kullanmaliyiz
-- Grupladigi seyler class

-- Sadece opsiyonlari gormek istiyorsak, enum class kullanmaliyiz
-- Grupladigi seyler sabitler


 */


//----------------------------------------------------------------------------------------------------------------------

// iki kullanimi vardir

sealed class Response
class Success : Response() {

}

class Error : Response() {

}


sealed class Response2 {
    class Success2 : Response2(),
        TeamsFunctionality {          // --> Bu class'a, yapacagi isler icin TeamsFunctionality interface'ini implement ettik
        override fun practice() {
            TODO("Not yet implemented")
        }
    }

    class Error2 : Response2() {

    }
}


fun handle(response: Response) {
    when (response) {
        is Success -> {
            //  response'dan gelen bilgilerle UI'ini doldur
        }
        is Error -> {
            //  pop-up ile kullaniciya bilgi ver.
        }                   //else yazmama gerek yok cunku :Response miras aldirdigim icin secenekler belli, 2 secenek var. Else yok.
    }
}

// bu yanlis bir kullanimdir, enum kullanmamiz gerekiyor
// sadece obje ekliyor, class eklemiyorsak enum kullanalim

//----------------------------------------------------------------------------------------------------------------------


sealed class PaymentOption {
    object Cash
    object Card
    object Transfer
}

enum class PaymentOption2 {
    Cash, Card, Transfer
}

//class Ass: Success()              ->


//----------------------------------------------------------------------------------------------------------------------

fun main() {

// val response = Response()                ->

    val success = Success()
    val error = Error()

    handle(success)
    handle(error)

}


//----------------------------------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------------------------------
