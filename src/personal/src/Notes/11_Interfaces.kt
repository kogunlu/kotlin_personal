package personal.src.Notes

/**
 *
 *                  INTERFACES
 *
 */


//----------------------------------------------------------------------------------------------------------------------

/*

Abstract class / interface

Ortak / benzer yonleri su;

-body'si olmayan fonksiyonlari override etmek zorundayiz
-deger atamasi yapildiysa ( get() ) ile, override etmek zorunda degiliz
-bir abstract class veya interface, bir parent'tan miras aldiginda gerekli yapilari override ediyorsak, onu miras alan child'da override etmek zorunda degiliz
- hem interfaceler hem abstract class'lar super type olarak kullanilabilir
    bunlari implement eden veya miras alan yerler oradaki her yapiya ulasabilir, alir



farki;

-interface'lerin abstract class'tan en buyuk farki state tutamiyor oluslari. yani icerisine bir degisken tanimlayip bu degiskende deger tutamayiz.
interface'in amaci state/deger tutmak degildir.
-bir class birden fazla interface alabilir ama birden fazla abstract class miras alamaz
-abstract class bir blue print, sozlesme, kopya kagidi, sablon yaratirken -oz nitelikler belirlenir, default olasi gereken)(dogustan bir seyler verir, olmasi zorunlu seyleri yazar)
-interface'ler ozellik kazandirir   (insan icin yuzmek, araba kullanmak gibi)
-interface'ler arayuz olarak kullanilabilir :           <B> gibi.
        val carNames= Array<Unit>(10 -size bilgisi){
        println("adasd")     }

abstract classta sunu yapabiliriz;
    open val policeOfficer: Police = "Police"   ---> open vermek best practise degil, cok tercih etmiyoruz.


e peki get() ile deger atarsin??
ama bunu property oldugu icin yapabilirsin. Bu basitce bir get fonksiyonu. return eder, deger doner dogru fakat bu degeri degistiremeyiz, statictir.
gercek deger atama degil, bir nevi fonksyion. Java essembly koduna bakarsak anlariz.




interface icerisindeki intial degeri olmayan bir property(field) ya da body'si olmayan bir fonksiyon abstract olarak da tanimlanabilir


interfaceleri anlami geregi final yapamazsiniz. Open yazilmasi da gereksizdir (redundant)


abstract class > sozlesme, child classta olmasini istedigim seyleri burada topluyoruz
bu sekilde daha az kod yazarak daha fazla is yapmami saglar. Ayni zamanda bir seyleri override etmek zorunda birakir bizi
default olarak yapabildigimiz seyler
Yuruyebilmek, konusabilmek

interface > herhangi bir classin interface'e sahip olmasi demek beceri setini, yapabildiklerini arttiriyor demek
default olmayan, neleri yapabilecegini söylüyor.
Araba kullanmak, yuzmeyi bilmek




class'lar extend edilir, miras alinir. Miras alinsin diye yaziyoruz.
interface'ler implement edilir




abstract icinde open function yazmak vs interface yazmak;

abstract classtaki open fonksiyonu, abstracttan gelen bir yapiyi (degisken, fonksiyon vs) kullanmasi gerektigi icin yaziyoruzdur
eger her classta kullanmayacak ve bazi classlarda lazim olacaksa;
     bu classi miras alan bir class yazip, icin bu fonksiyonu yazalim. Lazim olan classta bu arada katmandaki classi miras alip fonksiyonu kullanalim. -->best practise
override edildigi child classta, cagrildigi super fonksiyonla bir is yapıyordur
buradaki fonksiyonu bir child classta sadece cagiriyoruz, tetikleyip baska bir yerde haber/bilgi gibi bir sey beklemeyiz
bir kopya kagidi, sozlesme: zorunlu olarak override edilmesini istedigimiz seyler yazili (temel amac)

interface: olmayan bir beceri katmak istersek interface yazariz, harici bilgiye ihtiyacimiz olmaz
bir classin icindeki bir yapiya ihtiyac duymazlar, implement edildigi bir yerde tetiklenmeyi beklerler
bir yerden tetikle, baska bir yerden calistiginin bilgisini/haberini al

 */
//----------------------------------------------------------------------------------------------------------------------

interface MyInterface {
    val prop: Int // abstract

    val propertyWithImplementation: String
        get() = "Foo"

