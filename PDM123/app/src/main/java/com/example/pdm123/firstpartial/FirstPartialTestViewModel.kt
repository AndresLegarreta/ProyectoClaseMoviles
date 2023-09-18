package com.example.pdm123.firstpartial

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData


class FirstPartialTestViewModel {

    var totalProduction = MutableLiveData(0)
    var actualProduction = MutableLiveData(0)
    var percentProduct = MutableLiveData(0.0)
    var redscreen = MutableLiveData(false)

    init {
        totalProduction.value = 0
        actualProduction.value = 0
    }

    fun updateTotalProduction(total: Int) {
        totalProduction.value = total
    }

    fun addActualProduction(amount: Int) {
        val currentProduction = actualProduction.value ?: 0
        actualProduction.value = currentProduction + amount
        calculatePercentage()
    }

    fun calculatePercentage() {
        val total = totalProduction.value ?: 1
        val actual = actualProduction.value ?: 0
        val calcuPercentage = (actual.toDouble() / total.toDouble()) * 100
        percentProduct.value = calcuPercentage


    }
    fun calculateToastTotal(total: Int) {
            val newValue = total * 80
            val message = "Valor total multiplicado por 80: $newValue"
            showToast(message)
    }

    fun calculateToastActual(actual: Int) {
            val newValue = actual * 80
            val message = "Valor actual multiplicado por 80: $newValue"
            showToast(message)

        }

    }
    private fun showToast(message: String){
}
















