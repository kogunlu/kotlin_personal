package personal.src.Notes

/**
 *
 *      Inline Class
 *
 */

//----------------------------------------------------------------------------------------------------------------------

open class BankAccount2(val balance: Int) {
    val branchCode: Long = 3245
}


interface Print {
    fun printBalance()
}

@JvmInline
value class BankAccount3(val balance: Int) : Print {              // value class sadece 1 degiskeni parametre alarak kullanilir
    init {
        print("balance: $balance")
    }


//  val accountNumber: Long = 12345123          // value class sadece 1 degisken ile kullanilabiliyor (su an icin), yeni degisken tanimlanamiyor

    val accountNumber: Long
        get() {
            return 1234123
        }

    fun getAccountNumber2(): Long {
        return 1234123
    }


    override fun printBalance() {
        print("Interface print - balance : $balance")
    }
}


//----------------------------------------------------------------------------------------------------------------------


/* value class'lar @JvmInline annotation olmadan henuz kullanamiyorlar

value class'lar suan icin sadece tek bir degisken kabul etmektedir. Birden fazla degiskene izin verilmiyor.
Ancak value class'larin dokumantasyonunda inline class'larin ileride birden fazla degisken alabilmesine izin verilecegi yaziyor


inline class'lar ile init block'u kullanilabilir.

----!!!!!----
inline class'larin belirtilen constructor'lari java kodunda private olarak bulunurlar
Bundan dolayi zaten istesek de bu constructor'larla nesne olusturamayiz. Ama bunu yapabiliyor gibi gozukmemizin sebebi,
gercekte o nesnenin hic yaratilmiyor olusudur.
Bizim nesne olustururken gordugumuz sey aslinda cost. icindeki degiskenin kendisi.

----!!!!!----

inline class'lar icinde propoerty tanimlanmasina izin verilir. Ancak bu propert'nin backing field'i olamaz.

Inline class'lar herhangi bir interface'i implement edebilirler, bir baska class'i miras alamazlar.

inline class'lar miras alinamaz. Cunku default olarak final'lardir ve degistirilemezler
Open keyword'uyle birlikte kullanilamaz. Final keyword'u vermek de dedundant uyarisi verir
abstract, sealed keyword'u ile de kullanilamaz


_____OZETLE_____
Bir class olusturup, primitive gibi davranmasini sagliyor
________________

 */
//----------------------------------------------------------------------------------------------------------------------

interface I

@JvmInline
value class Foo2(val i: Int) : I

fun asInline(f: Foo2) {}
fun <T> asGeneric(x: T) {}
fun asInterface(i: I) {}
fun asNullable(i: Foo2?) {}

fun <T> id(x: T): T = x


//----------------------------------------------------------------------------------------------------------------------


fun main() {

    val balance2: BankAccount2 =
        BankAccount2(2500)         // referans tipli (class nesnesi), performans harcamasi ve erisim bedeli (CPU) daha fazla
    val balance3: BankAccount3 =
        BankAccount3(25000)        // value class oldugu icin, referans tipli degil, primitive olacak

    val balance4: Int = 25000   // yukaridakiyle asagi yukari ayni, class olmanin ozelliklerini kullanabiliyoruz ancak primitive oldugu icin daha az yer kapliyor (win-win)


    val f = Foo2(42) // f'in tipi   int -> primitive -> unboxed
    // val f2: Int = 42


    asInline(f) // unboxed: used as Foo2 itself
    asGeneric(f) // boxed: used as generic type T
    asInterface(f) // boxed: used as type I
    asNullable(f) // boxed: used as Foo2, which is different from Foo2

//----------------------------------------------------------------------------------------------------------------------

    /*
     below 'f' first is boxed (while being passed to 'id') and then unboxed (when returned)
    in the end 'c' contains unboxed representation (just '42'), as 'f'

     */

    val c = id(f)

    val c2 = id(42)     // -- >returns 42. Verdigimiz generic seyi, generic olarak dondurdugu icin; generic fonskiyona verilse dahi unboxed oluyor
    val c3 = 42
}


//----------------------------------------------------------------------------------------------------------------------
