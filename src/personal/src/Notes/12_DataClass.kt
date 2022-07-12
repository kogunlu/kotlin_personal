package personal.src.Notes

/**
 *
 *      DATA CLASS
 *
 */

//----------------------------------------------------------------------------------------------------------------------

/*
DATA CLASS NEDIR?
-- Veri / value tuttugumuz classtir (örnegin DB den gelen veriler)
-- Loglamasi daha kolay oluyor, classta neler oldugu gorebiliyoruz
-- toString, hashCode, copy, equal gibi fonksiyonlari kolayca kullanabiliyoruz override eetmeden.
-- her component icin component1, component2 gibi (parametre sayisi kadar) compononentN kadar yazilir otomatik olarak. Bu sekilde kodun okunakligi artar.
-- Super type olarak kullanilamaz. Miras alinamaz, ust sinif olamaz.
-- Bir interface'i implement edebilir ya da miras alabilir.
-- Icindeki, constructor disinda yazilan degiskenler bu otomatik fonksiyonlari almaz. Elle yazmamiz gerekir.
-!!- Var / val olarak yazilmasi zorunludur.
    CUNKU; parametrelere class disinda da erismek istiyoruz, erisebilmek icin bu sekilde yaratiyoruz.
    equal, hashCode gibi kodlari kullanabilmek icin bunlara erisebiliyor olmamiz gerekir. Bu fonksiyonlar arkada yazilirken bu degiskenlere erismek isteyecek.

DATA Class vs Duz Class farki nedir?
--Data classta bazi fonksiyonlar otomatik yazilirken, duz class'ta asagida verlien fonksiyonlar otomatik olarak olusturulmuyor
    (hashCode, copy, toString, equalst etc.)


1- Data class'lar en azindan mutlaka 1 parametre almak zorundadir
2- Parametreler mutlaka val ya da var ile tanimlanmak zorundadir
3- Open, abstract, sealed, inner class yapilamaz
4- Tüm data class'lari final oldugu icin final modifer'i yazmak redundant uyarisi verecektir

equals, hashCode, toString, copy, componentN fonksiyonlari arka planda default olarak olusturulur

Yukaridaki fonksiyonlardan biri override edilirse, oto generate edilen hali yazilmaz

Yukaridaki fonksiyonlar sadece primary const. icerisindeki degiskenlerle calisir

componentN fonksiyonlari sebebiyle destructturing declaration olarak data class'lar set edilebiliyor.
    --

toString gibi fonksiyonlarda primary const. degiskenleri kullanildigi icin val ya da var yazilmak zorunludur

Pair, Triple ozellestirilmis generic data class'lar mevcut

 */

//----------------------------------------------------------------------------------------------------------------------

data class News(                             // open yapamiyoruz, kendinden final'dir yani miras alinamaz, fakat miras alabilir
    val title: String = "Title",
    val description: String,
    val hasMediaContent: Boolean,               // bu degiskenlerin equals, hashCode gibi yukarda yazan fonksiyonlari default olarak otomatik olusturuluyor
    val mediaList: List<Media>
) {
    val relatedNewsList: List<News> =
        arrayListOf()       // contstructor disinda, iceriye uye bir degisken yazarsak, bu otomatik fonksiyonlar default olusturulmayacak

    override fun toString(): String {
        return "return super.toString()"
    }

    fun log() {
        println("Title: $title, description: $description")
    }
}

//----------------------------------------------------------------------------------------------------------------------


class NewsData(
    val title: String = "Title",
    val description: String,
    val hasMediaContent: Boolean,
    val mediaList: List<Media>
) {
    val relatedNewsList: List<News> = arrayListOf()

    override fun toString(): String {
        return "News(title= " + this.title + ", description=" + this.title + "hasMediaContent=" + this.hasMediaContent + "mediaList" + this.mediaList
    }
}

class Media


//----------------------------------------------------------------------------------------------------------------------

fun main() {
    val newsOne = News(
        title = "Yeni bir egitim donemi basladi!",
        description = "Egitim donemi yeni bir sekilde basladi",
        hasMediaContent = true,
        mediaList = arrayListOf()
    )

    val newsTwo = NewsData(
        "Yeni bir egitim donemi basladi!",
        "Egitim donemi yeni bir sekilde basladi",
        true,
        arrayListOf()
    )


//----------------------------------------------------------------------------------------------------------------------

    // okunakliligi arttirmak icin destructturing declaration yapabiliyoruz data class'larda
    // arka planda component olarak ataniyor otomatik, bu nedenle dogrudan cagirim yapabiliyoruz
    // component1, component2, ...

    val (title, description, hasMediaContent, mediaList) = newsOne
    val (title3, description3) = newsOne
    val (title4, description4, hasMediaContent4, mediaList4) = newsOne

 //   val (title2, description2, hasMediaContent2, mediaList2) = newsTwo      // duz class oldugu icin yapamiyoruz

    newsOne.mediaList // boyle ulasmak yerine
    mediaList  // seklinde de ulasabiliriz

//----------------------------------------------------------------------------------------------------------------------

    newsOne.toString()
    newsOne.hashCode()

    val newsThree =
        newsOne.copy(description = "Farkli description")  // 0'dan yaratmak yerine bu nesne ile ayni olsun, sadece description'i farkli olsun dedik
    newsOne.component1()

    val newsFour =
        News(                // data class degil, data class olsa ve copy kullanamasak boyle yazmamiz gerekecekti.
            title = newsOne.title,
            description = "Farkli description",
            hasMediaContent = newsOne.hasMediaContent,
            mediaList = newsOne.mediaList
        )

    newsOne.relatedNewsList
    newsOne.title

    // newsTwo.equals()
    // newsTwo.copy()
    //newsTwo.component1()
    newsTwo.toString()
    newsTwo.hashCode()

    println("Data class toString: $newsOne") //constructor parametreleri verecek dataClass oldugu icin
    println("Class to String: $newsTwo")  // icindeki parametreleri vermeyecek



}


//----------------------------------------------------------------------------------------------------------------------




