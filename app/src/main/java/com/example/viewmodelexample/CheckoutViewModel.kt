package com.example.viewmodelexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class CheckoutViewModel(id: Int, initialQty: Int, private val handle: SavedStateHandle): ViewModel(){
    companion object {
        private const val QTY = "QTY_KEY"
    }
    private var _qty = MutableLiveData<Int>()
    val qty: LiveData<Int>
        get()  = _qty

    private val _product = MutableLiveData<Product>(products.find {id == it.id})
    val product: LiveData<Product>
        get()  = _product

    init{
        _qty.value = handle[QTY]?: initialQty
        handle.set(QTY, _qty.value)
    }

    fun addQty(newQty: Int){
        _qty.value?.let{
            _qty.value = it  + newQty
            handle.set(QTY, _qty.value)
        }
    }

    fun reduceQty(newQty: Int){
        _qty.value?.let {
            if((it - newQty) > 0){
                _qty.value = it - newQty
                handle.set(QTY, _qty.value)
            }
        }
    }
}