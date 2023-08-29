package com.example.pdm123

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController

@Composable
fun PadelScoreView(navController: NavController) {
    Column {
        Text(text = stringResource(id = R.string.padel_score))

    }

}