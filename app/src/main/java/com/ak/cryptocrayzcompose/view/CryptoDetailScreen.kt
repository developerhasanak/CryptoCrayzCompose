package com.ak.cryptocrayzcompose.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.neverEqualPolicy
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.ak.cryptocrayzcompose.di.aa
import com.ak.cryptocrayzcompose.model.Crypto
import com.ak.cryptocrayzcompose.util.Resource
import com.ak.cryptocrayzcompose.viewmodel.CryptoDetailViewModel
import kotlinx.coroutines.launch


@Composable
fun CryptoDetailScreen(
    id:String,
    price : String,
    viewModel: CryptoDetailViewModel? = hiltViewModel()
) {

    //Step1 -> Wrong -> Yanlış

    /*val scope = rememberCoroutineScope()

    //var cryptoItem : Resource<Crypto> = Resource.Loading()


    var cryptoItem by remember {
        mutableStateOf<Resource<Crypto>>(Resource.Loading())
    }
    scope.launch {
        cryptoItem = viewModel!!.getCrypto(id)
        println(cryptoItem.data)
    }

    */

    // Step -> Batter -> Stabil Çalışır
    /*var cryptoItem by remember {
        mutableStateOf<Resource<aa>>(Resource.Loading())
    }

    LaunchedEffect(key1 = Unit) {
        cryptoItem = viewModel!!.getCrypto(id)
        println(cryptoItem.data)
    }*/


   // Step3 -> Step2 ile aynı çalışıyor sadece yazımda daha kısa oluyor.
   val cryptoItem by produceState<Resource<aa>>(initialValue = Resource.Loading()){
   value = viewModel!!.getCrypto(id)
}







    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.tertiary),
        contentAlignment = Alignment.Center
        ){

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
           when(cryptoItem){

               is Resource.Success -> {
                  val selectedCrypto = cryptoItem.data!!



                  Text(text = selectedCrypto.name,
                      style = MaterialTheme.typography.headlineMedium,
                      modifier = Modifier.padding(2.dp),
                      fontWeight = FontWeight.Bold,
                      color = MaterialTheme.colorScheme.primary,
                      textAlign = TextAlign.Center
                      )
                   
                   Image(painter = rememberImagePainter(data  = selectedCrypto.image.small),
                       contentDescription = selectedCrypto.image.small ,
                       modifier = Modifier
                           .padding(16.dp)
                           .size(200.dp, 200.dp)
                           .clip(CircleShape)
                           .border(2.dp, Color.Gray, CircleShape)
                       )

                   Text(text = price,
                       style = MaterialTheme.typography.headlineSmall,
                       modifier = Modifier.padding(2.dp),
                       fontWeight = FontWeight.Bold,
                       color = Color.Black,
                       textAlign = TextAlign.Center
                   )
               }

               is Resource.Loading -> {
                 CircularProgressIndicator(color=Color.Blue)
               }

               is Resource.Error -> {
                   Text(text = cryptoItem.message!!)

               }


           }
        }
    }
}