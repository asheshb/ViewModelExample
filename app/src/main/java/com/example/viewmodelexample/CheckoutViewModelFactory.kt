package com.example.viewmodelexample

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import androidx.lifecycle.SavedStateHandle as SavedStateHandle1

//class CheckoutViewModelFactory(private val id: Int, private val quantity: Int,
//                               owner: SavedStateRegistryOwner,
//                               defaultArgs: Bundle? = null) : ViewModelProvider.Factory {
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(CheckoutViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return CheckoutViewModel(id, quantity) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}

class CheckoutViewModelFactory(
    private val id: Int,
    private val quantity: Int,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle1
    ): T {
        return CheckoutViewModel(id, quantity, handle) as T
    }
}