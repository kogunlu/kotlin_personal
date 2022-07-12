package personal.src.Notes

/**
 *
 *      Object Singleton
 *
 */

//----------------------------------------------------------------------------------------------------------------------
/*

1) Singleton pattern nedir?
Bir class nesnesinin, memory'de herhangi bir T anında, 1 tane olmasina object singleton diyoruz.
class'in nesnesinden memory'de ayni anda sadece 1 tane olmasini istiyoruz.
Her ekranda, kullanimda yeni bir nesne olusturmak istemeyiz.


2) Singleton pattern'in eksileri nedir?
Java karsiliginda static keywordu ile yazildigi icin, yanlis ve gereksiz kullanimlarda (ornek veri tasimak icin kullanmak)
    garbage collector'in toplamadigi veri sayisi artacak.
Bu da memory leak'e sebep olabilir.

 */

/**
 *  Ozetle JAVA'da 3 adimda yapilir;
 *
 *  1- Constructor'i private olarak olustur
 *  2- Class'in icinde kendisinin degiskenini olustur (volatile static olarak)
 *  3- Bu degiskeni donduren bir newInstance() fonksiyonu yaz (synchronized static olarak) -- null check yaparak --
 *
 */

//----------------------------------------------------------------------------------------------------------------------

//              Kotlin'de kullanim sekli asagidaki gibidir;

object ProfileKotlin{
    var nickName: String? = null
    var counter: Int = 0
}




//----------------------------------------------------------------------------------------------------------------------
fun main() {

    ProfileKotlin.nickName = "kOgunlu"
    ProfileKotlin.counter++
    ProfileKotlin.counter++
    ProfileKotlin.counter++
    ProfileKotlin.counter++

    println(ProfileKotlin.counter)

}




//----------------------------------------------------------------------------------------------------------------------

