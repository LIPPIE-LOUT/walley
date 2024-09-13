package com.example.wallet

import android.os.Bundle
import com.example.wallet.ui.theme.Navigation.AppNavHost
import com.example.wallet.ui.theme.Navigation.ROUTE_HOME
import com.example.wallet.ui.theme.Navigation.ROUTE_LOGIN
import com.example.wallet.ui.theme.WalletTheme
import com.example.wallet.ui.theme.data.AuthViewModel
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WalletTheme{
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                ) {
                    val context = LocalContext.current
                    val account = AuthViewModel(
                        navController = NavHostController(context),
                        context = context
                    )
                    AppNavHost(
                        startDestination = if (account.isSignedIn()){
                            ROUTE_HOME
                        } else {
                            ROUTE_LOGIN
                        }
                    )
                }
            }
        }
    }
}
