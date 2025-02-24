package hr.rma.fb_projekt.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import hr.rma.fb_projekt.R


@Composable
fun WomenSection(navController: NavHostController,cartItems: MutableList<Article>) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "Background image",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.matchParentSize(),
            alpha = 0.5F
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
                    .height(50.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back Icon",
                    tint = Color(254, 248, 234),
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .size(24.dp)
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
                    color = WarmWhite,
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
            Text(
                text = "WOMEN",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                color = Black33,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 100.dp, bottom = 100.dp)
            )


            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = { navController.navigate("womenUpperwear") },
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF90CAF9)),
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(70.dp)
                ) {
                    Text(text = "UPPERWEAR", fontSize = 30.sp, color = WarmWhite)
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {  navController.navigate("womenUnderwear")},
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF90CAF9)),
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(70.dp)
                ) {
                    Text(text = "UNDERWEAR", fontSize = 30.sp, color = WarmWhite)
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { navController.navigate("womenAccessories")},
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF90CAF9)),
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(70.dp)
                ) {
                    Text(text = "ACCESSORIES", fontSize = 30.sp, color = WarmWhite)
                }
            }

            Text(
                text = "Closetify™ All rights reserved.",
                fontSize = 12.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top=270.dp)
            )
        }
    }
}

