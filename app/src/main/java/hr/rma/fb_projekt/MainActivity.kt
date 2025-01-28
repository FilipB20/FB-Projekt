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
        // Pass the shared cart state to each composable
        composable("main") { MainScreen(navController) }
        composable("cart") { CartScreen(cartItems = cartItems) }
        composable("men") { MenSection() }
        composable("women") { WomenSection() }
        composable("favorites") { FavoritesSection() }
    }
}

