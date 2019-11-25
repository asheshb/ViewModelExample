package com.example.viewmodelexample

import androidx.lifecycle.ViewModel

class CheckoutViewModel(id: Int, initialQty: Int): ViewModel(){
    private var _qty: Int = initialQty
    val qty: Int
        get()  = _qty

    val product: Product? = products.find {id == it.id }

    fun addQty(qty: Int){
        _qty += qty
    }

    fun reduceQty(qty: Int){
        if((_qty - qty) > 0){
            _qty -= qty
        }
    }
}