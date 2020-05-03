package com.example.composeexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Clip
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.surface.Surface
import androidx.ui.res.imageResource
import androidx.ui.text.TextStyle
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Component("Android")
        }
    }
}

@Composable
fun NewsStory() {
    Column(
        crossAxisSize = LayoutSize.Expand,
        modifier=Spacing(16.dp)
    ) {
        Text("Hello")
        Text("Davenport, California")
        Text("December 2018")
    }
}


//@Preview
//@Composable
//fun Preview() {
//    NewsStory()
//}


































@Composable
fun Component(
    name: String,
    theme: MaterialColors = lightThemes,
    typography: MaterialTypography = MaterialTypography()
) {
    val image = +imageResource(R.drawable.header)

    MaterialTheme(colors = theme, typography = typography) {
        Surface {
            Column(
                crossAxisSize = LayoutSize.Expand,
                modifier = Spacing(16.dp)
            ) {
                Container(expanded = true, height = 180.dp) {
                    Clip(shape = RoundedCornerShape(8.dp)) {
                        DrawImage(image = image)
                    }
                }
                HeightSpacer(16.dp)
                Text(text = "Hello $name!",
                    style = +themeTextStyle { h6 })
                Text(
                    "Tire umas férias nesse lugar!" +
                            "Aqui você realmente irá fazer a viagem dos seus sonhos",
                    maxLines = 2, overflow = TextOverflow.Ellipsis,
                    style = (+themeTextStyle { h6 }).withOpacity(0.87f)
                )
                Text(
                    "Davenport, California",
                    style = (+themeTextStyle { body2 }).withOpacity(0.87f)
                )
                Text(
                    "December 2018",
                    style = (+themeTextStyle { body2 }).withOpacity(0.6f)
                )

            }
        }
    }
}

@Preview("default theme")
@Composable
fun DefaultPreview() {
    Component("HELLO WORLD")
}

@Preview("dark theme")
@Composable
fun DarkPreview() {
    Component("android", darkThemes, darkTypography)
}


val lightThemes = MaterialColors(
    background = Color.White,
    surface = Color.White
)

val darkThemes = MaterialColors(
    background = Color.Black,
    surface = Color.Black,
    primary = Color.White,
    secondary = Color.White,
    onPrimary = Color.White,
    primaryVariant = Color.White,
    secondaryVariant = Color.White
)

val darkTypography = run {
    val colors = TextStyle(color = Color.White)
    MaterialTypography(h6 = colors, body2 = colors)
}
