package com.example.pdm123.firstpartial

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pdm123.R

class ParoNonViewModel : ViewModel() {
    var evenOrOddStatus = MutableLiveData(0)
    var evenOrOddAnimation = MutableLiveData(false)
    fun getResultStatus(): MutableLiveData<Int> = evenOrOddStatus
    fun getResultAnimation(): MutableLiveData<Boolean> = evenOrOddAnimation
    fun calcuEvenOrOdd(number: Int) {

        if (number != 0) {
            if (number % 2 == 0) {
                evenOrOddStatus.postValue(R.string.even)
                evenOrOddAnimation.postValue(true)
            } else if (number % 2 == 1) {
                evenOrOddStatus.postValue(R.string.odd)
                evenOrOddAnimation.postValue(false)
            }
        } else {
            evenOrOddStatus.postValue(R.string.zero)

        }

    }

}

