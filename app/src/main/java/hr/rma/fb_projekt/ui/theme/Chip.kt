package hr.rma.fb_projekt.ui.theme

import android.graphics.Color
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import java.lang.reflect.Modifier

@Composable
fun Chip(
    text: String,
    backgroundColor: Color = Color.White,
    textColor: Color = Purple500, ){
    Box(
        modifier = Modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(12.dp)
            )
            .clip(RoundedCornerShape(12.dp)) .padding(horizontal = 8.dp, vertical = 2.dp)
    ){
        Text(
            text = text,
            color = textColor, fontSize = 12.sp
        )
    }
}
