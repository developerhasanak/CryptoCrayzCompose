package com.ak.cryptocrayzcompose.view

sealed class Screen(val route: String){
    object ListScreen : Screen("crypto_list_screen")
    object DetailScrren : Screen("crypto_detail_screen")
}
