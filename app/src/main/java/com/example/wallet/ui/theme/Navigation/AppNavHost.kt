package com.example.wallet.ui.theme.Navigation


import androidx.compose.animation.core.updateTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wallet.ui.theme.Screens.Earnings
import com.example.wallet.ui.theme.Screens.HomeScreen
import com.example.wallet.ui.theme.pages.Login
import com.example.wallet.ui.theme.pages.Register


@Composable
fun AppNavHost(

    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_LOGIN
){
    NavHost(

        navController = navController,
        startDestination = startDestination){


        composable(ROUTE_HOME){HomeScreen(navController)}
        composable(ROUTE_LOGIN){Login(navController)}
        composable(ROUTE_REGISTER){ Register(navController) }
        composable(ROUTE_EARNINGS){Earnings(navController)}
        composable(ROUTE_UPDATE + "/{id}"){ passedData -> updateTransition(navController,passedData.arguments?.getString("id")!!) }
    }
}