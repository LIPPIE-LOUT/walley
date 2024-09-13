package com.example.wallet.ui.theme.models


class Transaction{
    var date:String=""
    var day:String=""
    var amount:String=""
    var id:String=""

    constructor(date:String,day:String,amount:String,id:String){

        this.date = date
        this.day =day
        this.amount=amount
        this.id=id

    }
    constructor()
}