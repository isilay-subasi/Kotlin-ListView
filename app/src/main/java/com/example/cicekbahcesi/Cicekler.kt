package com.example.cicekbahcesi

class Cicekler {

    //variable declaration
    var name:String?=null
    var comment:String?=null
    var image:Int?=null

    //constrctor
    /*
    Constructor : Sınıftan üretilmiş nesnelerin değişkenlerin başlangıç değerlerinin belirlemek için
    kullanılan özel bir metottur.
     */
    constructor(name:String,comment:String,image:Int){

        this.name=name
        this.comment=comment
        this.image=image
    }



}