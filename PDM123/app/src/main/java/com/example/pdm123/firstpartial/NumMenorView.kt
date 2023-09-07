package com.example.pdm123

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavController
import com.example.pdm123.firstpartial.NumMenorViewModel

@Composable
fun NumMenorView (navController: NavController, viewModel: NumMenorViewModel){
    var number1 by remember { mutableStateOf("") }
    var number2 by remember { mutableStateOf("") }
    var number3 by remember { mutableStateOf("") }
    val minorNumber by viewModel.getMin().observeAsState(0)



    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Cual es el menor?")
        TextField(
            value = number1,
            onValueChange = {
                number1 = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        )
        TextField(
            value = number2,
            onValueChange = {
                number2 = it
                
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        )
        TextField(
            value = number3,
            onValueChange = {
                number3 = it
                
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        )
        Button(
            onClick = { viewModel.getMinor(number1.toInt(),number2.toInt(),number3.toInt()) }
        ) {
            Text(text = "Consultar")
        }
        Text(text = "El numero menor es: $minorNumber")
    }
}