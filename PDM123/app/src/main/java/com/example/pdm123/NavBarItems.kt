package com.example.pdm123

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

object NavBarItems {
    val  NavBarItems = listOf(
        BarItem(
            title = "Primer Parcial",
            image = Icons.Filled.Android,
            route = "firstpartial"
        ),
        BarItem(
            title = "Segundo Parcial",
            image = Icons.Filled.Home,
            route = "secondpartial"
        ),
        BarItem(
            title = "Tercer Parcial",
            image = Icons.Filled.Coronavirus,
            route = "thirdpartial"
        )
    )
}