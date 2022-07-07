package personal.src.Notes

/**
 *
 *      Type Alias
 *
 */

//----------------------------------------------------------------------------------------------------------------------

/*
Nested ya da local typeAlias kullanimi desteklenmiyor.
Local ve nested olamamasinin sebebi butun projede kullanabilir olmak istiyoruz karmasayi azaltmak icin.

typeAlias'lar arka planda yeni bir class olusturmazlar. Sadece etiketleme yaparlar.



 */

class ProjectContractChargingPeriodProjectAccountReverenceVM{

}

val projectContractChargingPeriodProjectAccountReferenceVM = ProjectContractChargingPeriodProjectAccountReverenceVM()
// class'a ait nesne olusturduk (best practice -> class ismi ayni, sadece ilk harfi kucuk)

typealias AccountReferenceVM = ProjectContractChargingPeriodProjectAccountReverenceVM
// typealias yaparak bir class olusturmuyoruz, bir referans yaratarak map'leme yapabilir oluyoruz. Etiketleme icin kullaniyoruz.

//----------------------------------------------------------------------------------------------------------------------
fun main() {

    // typealias AccountReferenceVM = ProjectContractChargingPeriodProjectAccountReverenceVM


    val accountReferenceVM = AccountReferenceVM()

}


//----------------------------------------------------------------------------------------------------------------------
