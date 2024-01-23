package com.ak.cryptocrayzcompose.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.ListScreen.route  ){
        composable(route = Screen.ListScreen.route){
            CryptoListScreen(navController = navController)
        }

        composable(route = Screen.DetailScrren.route+ "?cyrptoId={cryptoId}"+"?cryptoCurrency={cryptoCurrency}" +"?cryptoPrice={cryptoPrice}" ,
            arguments = listOf(
                navArgument("cryptoId") {

                },
                navArgument("cryptoPrice"){

                }

                )

            ) {entry->
               CryptoDetailScreen(id = entry.arguments?.getString("cryptoId")!!,
                     price = entry.arguments?.getString("cryptoPrice")!!
                   )

        }
    }
}