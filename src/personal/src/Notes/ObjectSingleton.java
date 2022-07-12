package personal.src.Notes;



/**
Adim adim yapilacaklar;

1- Class'in 1 tane constructor'i olduguna ve bunun private olduguna emin ol ( default olarak java'nin olusturdugu bos olan public constructor'i private'a cek)
        private Profile()

2- İceride bir tane class'in instance'ini olustur
         private Profile profile;

3- Bu degiskeni dondurecek olan bir tane public fonksiyon yaz
        public  Profile newInstance() {
            return new Profile();
        }

4- 3. adimi oyle bir yaz ki bu nesnenin null olup olmadigi kontrol edilsin, null'sa yeni deger olusturup atasin null degilse oncekini var olani donsun
            if(profile == null){
                profile = new Profile();
            }
                return profile;

5- a)) Olusturdugumuz newInstance() 'a disaridan erisilebilmesi icin onune static keyword'u koyuyoruz.
   b)) Bunu yapabilmek icin de bu fonksiyonun kullandigi nesneyi de static yapmaliyiz

        a)) public static Profile newInstance()
        b)) private static Profile profile;     --> disaridan erisimi kapatmak icin private olarak olusturduk

6- 2 tane daha keyword ekleyecegiz;
    a)) synchronized  : fonksiyona ayni anda farkli thread'ler ile erisilse bile, milisaniye ile ilk erisen haricinde digerlerine fonksiyonu kapatir.
                        Boylece ayni anda sadece 1 kere kullanilir.
        public synchronized static Profile newInstance()

    b)) volatile    : synchronized ile ayni isi yapan, fakat degiskenler icin kullanilan keyword.
                      Bunu yapmamizin sebebi reflection kullanimina karsi guvenlik saglamaktir.
        private volatile static Profile profile;

*/


/*
class Profile {


    private Profile profile;   // 2. adim --> Bir tane Profile nesnesi koyduk, private disaridan erisilemeyecek demek
                                // " private Profile profile " seklinde bir nesne olusturduk

    public String name;

    private Profile() {             // 1. adim -> constructor private olarak yazildi, disardan nesne olusturulamaz oldu

    }

    public  Profile newInstance() {      // 3. adim  --> 2. adimdaki olusturdugumuz nesneyi donen public bir get() fonksiyonu yazdik.
                                         // Profile newInstance() dedigimiz sey aslinda Profile getProfile() ile ayni sey, isimlendirmesi newInstance() olarak yapiliyor
        return new Profile();
    }
}

 */


class Profile {


    private volatile static Profile profile;   // 6. adim --> 5. adimdaki fonksiyonu static yapabilmek icin bu nesneyi de static yapmamiz gerekiyor.



    private Profile() {

    }

    public synchronized static Profile newInstance() {      // 4. adim  --> static keyword'u verdik,
                                                // bu sekilde sinifin instance'i olmadan ( Profile() nesnesini olusturmadan ) disaridan bu fonksiyona erisebileceğiz
                                                 // Profile.newInstance() seklinde erisebiliyoruz artik

                                                // 5. adim --> her kullanimda yeni bir Profile() olusturacak, bunun yerine 1. den sonraki cagirimlarda ilk olusturulan donsun istiyoruz
        if(profile == null){                    // Bunu yapmak icin de, eger profile null'sa, yeni bir profile nesnesi olustur ve bunu ata diyoruz.
            profile = new Profile();
        }
        return profile;                          // null degilse else case'i calisacak. ---> olusturulmus olan Profile nesnesini dondur. ( Static oldugu icin garbage collector bunu temizlememisti. )
    }
                                                // 7. adim ---> synchronized keyword'u ekledik.
                                                // Bu sekilde ayni anda 3 yerden cagrilsa dahi (3 thread (paralel calisan kod blogu), 3 cekirdek üzerinde paralel olarak yapilmasi gibi)
                                                // milisaniye ile ilk calisan digerlerinin onune gecmis oluyor

                                                // 8. adim ---> volatile keyword'u eklendi.

    public String name;

    //istege bagli, kac defa cagrildigini gormek icin counter ekleyebiliriz;
    private int counter;

    public int getCounter(){
        return counter;
    }
    public void setCounter(int increasedValue){
        counter += increasedValue;
    }

}
