package com.example.pdm123.firstpartial

import androidx.lifecycle.MutableLiveData

class NumMenorViewModel {
    var minNumber = MutableLiveData(0)
    fun getMin(): MutableLiveData<Int> = minNumber


    fun getMinor(number1: Int,number2: Int,number3: Int){
        val minorNumber = minOf(number1, number2, number3)
        minNumber.postValue(minorNumber)
    }
}

