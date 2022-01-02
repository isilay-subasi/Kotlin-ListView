package com.example.cicekbahcesi
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cicek_karti.view.*


class MainActivity : AppCompatActivity() {

    var List=ArrayList<Cicekler>()
    //listview kullanıyorsak , adapter kullanmamız gerekir.
    var adapter : CiceklerAdapter?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        List.add(Cicekler("Gül","Açıklama",R.drawable.gul))
        List.add(Cicekler("Kasımpatı","Açıklama",R.drawable.kasimpati))
        List.add(Cicekler("Lale","Açıklama",R.drawable.lale))
        List.add(Cicekler("Menekşe","Açıklama",R.drawable.menekse))
        List.add(Cicekler("Nergis","Açıklama",R.drawable.nergiz))
        List.add(Cicekler("Orkide","Açıklama",R.drawable.orkide))
        List.add(Cicekler("Ortanca","Açıklama",R.drawable.ortanca))
        List.add(Cicekler("Papatya","Açıklama",R.drawable.papatya))




        //listede sıralamak için adapteri verdik.
        adapter = CiceklerAdapter(List,this)
        listView.adapter=adapter




    }


    class CiceklerAdapter: BaseAdapter {

        //geçici liste oluşturduk.
        var list =ArrayList<Cicekler>()
        var context : Context?=null

        //değişkenlerimizi tanımladık.Bunları kurucu metotlara atıyorum.

        constructor(list : ArrayList<Cicekler>,context : Context):super(){
            this.list=list
            this.context=context
        }


        override fun getCount(): Int {
            //kaç kere döndürecek
           return list.size
        }

        override fun getItem(p0: Int): Any {
            //listemizin positionını verecektir.
            return list[p0]
        }

        override fun getItemId(p0: Int): Long {
            //ıtemlerin ıdilerinin pozitisionlarını verecektir.
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            //Amacım cicek_karti.xml sayfasına ulaşmak ve burdaki isim,açıklama,resime erişmek


            // Ana activitede sıralamak için kullanılır.
            var posCicekler= list[p0]
            var inflator= context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var cicekKarti=inflator.inflate(R.layout.cicek_karti,null)
            cicekKarti.cardName.text=posCicekler.name
            cicekKarti.cardComment.text=posCicekler.comment
            cicekKarti.cardImage.setImageResource(posCicekler.image!!)

            //Resime tıklayınca başka sayfaya geçmeyi sağlayan kısım
            cicekKarti.cardImage.setOnClickListener {

                var intent=Intent(context,Cicekler_detay::class.java)
                intent.putExtra("Adi",posCicekler.name)
                intent.putExtra("Aciklama",posCicekler.comment)
                intent.putExtra("Resim",posCicekler.image)
                context!!.startActivity(intent)

            }




            return cicekKarti
        }

    }




}