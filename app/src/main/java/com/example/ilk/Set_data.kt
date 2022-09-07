package com.example.ilk

object  Set_data {
    const val name:String="isim"
    const val score:String="Skor"

    fun Sorubul(): ArrayList<Soru_Verileri> {
        var sıra: ArrayList<Soru_Verileri> = arrayListOf()
        var s1 = Soru_Verileri(
            Sorular = "Türkiye'nin Başkenti Neresidir?",
            id = 1 ,
            seçenek1 = "Adana" ,
            seçenek2 = "İzmir" ,
            seçenek3 = "İstanbul" ,
            seçenek4 = "Ankara" ,
            dogrusu = 4
        )

            var s2 = Soru_Verileri(
            Sorular = "Türkiye'nin en güzel ili Neresidir?",
            id = 2 ,
            seçenek1 = "Mersin" ,
            seçenek2 = "İzmir" ,
            seçenek3 = "Çankırı" ,
            seçenek4 = "Ankara" ,
            dogrusu = 1
            )

            var s3 = Soru_Verileri(
            Sorular = "Türkiye'nin en batıdaki ili Neresidir?",
            id = 3 ,
            seçenek1 = "Kırklareli" ,
            seçenek2 = "İzmir" ,
            seçenek3 = "Çanakkale" ,
            seçenek4 = "Tekirdağ" ,
            dogrusu = 3
            )

            var s4 = Soru_Verileri(
            Sorular = "Türkiye'nin en yüzölçümü küçük ili neresidir?",
            id = 4 ,
            seçenek1 = "Bartın" ,
            seçenek2 = "Kilis" ,
            seçenek3 = "Yalova" ,
            seçenek4 = "Düzce" ,
            dogrusu = 3
            )

             var s5 = Soru_Verileri(
            Sorular = "Türkiye'nin en uzak iki şehri arasındaki kuşuçuşu mesafe yaklaşık kaç km'dir ?",
            id = 5 ,
            seçenek1 = "1400" ,
            seçenek2 = "1600" ,
            seçenek3 = "1800" ,
            seçenek4 = "2000" ,
            dogrusu = 2
             )



        sıra.add(s1)
        sıra.add(s2)
        sıra.add(s3)
        sıra.add(s4)
        sıra.add(s5)

        return sıra ;

    }

}
