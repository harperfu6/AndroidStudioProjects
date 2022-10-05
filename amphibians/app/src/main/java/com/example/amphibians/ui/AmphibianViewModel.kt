package com.example.amphibians.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibians.network.Amphibian
import com.example.amphibians.network.AmphibianApi
import kotlinx.coroutines.launch

class AmphibianViewModel: ViewModel() {

    private val _amphibians = MutableLiveData<List<Amphibian>>()
    val amphibians: LiveData<List<Amphibian>> = _amphibians

    private val _amphibian = MutableLiveData<Amphibian>()
    val amphibian: LiveData<Amphibian> = _amphibian

    fun onAmphibianClicked(amphibian: Amphibian) {
        _amphibian.value = amphibian
    }

    init {
        getAmphibians()
        Log.d("API", "initialize")
    }

    private fun getAmphibians() {

        // コルーチンの起動
        viewModelScope.launch {
            try {
                _amphibians.value = AmphibianApi.retrofitService.getAmphibians()
                Log.d("API", "number is ${_amphibians.value!!.size}")
            } catch (e: Exception) {
                Log.d("API", "get error!")
            }
        }
    }
}