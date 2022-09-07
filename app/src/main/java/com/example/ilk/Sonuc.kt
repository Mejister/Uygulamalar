package com.example.ilk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sonuc.*

class Sonuc : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_sonuc)
        val kullanici_adi =intent.getStringExtra(Set_data.name)
        val skor=intent.getStringExtra(Set_data.score)
        val toplamsoru=intent.getStringExtra("Uzunluk")

        tebrik.text="! Tebrikler ${kullanici_adi} !"
        skorr.text="${skor} / ${toplamsoru}"
        bitir.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
                finish()
        }
    }
}