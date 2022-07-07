package personal.src.Notes

/**
 *
 *      Nested Inner Class
 *
 */

//----------------------------------------------------------------------------------------------------------------------

/*
--Class icinde class yaziyorsak bunun ismi nested class oluyor (adi farkli olabilir)


---Nested class'lar outer class'in uye propoerty'lerine ya da fonksiyonlarina erisemezler
Nested class'lar static olarak sanklanirlar. Bundan dolayi da outer class uzerinden nested class ulasmak istemeniz durumunda ;

--Outer.NestedClass()
                    seklinde erisilebilir.


+++Inner class'lar static olarak tutulmazlar. Bundan dolayi erisim yapmak istedigimizde
--Outer().InnerClass()
                      seklinde outer class'in da instance'ini olusturmamiz gerekmektedir.
                      bundan dolayi inner class outer class'in tum elemanlarina ulasabilir, private olsa dahi.




--- Inner class'in icerisinde yeni bir nested class eklenememektedir. Ancak yine inner class ekleyebiliriz.

+++ Nested class'in icerisine yeni bir nested ya da inner class ekleyebiliriz.




--!!-- NOT --!!--
Static tutulan class islem bitse de CPU'dan otomatik temizlenmez (garbage collector), performansi etkiler bu nedenle.


 */


//----------------------------------------------------------------------------------------------------------------------

// outer  -> dis anlaminda

class Outer {
    private val name = "Kuday"
    val surName = "Ogunlu"

    fun getAge(): Int = 27

    class NestedClass {
        fun printName() {
            //name
            //surname
            //age               --> ustteki siniftakilere erisemez: nestedClass
        }
    }
}


//----------------------------------------------------------------------------------------------------------------------


interface OuterIntergace {
    class DenemeA
    interface NestedInterface
}

//----------------------------------------------------------------------------------------------------------------------


class Outer2 {
    private val name = "Kuday"
    val surName = "Ogunlu"

    fun getAge(): Int = 27

    inner class InnerClass {
        fun printName() {
            name                        // icinde oldugu class'in parametre ve fonksiyonlarina erisebiliyor: Inner class
            surName
            getAge()
        }
    }

}


//----------------------------------------------------------------------------------------------------------------------
fun main() {


    val outer = Outer()
    outer.getAge()
    outer.surName
    // outer.name

    val outer2 = Outer2()
    outer2.getAge()
    outer2.surName
    // outer2.name

    outer2.InnerClass().printName()



    Outer().getAge()

    Outer.NestedClass().printName()         // Duz, ozel olmayan bir nested class kullandik, bu yuzden () kullanmadik.
    // Outer().NestedClass().printName()

    Outer2().InnerClass().printName()       // Inner kullandik o nedenle () eklememiz gerekti.


}


//----------------------------------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------------------------------
