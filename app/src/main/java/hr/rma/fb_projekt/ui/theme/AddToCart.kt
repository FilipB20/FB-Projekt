package hr.rma.fb_projekt.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import java.lang.reflect.Modifier

@Composable
fun addToCart(
    text: String,
    isActive: Boolean,
    onClick: () -> Unit ){
    Button(
        shape = RoundedCornerShape(24.dp),
        elevation = null,
        colors = if (isActive) ButtonDefaults.buttonColors(contentColor =
        White, containerColor = Pink) else ButtonDefaults.buttonColors(contentColor = DarkGray, containerColor = LightGray),
        modifier = Modifier.fillMaxHeight(),
        onClick = { onClick() } ){
        Text(text) }
}