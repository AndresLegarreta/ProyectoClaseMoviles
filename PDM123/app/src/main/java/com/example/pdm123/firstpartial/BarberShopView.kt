package com.example.pdm123.firstpartial

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pdm123.R

@Composable
fun BarberShopView(navController: NavController, viewModel: BarberShopViewModel) {
    val total by viewModel.getTotal().observeAsState(0)


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            verticalAlignment = Alignment.Top
        ) {
            val cutPrice = 100
            val beardPrice = 400
            val cutBeardPrice = 500

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Counter(viewModel.currentCutCount.value ?: 0) { count ->
                    viewModel.incrementCut(1, cutPrice)
                }
                Image(
                    painter = painterResource(id = com.example.pdm123.R.drawable.corte),
                    contentDescription = "Image",
                    modifier = Modifier
                        .height(70.dp)
                        .width(70.dp)
                        .clickable { viewModel.incrementCut(1, cutPrice) }
                )
                Spacer(modifier = Modifier.width(80.dp))
                Text(text = "$cutPrice")
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Counter(viewModel.currentBeardCount.value ?: 0) { count ->
                    viewModel.incrementBeard(1, beardPrice)
                }
                Image(
                    painter = painterResource(id = com.example.pdm123.R.drawable.barba),
                    contentDescription = "Image",
                    modifier = Modifier
                        .height(70.dp)
                        .width(70.dp)
                        .clickable { viewModel.incrementBeard(1, beardPrice) }
                )
                Spacer(modifier = Modifier.width(80.dp))
                Text(text = "$beardPrice")
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Counter(viewModel.currentCBCount.value ?: 0) { count ->
                    viewModel.incrementCutBeard(1, cutBeardPrice)
                }
                Image(
                    painter = painterResource(id = com.example.pdm123.R.drawable.corteybarba),
                    contentDescription = "Image",
                    modifier = Modifier
                        .height(70.dp)
                        .width(70.dp)
                        .clickable { viewModel.incrementCutBeard(1, cutBeardPrice) }
                )
                Spacer(modifier = Modifier.width(80.dp))
                Text(text = "$cutBeardPrice")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(id = R.string.total))
            Text(text = "$total")
        }
    }

        }
@Composable
fun Counter(count: Int, onClick: (Int) -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "$count")
    }

}










