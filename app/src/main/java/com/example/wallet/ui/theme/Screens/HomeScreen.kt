package com.example.wallet.ui.theme.Screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wallet.R
import com.example.wallet.ui.theme.Navigation.ROUTE_EARNINGS
import com.example.wallet.ui.theme.Navigation.ROUTE_HOME
import com.example.wallet.ui.theme.Navigation.ROUTE_PREVIEW
import com.example.wallet.ui.theme.Navigation.ROUTE_REGISTER


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Box (){
        Image(painter = painterResource(id = R.drawable.finance),
            contentDescription = " dashboardbackground"  ,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
        )
    }
    TopAppBar(
        title = { Text(text = "Wallet") },
        navigationIcon = {
            IconButton(onClick = {  }) {IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu")
            }


            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = Color.Black,
            navigationIconContentColor = Color.Black
        ),
        actions = {
            IconButton(onClick = { navController.navigate(ROUTE_HOME) }) {
                Icon(imageVector = Icons.Filled.Home,
                    contentDescription = "Home")
            }
            IconButton(onClick = { navController.navigate(ROUTE_REGISTER) }) {
                Icon(imageVector = Icons.Filled.Person,
                    contentDescription = "My Profile")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Search,
                    contentDescription = "Search")
            }


        }
    )
    Row (
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),

        verticalAlignment = Alignment.CenterVertically,

        ){

        Column (
            modifier = Modifier
                .wrapContentWidth()
                .fillMaxSize()
                .padding(top = 45.dp)
                .width(1000.dp)
        ){
            Card (
                modifier = Modifier
                    .padding(10.dp)
                    .clickable {
                        navController.navigate(ROUTE_EARNINGS)
                    },
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(10.dp)
            ){
                Box (
                    modifier = Modifier
                        .height(150.dp)
                        .width(250.dp)

                ){
                    Image(painter = painterResource(id = R.drawable.growth),
                        contentDescription = "Bank")
                    Box (
                        modifier = Modifier
                            .matchParentSize()
                            .padding(27.dp)
                        ,
                        contentAlignment = Alignment.Center
                    ){
                        Text(color = Color.Black,
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Bold,
                            fontSize = 40.sp,
                            text = "EARNINGS")
                    }
                }

            }

            Card (
                modifier = Modifier
                    .padding(10.dp)
                    .clickable {
                        navController.navigate(ROUTE_PREVIEW)
                    },
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(10.dp),

                ){
                Box (
                    modifier = Modifier
                        .height(150.dp)
                        .width(250.dp)
                ){
                    Image(painter = painterResource(id = R.drawable.finance),
                        contentDescription = "Bank")
                    Box (
                        modifier = Modifier
                            .matchParentSize()
                            .padding(27.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Text(color = Color.Black,
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Bold,
                            fontSize = 40.sp,
                            text = "PREVIEW")
                    }
                }


            }
            Card (
                modifier = Modifier
                    .padding(10.dp)
                    .clickable {
                        navController.navigate(ROUTE_PREVIEW)
                    },
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(10.dp)
            ){
                Box (
                    modifier = Modifier
                        .height(150.dp)
                        .width(250.dp)
                ){
                    Image(painter = painterResource(id = R.drawable.dollar),
                        contentDescription = "Bank")
                    Box (
                        modifier = Modifier
                            .matchParentSize()
                            .padding(27.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Text(color = Color.Black,
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Bold,
                            fontSize = 40.sp,
                            text = "EXPENDITURE")
                    }
                }

            }

        }

    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())
}

