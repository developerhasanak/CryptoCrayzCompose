package com.ak.cryptocrayzcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ak.cryptocrayzcompose.ui.theme.CryptoCrayzComposeTheme
import com.ak.cryptocrayzcompose.view.CryptoDetailScreen
import com.ak.cryptocrayzcompose.view.CryptoListScreen
import com.ak.cryptocrayzcompose.view.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoCrayzComposeTheme {
                Navigation()

            }
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    CryptoCrayzComposeTheme {
        CryptoListScreen(navController = null, null)
    }
}