fun main() {

    /**
     *                       INFIX FONKSIYONLAR
     */

//----------------------------------------------------------------------------------------------------------------------


/*              Infix fonksiyonların kullanım amacı daha okunaklı kod yazabilmektir.
                Bu sayede fonksiyonu cagirirken . kullanmamiz gerekmez

                Bir fonksiyonu infix fonksiyon haline getirebilmemiz icin 5 sart vardir
                1- infix keywordu ile baslar
                2- fonksiyon bir uye fonksiyon olmalidir (bir class icinde yer almalidir)
                3- ya da extension fonksiyon olmalidir
                4- sadece bir parametre almalidir. Bu parametre vararg olamaz
                5- infix method'un parametresi default deger alamaz.

                Yapisal olarak;

                infix fun infixMethod ( justOneParam: AwesomeParam): Whatever {

                }
*/
//----------------------------------------------------------------------------------------------------------------------


    val isStudent = true
    val isMale = true


    // Once normal bir fonksiyon yaratalim;

    if (isStudent and isMale) {
        println("Erkek ogrenci")
    }

    isStudent.and(isMale)

    // infix kullanimi
    isStudent and isMale

//----------------------------------------------------------------------------------------------------------------------


    class awesomeClass {

        infix fun specialPlus(number : Int): Int {
            return 4
        }


    }

    awesomeClass().specialPlus(4)

    awesomeClass() specialPlus 4    // infix kullanimi



//----------------------------------------------------------------------------------------------------------------------









//----------------------------------------------------------------------------------------------------------------------








//----------------------------------------------------------------------------------------------------------------------




}