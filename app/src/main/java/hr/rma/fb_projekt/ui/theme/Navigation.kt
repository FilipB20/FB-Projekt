package hr.rma.fb_projekt.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import hr.rma.fb_projekt.R
import java.lang.reflect.Modifier

@Composable
fun NavigationBar() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
            .fillMaxWidth() .padding(16.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.slikaOstalihKategorija), contentDescription = "Strawberry Pie",
            modifier = Modifier
                .weight(1f) .clip(RoundedCornerShape(12.dp))
        )
        Spacer(modifier = Modifier.width(16.dp)) Image(
                painter = painterResource(id = R.drawable.strawberry_pie_3), contentDescription = "Strawberry Pie",
        modifier = Modifier
        )
    }
}