    fun foo() {              // ---> kullanirken override etmek zorunda degiliz
        // cok dogru bir kullanim degil, ara interface yazip onu cagirmak daha dogru olur
        // bunu anca her islemde bulunmasini istedigimiz bir seyse yazabiliriz
        println(prop)
    }

    fun foo2()                  // ---> override etmek zorundayiz

}

//----------------------------------------------------------------------------------------------------------------------


//interface'lere tanimlanan property'lerde (field) inital deger alma zorunlulugu yoktur

interface Named {
    val fullName: String?
    //val fullName: String? = "asdasd"
}

// kullanmak icin : kullaniyoruz
// bir interface baska interface'i miras alabilir

interface Person : Named {
    val firstName: String
    val lastName: String

    override val fullName: String?              // burada fullName 'i override ettigim icin, bunu miras alacak yerlerde artik override etmek zorunda degilim !!!
        get() = "$firstName $lastName"
}


//----------------------------------------------------------------------------------------------------------------------


/*
Eger implement edilen bir interface, baska bir interface'i implement ediyorsa
ve bu interface'in uyeleri child interface'de override edilmis ise
child interface'i impelent eden class'da bu property'nin tekrar override edilmesi zorunlu degildir

 */

class Employee2 : Person {
    override val firstName: String
        get() = TODO("Not yet implemented")

    override val lastName: String
        get() = TODO("Not yet implemented")

    // alttaki zorunlu override degil, cunku ust classta override edilmisti

    override val fullName: String?
        get() = super.fullName

}


// Eger bir abstract class bir interface'i implement ediyorsa, o interface'in override edilmesi zorunlu fonksiyonlari
// override etmeyebilir. Abstract class'lar icin bu opsiyoneldir


abstract class Employee1 : Named {

}
//----------------------------------------------------------------------------------------------------------------------

/*

Bir interface icerisindeki fonksiyonlardan body'si olanlar override edilmek zorunda degildir.
Body'si olmayan tum fonksiyonlar ise class'a implement edildiginde override edilmek zorundadir.

Property'ler de interfacelere tanimlanabilirler

Property'lerden de deger atamasi yapimamis olanlar zorunlu olarak override edilirler,
ege property get fonksiyonu ile bir statik deger geri donduruyorsa, override edilme zorunlulugu kalkar.


interface icersinde tanimli ve override edilme zorunluugu olan properyler
primary construcor icersinde de override edilebilirler

 */


class Child(override val prop: Int = 29) : MyInterface {


    //override edilmek zorunda, cunku body'si yoktu interface'de
    override fun foo2() {
        TODO("Not yet implemented")
    }


    //body'si oldugu icin override edilme zorunlulugu yok
    fun bar() {
    }

    //body'si oldugu icin override edilme zorunlulugu yok
    override fun foo() {
        super.foo()
    }

    //override edilmesi zorunlu degildi
    override val propertyWithImplementation: String
        get() = "Foo"
}


//----------------------------------------------------------------------------------------------------------------------

interface A {
    fun foo() {
        println("B")
    }

    fun bar()

}

interface B {
    fun foo() {
        println("asdasd")
    }

    fun bar() {
        println("Bar")
    }
}


class C : A {
    override fun bar() {
        println("Barrrr")
    }
}

open class E {

}
//----------------------------------------------------------------------------------------------------------------------
/*
Birden fazla interface bir class'a tanimlanabilir.

Birden fazla interface bir class'a tanimlaniyorsa arasina virgul koyulur

super cagirabilmek icin bodysi olmak zorunda, super parenttaki fonksiyonu cagirir cunku.

Eger implement edilen 2 interfacede ayni fonksiyonlar var ise bu durumda bodyleri olsa da override edilmeleri zorunludur

 */
//----------------------------------------------------------------------------------------------------------------------

class D : E(), A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
        //      super<A>.bar () A interface'inin bir fonksiyonun bodys'si yok. Dolayisiyla super ile erisilemez.

        super<B>.bar()  // <B> arayuzunu yazmak zorunda kalmiyorsunuz. Buna redundant uyarisi verir. Cunku A'daki bar() 'in bodysi yok.
        super.bar()
    }


}


//----------------------------------------------------------------------------------------------------------------------

fun main() {


}


//----------------------------------------------------------------------------------------------------------------------
