package hr.rma.fb_projekt.ui.theme


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
import hr.rma.fb_projekt.R


@Preview
@Composable
fun WomenAccessories() {
    // Sample articles
    val articles = listOf(
        Article(R.drawable.casiosat, "Casio Watch \n€49.99", "An all time classic"),
        Article(R.drawable.nikegloves, "Nike Gloves \n€39.99", "Gloves for cold days"),
        Article(R.drawable.silverbracelet, "Silver Bracelet \n€59.99", "A stylish bracelet"),
        Article(R.drawable.rayban, "RayBan Glasses \n€99.99", ""),
        Article(R.drawable.ckwallet, "CK Wallet \n€45.99", "A must have for any man"),
        Article(R.drawable.necklace, "Silver Necklace \n€79.99", "Silver necklace to elevate your style")
    )

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
                    tint = Color.White,
                    modifier = Modifier
                        .padding(start = 10.dp) // Adds some padding to the left
                        .size(24.dp) // Makes the icon size uniform
                        .clickable {
                            // Vodi nazad
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
                        .padding(end = 16.dp) // Adds some padding to the right
                        .size(24.dp) // Makes the icon size uniform
                )
            }

            // Heading
            Text(
                text = "ACCESSORIES",
                color = Color.White,
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
                    ArticleCard(article = article)
                }
            }

            // Footer Section
            Text(
                text = "Closetify™ All rights reserved.",
                fontSize = 12.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}


