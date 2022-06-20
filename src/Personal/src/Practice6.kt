fun main() {

/**
 *                       Higher-Order FONKSIYONLAR
 */


/*

                Fonskiyonlar kotlin'de "First class citizen"dir.
                -Yani degiskene deger olarak atanabilir
                -Baska fonksiyonlara parametre olarak verilebilir
                -Bir fonksiyonun geri donus degeri olabilir


        Basitce bir fonksiyonun body kismina (suslu parantezler icinde kalan kismina) da fonksiyon yazilmasidir.


            !!!!   Higher order fonksiyonlar en basit haliyle fonksiyon body'sidir.    !!!!

 */


//----------------------------------------------------------------------------------------------------------------------

    /*
                 2 kisimdan olusur;

                 1- Bir fonksiyonun parametre olarak yazilmasi
                 2- Bu fonksiyon cagirildiginda nasil yazmamiz gerekiyor

     */


//----------------------------------------------------------------------------------------------------------------------


        //          1-  Fonksiyona parametre olarak yazma


    fun foo(higherOderFunction: (text: String) -> String){
        higherOderFunction("Codemy")
    }


    val surName = "Ogunlu"

//----------------------------------------------------------------------------------------------------------------------


        //          2-  Fonksiyon cagirilirken yazma



    /*
            foo({ text ->
               println("Message : $text")
            })

     */

//----------------------------------------------------------------------------------------------------------------------

        // 1. yol
            // Bir degiskene atayarak kullanim
            // Eger higher order fonksiyonu tek bir parametre aliyorsa, bu parametreyi yazmak zorunda degiliz
            // Bu durumda otomatik olarak "it" kelimesi ile otomatik bir parametre olusur

        val higherOderFunction = { message: String ->
                println("Surname: $surName")
                     "surName : $surName"
         }


//----------------------------------------------------------------------------------------------------------------------


        // 2. yol
            // Ismi olmayan bir "anonymous fonksiyon" tanimlamalari ile kullanim


        val anonymousFunction = fun (surName: String) : String {
            return "surname: $surName"
        }

            // expression olarak da kullanilir

        val anonymousFunction2 = fun (surname: String) : String = "surname: $surName"

//----------------------------------------------------------------------------------------------------------------------


        // 3. yol   ----> BEST PRACTISE

            // Bu kullanim icin gereken sartlar sunlar;

                // 1- Ayni sayida parametre olacak
                // 2- Parametre tipi ile donus tipi ayni olacak


        fun logPrint (message: String, count: Int): String {
            return "Log: $message count: $count"
        }


        fun foo2(higherOderFunction2: (message: String, count: Int) -> String) {
            higherOderFunction2("Codemy", 15)
        }

         foo2(::logPrint)

//----------------------------------------------------------------------------------------------------------------------

            // Ornek

    fun getItemClickListener(onClick: (String) -> Unit) {

        println("Tiklama islemi baslatiliyor")
            onClick("Login")
        println("Tiklama islemi bitti")

    }





//----------------------------------------------------------------------------------------------------------------------










//----------------------------------------------------------------------------------------------------------------------
}