package com.example.pdm123.firstpartial

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.example.pdm123.R
import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource

@Composable
fun FirstPartialTestView(navController: NavController, viewModel: FirstPartialTestViewModel) {
    var totalproduct by remember { mutableStateOf("") }
    var actualproduct by remember { mutableStateOf("") }
    var actualProductionValue by remember { mutableStateOf(0) }
    var multiplier by remember { mutableStateOf(80) }
    val percentProduct = viewModel.percentProduct.observeAsState(0.0)
    val context = LocalContext.current
    val redScreenState by viewModel.redscreen.observeAsState(false)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(if (redScreenState) Color.Red else Color.Transparent),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Image(
            painter = painterResource(id = R.drawable.manzanas),
            contentDescription = "Image",
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(id = R.string.total_production))
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = totalproduct,
                    onValueChange = {
                        totalproduct = it
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.manzana),
                    contentDescription = "add",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            val total = totalproduct.toIntOrNull() ?: 0
                            val result = total * 80
                            val message = "$result apples in total"
                            showToast(context, message)
                        }
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(id = R.string.current_production))
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = actualproduct,
                    onValueChange = {
                        actualproduct = it
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.manzana),
                    contentDescription = "add",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            val total = actualproduct.toIntOrNull() ?: 0
                            val result = total * 80
                            val message = "$result apples currently"
                            showToast(context, message)
                        }
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = {
                viewModel.addActualProduction(5)
                val newValue = actualProductionValue + 5
                actualProductionValue = newValue
                actualproduct = newValue.toString()
            }) {
                Text(text = "+5")
            }
            Spacer(modifier = Modifier.width(12.dp))
            Button(onClick = {
                viewModel.addActualProduction(15)
                val newValue = actualProductionValue + 15
                actualProductionValue = newValue
                actualproduct = newValue.toString()
            }) {
                Text(text = "+15")
            }
            Spacer(modifier = Modifier.width(12.dp))
            Button(onClick = {
                viewModel.addActualProduction(30)
                val newValue = actualProductionValue + 30
                actualProductionValue = newValue
                actualproduct = newValue.toString()
            }) {
                Text(text = "+30")
            }
            Spacer(modifier = Modifier.width(12.dp))
            Button(onClick = {
                viewModel.addActualProduction(50)
                val newValue = actualProductionValue + 50
                actualProductionValue = newValue
                actualproduct = newValue.toString()
            }) {
                Text(text = "+50")
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = stringResource(id = R.string.percentage))
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "${percentProduct.value}%")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val total = totalproduct.toIntOrNull() ?: 0
                val actual = actualproduct.toIntOrNull() ?: 0
                if (total > 0) {
                    viewModel.updateTotalProduction(total)
                    viewModel.actualProduction.value = actual
                    viewModel.calculatePercentage()
                }
            }
        ) {
            Text(text = stringResource(id = R.string.calculate))
        }
    }
}

fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}







