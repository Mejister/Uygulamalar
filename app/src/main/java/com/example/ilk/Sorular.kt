package com.example.ilk

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.compose.ui.graphics.Color
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_sorular.*
import kotlinx.android.synthetic.main.activity_sorular.view.*

class Sorular : AppCompatActivity() {

    private var Name:String?=null
    private var Score:Int=0

    private var currentPositoion:Int=1
    private var  sorular:ArrayList<Soru_Verileri> ?=null
    private var secilensık:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_sorular)

        Name=intent.getStringExtra(Set_data.name)

        sorular=Set_data.Sorubul()

        soru_ayarla()
        seç1.setOnClickListener{
            selectedOptionStyle(seç1,1)
        }

        seç2.setOnClickListener{
            selectedOptionStyle(seç2,2)
        }

        seç3.setOnClickListener{
            selectedOptionStyle(seç3,3)
        }

        seç4.setOnClickListener{
            selectedOptionStyle(seç4,4)
        }

    işaretle.setOnClickListener {
        if (secilensık != 0) {
            val question = sorular!![currentPositoion - 1]
            if (secilensık != question.dogrusu) {
                setcolor(secilensık, R.drawable.yanlis_secilen_secenek_bg)

            } else {

                Score++
            }
            setcolor(question.dogrusu, R.drawable.dgru_secilen_secenek_bg)

            if (currentPositoion == sorular!!.size)
                işaretle.text = "Bitirdiniz"
            else
                işaretle.text = "Diğer soru"
        }else{
            currentPositoion++
            when{currentPositoion<=sorular!!.size -> {
                soru_ayarla()
            }
                else-> {
                    var intent=Intent(this,Sonuc::class.java)
                    intent.putExtra(Set_data.name,Name.toString())
                    intent.putExtra(Set_data.score,Score.toString())
                    intent.putExtra("Uzunluk",sorular!!.size.toString())
                    startActivity(intent)
                    finish()

                }

            }
        }
        secilensık=0
    }
    }
    fun setcolor (opt: Int, color: Int) {
        when(opt) {
            1 -> {
                seç1.background = ContextCompat.getDrawable(this, color)
            }
            2 -> {
                seç2.background = ContextCompat.getDrawable(this, color)
            }
            3 -> {
                seç3.background = ContextCompat.getDrawable(this, color)
            }
            4 -> {
                seç4.background = ContextCompat.getDrawable(this, color)
            }
        }

    }


    fun soru_ayarla() {
        setOptionStyle()

        val soru=sorular!![currentPositoion-1]
        çubuk.progress=currentPositoion
        çubuk.max=sorular!!.size
        çubuk_yazısı.text="${currentPositoion}" + "/"+"${sorular!!.size}"
        soru_text.text=soru.Sorular
        seç1.text=soru.seçenek1
        seç2.text=soru.seçenek2
        seç3.text=soru.seçenek3
        seç4.text=soru.seçenek4

    }
    fun setOptionStyle() {

        var optionList:ArrayList<TextView> = arrayListOf()
        optionList.add(0,seç1)
        optionList.add(1,seç2)
        optionList.add(2,seç3)
        optionList.add(3,seç4)

    for(op in optionList) {

        op.setTextColor(android.graphics.Color.parseColor("#555151") )
        op.background=ContextCompat.getDrawable(this,R.drawable.secenek_bg)
        op.typeface= Typeface.DEFAULT


    }

    }
    fun selectedOptionStyle(view: TextView,opt:Int) {
        setOptionStyle()
        secilensık=opt
        view.background=ContextCompat.getDrawable(this,R.drawable.secilen_secenek_bg)
        view.typeface=Typeface.DEFAULT_BOLD
        view.setTextColor(android.graphics.Color.parseColor("#000000"))


    }

}