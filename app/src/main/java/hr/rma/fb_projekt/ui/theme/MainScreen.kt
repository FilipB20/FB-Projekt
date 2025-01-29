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
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import androidx.navigation.NavHostController
    import androidx.navigation.compose.rememberNavController
    import hr.rma.fb_projekt.R


    @Composable
    fun MainScreen(navController: NavHostController,cartItems: MutableList<Article>) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            // Background Image
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "Background image",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier.matchParentSize(),
                alpha = 0.5F
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

                    Text(
                        text = "CLOSETIFY",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        color = Color.White,
                        modifier = Modifier.padding(start=140.dp)
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

                // Main Content
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Buttons for navigation
                    Button(
                        onClick = { navController.navigate("men") },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF90CAF9)),
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(70.dp)
                    ) {
                        Text(text = "MEN", fontSize = 30.sp, color = Color(254, 248, 234))
                    }


                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = { navController.navigate("women") },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF90CAF9)),
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(70.dp)
                    ) {
                        Text(text = "WOMEN", fontSize = 30.sp, color = Color(254, 248, 234))
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = { navController.navigate("favorites") },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF90CAF9)),
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(70.dp)
                    ) {
                        Text(text = "FAVOURITES", fontSize = 30.sp, color = Color(254, 248, 234))
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

