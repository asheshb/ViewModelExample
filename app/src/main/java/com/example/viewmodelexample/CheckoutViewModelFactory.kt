package com.example.viewmodelexample

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import androidx.lifecycle.SavedStateHandle as SavedStateHandle1

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