package com.example.pdm123

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.pdm123.firstpartial.ParoNonViewModel
import com.example.pdm123.ui.theme.utils.ComposeLottieAnimation

@Composable
fun ParoNonView(navController: NavController, viewModel: ParoNonViewModel) {
    /**
     * Esta variable va almacenar el valor de la caja de TextField
     */
    var txtnumber by remember { mutableStateOf("") }
    val status by viewModel.getResultStatus().observeAsState("")
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        ComposeLottieAnimation(modifier = Modifier.height(200.dp).width(200.dp))
        Text(text = "Ingresa un numero")
        TextField(
            value = txtnumber,
            onValueChange = {
                txtnumber = it
                if (txtnumber != "") {
                    viewModel.calcuEvenOrOdd(txtnumber.toInt())
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        )

        Text(text = status)
    }
}