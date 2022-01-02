package com.example.cicekbahcesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cicekler_detay.*

class Cicekler_detay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cicekler_detay)

        var bundle:Bundle= intent.extras!!
        var adi=bundle.getString("Adi")
        var aciklama=bundle.getString("Aciklama")
        var resim=bundle.getInt("Resim")

        detay_adi.text=adi
        detay_aciklama.text=aciklama
        detay_resim.setImageResource(resim)



    }
}