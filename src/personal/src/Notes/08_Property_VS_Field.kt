package personal.src.Notes


/**
 *
 *                     Property VS Field
 *
 *
 */

//----------------------------------------------------------------------------------------------------------------------

/*
    Javada bir degisken (field) tanimlayip ona get() ve set() fonksiyon yaziyoruz

    Kotlin'de biz bir degisken degil, property yani otomatik olarak get ve set fonksiyonu tanimlamis oluyoruz.


    !!! Show kotlin bytecode ile kodun java karsiligina bakabiliriz !!!

    Biz kotlinde public bir degisken tanimlasak bile,
    bunun uretecegi makine kodu (essembly) private kod ve buna erisen public bir get ve set fonksiyonu oluyor (java karsiligi)

    dolayisiyla zaten arka planda makine kodunda
    otomatik olarak private tanimlayip get ve set kullandigimiz icin encapsulation yapmis oluyoruz.

    bir değişkeni tanımladığımızda get ve set fonksiyonları arka planda field ismi ile otomatik generate ediliyor
    getDegisken() ve setDegisken() gibi


    bizim burada public private vermemiz get ve set fonksiyonlarini degistirir
    private yazarsak arkadaki kodda get ve set kodu olmuyor, public yazarsak oluyor


    bu farktan dolayi kotlinde bir degiskeni (property) extend edebiliyoruz, bu yuzden = deyip deger atayamayiz

    var Shape.type

    get() = .....
    set(value){
    type= value
    }
        seklinde atama yapiyoruz. Backing field'i olmadigi icin olmuyor bu degiskenin,
        bu yuzden atama yapamiyoruz ve get set yazmamiz gerkeiyor
 */


//----------------------------------------------------------------------------------------------------------------------

class BankAccount() {
    var balance = 1_000_000
        set(value) {
            field = value        // field = backing field
        }


    private var debt = 450_000

}

// Yukaridaki balance ve debt degiskenlerinin urettigi essembly kodlari ayni, ikisi de java karsiligi private olarak uretiliyor
// Public olan degiskenin get() ve set() fonksiyonlari java karsiliginda yazilmis oluyor
// Private da get ve set arka planda yazilmamis oluyor
// Bu yuzden arka plandaki gercek (essembly) kodlara bu nedenle erisemiyoruz
// Bu nedenle kotlindeki tanimladigimiz degiskenlere field degil property diyoruz


//----------------------------------------------------------------------------------------------------------------------


fun main() {

    val bankAccount = BankAccount()
    println(bankAccount.balance)

    bankAccount.balance = 500_000
    println(bankAccount.balance)

    /*
        println(bankAccount.debt) ---> erisemiyoruz private oldugu icin
    */


}

//----------------------------------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------------------------------
