package hr.rma.fb_projekt.ui.theme


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.firestore.FirebaseFirestore
import hr.rma.fb_projekt.R


@Composable
fun MenUnderwear(navController: NavHostController,cartItems: MutableList<Article>) {
    val firestore = FirebaseFirestore.getInstance()
    var articles by remember { mutableStateOf(listOf<Article>()) }

    // Fetch data from Firestore
    LaunchedEffect(Unit) {
        firestore.collection("MenUnderwear")
            .get()
            .addOnSuccessListener { result ->
                val fetchedArticles = result.map { document ->
                    Article(
                        imageUrl = document.getString("imageUrl") ?: "",
                        title = document.getString("title") ?: "",
                        price = document.getString("price") ?: ""
                    )
                }
                articles = fetchedArticles
            }
            .addOnFailureListener {
                // Handle failure, e.g., log the error
            }
    }

    Box(
        modifier = Modifier.fillMaxSize()

    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "Background image",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.matchParentSize(),
            alpha = 0.3F
        )

        // Foreground Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top Section
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
                    .height(50.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween // Ensures space between items
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back Icon",
                    tint = Color(254, 248, 234),
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .size(24.dp)
                        .clickable {
                            // Navigate to the main screen explicitly
                            navController.navigate("men") {
                                // This will pop the current "men" screen from the back stack to avoid redundant navigation
                                popUpTo("men") { inclusive = true }
                            }
                        }
                )
                Text(
                    text = "CLOSETIFY",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.White,
                    modifier = Modifier
                )
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Cart Icon",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .size(24.dp)
                        .clickable { navController.navigate("cart") }
                )
            }

            // Heading
            Text(
                text = "UNDERWEAR",
                color = Black33,
                fontSize = 40.sp,
                modifier = Modifier.padding(top = 16.dp)
            )

            // Articles Grid
            LazyVerticalGrid(
                columns = GridCells.Fixed(2), // 2 columns
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                items(articles) { article ->
                    ArticleCard(article = article, cartItems = cartItems, navController = navController)
                }
                // Footer Section
                item{Text(
                    text = "Closetify™ All rights reserved.",
                    fontSize = 12.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(16.dp)
                )
            }}


        }
    }
}


