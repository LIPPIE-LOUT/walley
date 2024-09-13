package com.example.wallet.ui.theme.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wallet.ui.theme.Navigation.ROUTE_PREVIEW
import com.example.wallet.ui.theme.data.TransactionViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Earnings(
    navController: NavHostController
){
    val context = LocalContext.current
    var amount by remember {
        mutableStateOf("")
    }
    var date by remember {
        mutableStateOf("")
    }
    var day by remember {
        mutableStateOf("")
    }
    val transactionRepository = TransactionViewModel(
        navController,
        context
    )

    Scaffold(
        topBar = {
            LargeTopAppBar(
                title = {
                    Text("New Transaction")
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.navigateUp()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    TextButton(
                        onClick = {
                            transactionRepository.savetransactions(
                                date.trim(),
                                day.trim(),
                                amount.trim()
                            )
                            navController.navigate(ROUTE_PREVIEW)
                        },
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Check,
                            contentDescription = "Save"
                        )
                        Text("Save")
                    }
                }
            )
        }
    ) {
            innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Card (
                    modifier = Modifier
                        .fillMaxWidth(0.8f),
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ){
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                        ) {
                            OutlinedTextField(
                                value = amount,
                                onValueChange = {amount = it},
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp),
                                label = {Text("amount")},
                                placeholder = {Text("Enter amount")}
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                        ) {
                            OutlinedTextField(
                                value = date,
                                onValueChange = {  date = it },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp),
                                label = {Text("Date")},
                                placeholder = {Text("Enter date")}
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                        ) {
                            OutlinedTextField(
                                value = day,
                                onValueChange = { day = it },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp),
                                label = {Text("day")},
                                placeholder = {Text("Enter day")}
                            )
                        }
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Earnings(){
    Earnings(rememberNavController())
}


