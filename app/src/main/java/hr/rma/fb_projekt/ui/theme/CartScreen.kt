package hr.rma.fb_projekt.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceModifier
import hr.rma.fb_projekt.R
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.navigation.NavHostController


@Composable
fun CartScreen(navController: NavHostController, cartItems: MutableList<Article>) {
    val totalPrice = cartItems.sumOf { it.price.toDoubleOrNull() ?: 0.0 }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "Background image",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.matchParentSize(),
            alpha = 0.3F
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
                    .height(50.dp), // Use height instead of size for better control
                horizontalArrangement = Arrangement.SpaceBetween, // Center the text
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back Icon",
                    tint = Color(254, 248, 234),
                    modifier = Modifier
                        .padding(start = 40.dp,end=40.dp)
                        .size(32.dp)
                        .clickable {
                            navController.navigate("main") {
                                popUpTo("main") { inclusive = true }
                            }
                        }
                )
                Text(
                    text = "CLOSETIFY",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth() // Make sure it fills the width to center
                        .padding(horizontal = 30.dp) // Optional, if you want some space on the sides
                )
            }

            Column(
                modifier = Modifier
                    .height(500.dp)
                    .width(300.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.White)
                    .border(2.dp, Color.White, RoundedCornerShape(10.dp))
            ) {
                if (cartItems.isEmpty()) {
                    Text(
                        text = "Your cart is empty.",
                        color = Color.Black,
                        modifier = Modifier.padding(16.dp),
                        textAlign = TextAlign.Center
                    )
                } else {
                    LazyColumn(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        items(cartItems) { item ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = item.title,
                                    color = Color.Black,
                                    fontSize = 16.sp
                                )
                                Text(
                                    text = "€${item.price}",
                                    color = Color.Gray,
                                    fontSize = 14.sp
                                )
                            }
                        }
                        item{Divider(
                            modifier=Modifier.fillMaxWidth(),
                            thickness= 3.dp,
                            color = Black33
                        )
                        Text(
                            text = "TOTAL: €${"%.2f".format(totalPrice)}",
                            fontWeight = FontWeight.Bold,
                            fontSize = 30.sp,
                            color = Color.Black,
                            modifier = Modifier.padding(start=80.dp,top=30.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                    }
                    }
                }
            }

            Button(
                onClick = { cartItems.clear()}, // Clear cart
                modifier = Modifier.padding(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Black33)
            ) {
                Text(text = "Clear Cart")
            }

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
