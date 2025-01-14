package hr.rma.fb_projekt.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import java.lang.reflect.Modifier

@Preview(showBackground = true)
@Composable
fun MainScreen() {
    Column(
        verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()    ){

    }
}

@Composable
fun ArticleButton() {
    Button(onClick = { /*TODO*/ }) {
        Icon(...)
        Text(...)
    }
}