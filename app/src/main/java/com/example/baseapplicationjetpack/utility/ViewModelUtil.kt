package com.example.baseapplicationjetpack.utility

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

fun <T : ViewModel> createFor(model: T): ViewModelProvider.Factory {
    return object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(model.javaClass)) {
                return model as T
            }
            throw IllegalArgumentException("unexpected model class $modelClass")
        }
    }
}