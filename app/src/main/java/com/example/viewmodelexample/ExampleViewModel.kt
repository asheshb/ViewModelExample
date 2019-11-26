package com.example.viewmodelexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ExampleViewModel: ViewModel(){
    private var _productId = MutableLiveData<Int>()

//    val product: LiveData<Product> = Transformations.switchMap(_productId, ::getProduct)
//
//    private fun getProduct(id: Int): LiveData<Product>{
//        //Returns LiveData from database
//    }

    fun setProductId(id: Int){
        _productId.value = id
    }
}