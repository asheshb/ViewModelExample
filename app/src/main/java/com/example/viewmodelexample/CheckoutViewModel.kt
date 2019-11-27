package com.example.viewmodelexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class CheckoutViewModel(id: Int, initialQty: Int): ViewModel(){
    private var _qty = MutableLiveData<Int>()
    val qty: LiveData<Int>
        get()  = _qty

    val _product = MutableLiveData<Product>(products.find {id == it.id })
    val product: LiveData<Product>
        get()  = _product

    val trimmedDesc: LiveData<String> = Transformations.map(_product, ::trimDesc)

    private fun trimDesc(product: Product): String{
        return product.longDescription.substring(0, 50).toUpperCase()
    }

    fun addQty(newQty: Int){
        _qty.value?.let{
            _qty.value = it  + newQty
        }
    }

    fun reduceQty(newQty: Int){
        _qty.value?.let {
            if((it - newQty) > 0){
                _qty.value = it - newQty
            }
        }
    }
}

