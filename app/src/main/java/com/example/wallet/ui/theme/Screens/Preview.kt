package com.example.wallet.ui.theme.Screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.wallet.ui.theme.Navigation.ROUTE_HOME
import com.example.wallet.ui.theme.Navigation.ROUTE_UPDATE
import com.example.wallet.ui.theme.data.TransactionViewModel
import com.example.wallet.ui.theme.models.Transaction


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Preview(
    navController: NavHostController
){
    val context = LocalContext.current
    val transactionRepository = TransactionViewModel(
        navController,
        context
    )
    val emptyTransactionState = remember {
        mutableStateOf(
            Transaction(
                "",
                "",
                "",
                ""
            )
        )
    }
    val emptyTransactionsListState = remember {
        mutableStateListOf<Transaction>()
    }
    val transactions = transactionRepository.Preview(
        emptyTransactionState,
        emptyTransactionsListState
    )
    Scaffold(
        topBar = {
            LargeTopAppBar(
                title = {
                    Text(text = "Transaction List")
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.navigate(ROUTE_HOME)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
//                    TextButton(
//                        onClick = {
//                            navController.navigate(ROUTE_ADMIN)
//                        }
//                    ) {
//                        Icon(
//                            imageVector = Icons.Filled.Add,
//                            contentDescription = "Add Book"
//                        )
//                        Text(text = "Add Book")
//                    }
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
//            Image(
//
//                painter = painterResource(id = R.drawable.pic4),
//                contentDescription = "",
//                contentScale = ContentScale.Crop,
//                modifier = Modifier
//                    .blur(300.dp)
//            )
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Card(
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                ) {

                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        items(transactions) {
                            TransactionCard(
                                navController,
                                transactionRepository,
                                day = it.day,
                                date = it.date,
                                amount = it.amount,
                                id = it.id,
                            )
                        }
                    }
                }
            }
        }


    }
}

@Composable
fun TransactionCard(
    navController: NavHostController,
    transactionRepository: TransactionViewModel,
    id: String,
    date: String,
    amount: String,
    day: String
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = """
                day: $day
                date: $date
                amount: $amount
                
                
            """.trimIndent(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ){
                TextButton(
                    onClick = {
                        transactionRepository.deleteTransaction(id)
                    }
                ) {
                    Text(
                        text = "Delete"
                    )
                }
                TextButton(
                    onClick = {
                        navController.navigate("$ROUTE_UPDATE/$id")
                    }
                ) {
                    Text(
                        text = "Update transaction"
                    )
                }
            }
        }
    }
}