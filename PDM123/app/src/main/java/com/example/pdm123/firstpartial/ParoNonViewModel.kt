package com.example.pdm123.firstpartial

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ParoNonViewModel : ViewModel() {
    var evenOrOddStatus = MutableLiveData("")
    fun getResultStatus(): MutableLiveData<String> = evenOrOddStatus
    fun calcuEvenOrOdd(number: Int) {

        if (number != 0) {
            if (number % 2 == 0) {
                evenOrOddStatus.postValue("El numero es: Par")
            } else if (number % 2 == 1) {
                evenOrOddStatus.postValue("El numero es: Impar")
            }
        } else {
            evenOrOddStatus.postValue("El cero no esta definido")

        }

    }

}

