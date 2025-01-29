package hr.rma.fb_projekt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import hr.rma.fb_projekt.ui.theme.*

@Composable
fun MyApp() {
    // Shared state for the cart
    val cartItems = remember { mutableStateListOf<Article>() }
    AppNavigation(cartItems = cartItems)
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun AppNavigation(cartItems: MutableList<Article>) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "main"
    ) {
        composable("main") { MainScreen(navController,cartItems)}
        composable("men") { MenSection(navController,cartItems) }
        composable("menUpperwear") { MenUpperwear(navController,cartItems) }
        composable("menUnderwear") { MenUnderwear(navController,cartItems) }
        composable("menAccessories") { MenAccessories(navController,cartItems) }

        composable("women") { WomenSection(navController,cartItems) }
        composable("womenUpperwear") { WomenUpperwear(navController,cartItems) }
        composable("womenUnderwear") { WomenUnderwear(navController,cartItems) }
        composable("womenAccessories") { WomenAccessories(navController,cartItems) }


        composable("favorites") { FavoritesSection() }
        composable("cart") { CartScreen(navController,cartItems = cartItems) }

    }
}


