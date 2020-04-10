package com.example.musicalapp.ui.qr

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QrViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is qr Fragment"
    }
    val text: LiveData<String> = _text
}