package com.example.pdm123.firstpartial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class BarberShopViewModel {
    val currentCutCount = MutableLiveData(0)
    val currentBeardCount = MutableLiveData(0)
    val currentCBCount = MutableLiveData(0)

    private val cutPrice = 100
    private val beardPrice = 400
    private val cutBeardPrice = 500

    fun incrementCut(cutValue: Int, cutPrice: Int) {
        val newCount = currentCutCount.value ?: 0
        currentCutCount.value = newCount + cutValue
        updateTotal()
    }

    fun incrementBeard(beardValue: Int, beardPrice: Int) {
        val newCount = currentBeardCount.value ?: 0
        currentBeardCount.value = newCount + beardValue
        updateTotal()
    }

    fun incrementCutBeard(cutBeardValue: Int, cutBeardPrice: Int) {
        val newCount = currentCBCount.value ?: 0
        currentCBCount.value = newCount + cutBeardValue
        updateTotal()
    }

    private val total = MutableLiveData(0)
    fun getTotal(): LiveData<Int> = total

    private fun updateTotal() {
        val cutCount = currentCutCount.value ?: 0
        val beardCount = currentBeardCount.value ?: 0
        val cutBeardCount = currentCBCount.value ?: 0

        val totalPrice = (cutCount * cutPrice) + (beardCount * beardPrice) + (cutBeardCount * cutBeardPrice)
        total.value = totalPrice
    }
}

