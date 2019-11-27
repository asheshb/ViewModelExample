package com.example.viewmodelexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CheckoutViewModel(id: Int, initialQty: Int): ViewModel(){

    private var _qty = MutableLiveData<Int>(initialQty)
    val qty: LiveData<Int>
        get()  = _qty

    val product = MutableLiveData<Product>(products.find {id == it.id })

    fun addQty(newQty: Int){
        _qty.value?.let{
            _qty.value = it + newQty
        }
    }

    fun reduceQty(newQty: Int){
        _qty.value?.let {
            if((it - newQty) > 1){
                _qty.value = it - newQty
            }
        }
    }
}