package com.entertailion.task

/**
 * created By mohammadmuddasir
 * Muddasir107@gmail.com
 */
class DataClassItems {
    var id:String? = null
    var slug:String? = null
     var type:String? = null
     var publi:String? = null
    constructor(id:String,slug:String,type:String,publi:String)
    {
     this.id=id
        this.slug=slug
        this.type = type
        this.publi = publi
    }
}