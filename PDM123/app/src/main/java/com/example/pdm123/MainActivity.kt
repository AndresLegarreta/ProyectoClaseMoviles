package com.example.pdm123

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.pdm123.ui.theme.PDM123Theme
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PDM123Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        topBar = { TopAppBar(title = { Text("ULSA CHIHUAHUA")})},
        content = {it
            NavigationHost(navController = navController)},
        bottomBar = { BottomNavigationBar(navController = navController)}
    )
}

/**
 * Esta funcion va a ser encargada de manejar los tabs de la app
 */
@Composable
fun NavigationHost(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = NavRoutes.firstpartial.route
    ){
        composable(NavRoutes.firstpartial.route){
            FirstPartial()
        }
        composable(NavRoutes.secondpartial.route){
            SecondPartial()
        }
        composable(NavRoutes.thirdpartial.route){
            ThirdPartial()
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController){
    BottomNavigation{
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        NavBarItems.NavBarItems.forEach{navItem ->

            BottomNavigationItem(

                selected = currentRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route){
                        popUpTo(navController.graph.findStartDestination().id){
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(imageVector = navItem.image,
                        contentDescription = navItem.title)
                },
                label = {
                    Text(text = navItem.title)
                }
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PDM123Theme {
        MainScreen()
    }
}