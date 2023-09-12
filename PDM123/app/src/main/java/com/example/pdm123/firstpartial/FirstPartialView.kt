package com.example.pdm123

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pdm123.navigation.NavRoutes

@Composable
fun FirstPartialView(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(id = R.string.first_partial),
            color = MaterialTheme.colors.secondary
        )
        Button(
            onClick = { navController.navigate(route = "padelscore") },
            modifier = Modifier
                .fillMaxWidth() // Fill the available width
                .padding(16.dp) // Add padding
        ) {
            Text(text = stringResource(id = R.string.padel_score))
        }
        Button(
            onClick = { navController.navigate(route = "evenorodd") },
            modifier = Modifier
                .fillMaxWidth() // Fill the available width
                .padding(16.dp) // Add padding
        ) {
            Text(text = stringResource(id = R.string.even_or_odd))
        }
        Button(
            onClick = { navController.navigate(route = "randomcard") },
            modifier = Modifier
                .fillMaxWidth() // Fill the available width
                .padding(16.dp) // Add padding
        ) {
            Text(text = stringResource(id = R.string.random_card))
        }
    }
}
