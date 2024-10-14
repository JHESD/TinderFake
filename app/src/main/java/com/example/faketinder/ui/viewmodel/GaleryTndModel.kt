package com.example.faketinder.ui.viewmodel

import androidx.lifecycle.LiveData

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GaleryTndModel : ViewModel(){
    private val _siguiente: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(false)
    }
    val siguiente: LiveData<Boolean> get() = _siguiente

    private val _atras: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(false)
    }
    val atras: LiveData<Boolean> get() = _atras

    private val _terminar: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(false)
    }
    val terminar: LiveData<Boolean> get() = _terminar

    fun goNext(indice: Int, tamaño: Int) {
        if (indice < tamaño - 1) {
            _siguiente.value = true
        } else {
            _terminar.value = true
        }
    }

    fun goBack(indice: Int) {
        if (indice > 0) {
            _atras.value = true
        }
    }

    // Resetear el estado después de manejar la acción
    fun resetNext() {
        _siguiente.value = false
    }

    fun resetBack() {
        _atras.value = false
    }

}