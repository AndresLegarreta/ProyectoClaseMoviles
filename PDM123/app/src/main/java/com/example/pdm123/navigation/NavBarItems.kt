package com.example.pdm123.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import com.example.pdm123.R
import com.example.pdm123.navigation.BarItem

object NavBarItems {
    val  NavBarItems = listOf(
        BarItem(
            title = R.string.first_partial,
            image = Icons.Filled.Android,
            route = "firstpartial"
        ),
        BarItem(
            title = R.string.second_partial,
            image = Icons.Filled.Airplay,
            route = "secondpartial"
        ),
        BarItem(
            title = R.string.third_partial,
            image = Icons.Filled.Coronavirus,
            route = "thirdpartial"
        )
    )
}