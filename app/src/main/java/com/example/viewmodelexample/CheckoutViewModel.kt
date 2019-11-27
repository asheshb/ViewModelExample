package com.example.viewmodelexample

import androidx.lifecycle.ViewModel

class CheckoutViewModel(id: Int, initialQuantity: Int): ViewModel(){
    val product: Product? = products.find {id == it.id }

    private var _qty = initialQuantity

    val qty: Int
        get()  = _qty


    fun addQty(qty: Int){
        _qty += qty
    }

    fun reduceQty(qty: Int){
        if((_qty - qty) > 0){
            _qty -= qty
        }
    }
}