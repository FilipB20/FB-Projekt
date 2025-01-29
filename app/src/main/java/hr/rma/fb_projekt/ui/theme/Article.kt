package hr.rma.fb_projekt.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter

data class Article(
    val imageUrl: String = "",
    val title: String = "",
    val price: String = ""
)

@Composable
fun ArticleCard(article: Article, cartItems: MutableList<Article>, navController: NavHostController) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberAsyncImagePainter(article.imageUrl),
                contentDescription = article.title,
                modifier = Modifier
                    .height(90.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = article.title,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "€${article.price}",
                fontSize = 14.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(2.dp))
            Button(
                onClick = {
                    cartItems.add(article)
                },
                modifier = Modifier.padding(top = 8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Black33),
            ) {
                Text(text = "Add to Cart", fontSize = 12.sp)
            }
        }

    }
}