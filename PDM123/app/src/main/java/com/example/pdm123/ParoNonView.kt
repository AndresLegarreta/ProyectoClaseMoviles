package com.example.pdm123

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController

@Composable
fun ParoNonView(navController: NavController) {
    Column {
        Text(text = stringResource(id = R.string.even_or_odd))

    }

}