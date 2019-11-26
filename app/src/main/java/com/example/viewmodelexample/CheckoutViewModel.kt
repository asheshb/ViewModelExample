package com.example.viewmodelexample

import androidx.lifecycle.*

class CheckoutViewModel(id: Int, initialQty: Int, private val handle: SavedStateHandle): ViewModel(){
    companion object {
        private const val ID = "ID_KEY"
        private const val QTY = "QTY_KEY"
    }
    private var _qty = MutableLiveData<Int>()
    val qty: LiveData<Int>
        get()  = _qty

    private val _product = MutableLiveData<Product>()
    val product: LiveData<Product>
        get()  = _product

    init{
        _qty.value = handle[QTY]?: initialQty
        val productId = handle[ID]?: id
        _product.value = products.find {productId == it.id}

        handle.set(ID, id)
        handle.set(QTY, _qty.value)
    }

    val trimmedDesc: LiveData<String> = Transformations.map(_product, ::trimDesc)

    private fun trimDesc(product: Product): String{
        return product.longDescription.substring(0, 50).toUpperCase()
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