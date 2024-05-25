package com.dangchph33497.fpoly.dangchph33497_assigment1_kot104.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.dangchph33497.fpoly.dangchph33497_assigment1_kot104.R
import com.dangchph33497.fpoly.dangchph33497_assigment1_kot104.model.Product
import com.dangchph33497.fpoly.dangchph33497_assigment1_kot104.ui.theme.Dangchph33497_Assigment1_KOT104Theme

class Bookmark : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dangchph33497_Assigment1_KOT104Theme {
                BookmarkLayout()
            }
        }
    }
}

@Composable
fun BookmarkButtonWithColor(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color("#242424".toColorInt())
        ),
        shape = RoundedCornerShape(7.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 10.dp)
            .height(50.dp)
    ) {
        Text(
            text = text,
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 21.sp,
            fontWeight = FontWeight(450)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BookmarkLayout() {
    val bookmarkItems = listOf(
        Product(1, "Coffee Table", 50.0f, R.drawable.image3, 1),
        Product(2, "Coffee Chair", 20.0f, R.drawable.image1, 2),
        Product(3, "Minimal Stand", 25.0f, R.drawable.image4, 3),
        Product(4, "Minimal Desk", 50.0f, R.drawable.image5, 4),
        Product(5, "Minimal Lamp", 12.0f, R.drawable.image2, 5)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(bookmarkItems) { item ->
                BookmarkItem(product = item)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        BookmarkButtonWithColor(
            text = "Add all to my cart",
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun BookmarkItem(
    product: Product,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            .border(BorderStroke(1.dp, Color.Gray), shape = RoundedCornerShape(8.dp))
            .padding(8.dp) // Adjust padding as needed
    ) {
        // Delete icon on top left
        IconButton(
            onClick = { /* Handle delete action */ },
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.TopEnd)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_remove_24),
                contentDescription = "Remove Product"
            )
        }

        // Main content
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, bottom = 24.dp), // Add space for icons
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = product.anh),
                contentDescription = "Product Image",
                modifier = Modifier.size(80.dp)
            )

            Spacer(modifier = Modifier.width(10.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = product.tenSP,
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "$${String.format("%.2f", product.donGia)}",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }

        // Shopping cart icon on bottom left
        IconButton(
            onClick = { /* Handle add to cart action */ },
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.BottomEnd)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_shopping_bag_24),
                contentDescription = "Add to Cart"
            )
        }
    }
}
