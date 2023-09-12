package com.example.pdm123.firstpartial

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ParoNonViewModel : ViewModel() {
    var evenOrOddStatus = MutableLiveData("")
    var evenOrOddAnimation = MutableLiveData(false)
    fun getResultStatus(): MutableLiveData<String> = evenOrOddStatus
    fun getResultAnimation(): MutableLiveData<Boolean> = evenOrOddAnimation
    fun calcuEvenOrOdd(number: Int) {

        if (number != 0) {
            if (number % 2 == 0) {
                evenOrOddStatus.postValue("El numero es: Par")
                evenOrOddAnimation.postValue(true)
            } else if (number % 2 == 1) {
                evenOrOddStatus.postValue("El numero es: Impar")
                evenOrOddAnimation.postValue(false)
            }
        } else {
            evenOrOddStatus.postValue("El cero no esta definido")

        }

    }

}

