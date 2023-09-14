package com.example.pdm123

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pdm123.firstpartial.RandomCardViewModel


@Composable
fun RandomCardView(navController: NavController, viewModel: RandomCardViewModel) {
    val cardId by viewModel.getImage().observeAsState(R.drawable.back)
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = cardId),
            contentDescription = "Image",
            modifier = Modifier
                .height(450.dp)
                .width(450.dp)
        )
        Row() {
            Button(
                onClick = { viewModel.hideCard() }
            ) {
                Text(text = stringResource(id = R.string.hide))
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(
                onClick = { viewModel.getRandomNumber() }
            ) {
                Text(text = stringResource(id = R.string.random))
            }
        }
    }
}