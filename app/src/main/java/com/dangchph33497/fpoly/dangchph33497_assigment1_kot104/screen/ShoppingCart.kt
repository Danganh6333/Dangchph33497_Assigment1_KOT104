package com.dangchph33497.fpoly.dangchph33497_assigment1_kot104.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dangchph33497.fpoly.dangchph33497_assigment1_kot104.screen.ui.theme.Dangchph33497_Assigment1_KOT104Theme

class ShoppingCart : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dangchph33497_Assigment1_KOT104Theme {

            }
        }
    }
}

//@Composable
//fun CartItem(
//    product: CartProduct,
//    onQuantityChange: () -> Unit,
//    onRemoveProduct: () -> Unit
//) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .border(BorderStroke(1.dp, Color.Gray), shape = RoundedCornerShape(8.dp))
//            .padding(6.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Image(
//            painter = painterResource(id = product.imageResId),
//            contentDescription = "Product Image",
//            modifier = Modifier.size(80.dp)
//        )
//
//        Spacer(modifier = Modifier.width(10.dp))
//
//        Column(
//            modifier = Modifier.weight(1f)
//        ) {
//            Text(
//                text = product.name,
//                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
//            )
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            Text(
//                text = "$${String.format("%.2f", product.price)}",
//                style = MaterialTheme.typography.bodyLarge.copy(
//                    color = Color.Red,
//                    fontWeight = FontWeight.Bold
//                )
//            )
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            Row(verticalAlignment = Alignment.CenterVertically) {
//                IconButton(
//                    onClick = {
//                        if (product.quantity > 1) {
//                            product.quantity--; onQuantityChange()
//                        }
//                    },
//                    modifier = Modifier.size(24.dp) // Adjust the size as needed
//                ) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.minus),
//                        contentDescription = "Decrease Quantity"
//                    )
//                }
//
//                Text(
//                    text = "${product.quantity}",
//                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
//                    modifier = Modifier.padding(horizontal = 8.dp)
//                )
//
//                IconButton(
//                    onClick = { product.quantity++; onQuantityChange() },
//                    modifier = Modifier.size(24.dp) // Adjust the size as needed
//                ) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.more),
//                        contentDescription = "Increase Quantity"
//                    )
//                }
//            }
//        }
//
//        IconButton(
//            onClick = { onRemoveProduct() },
//            modifier = Modifier.size(24.dp) // Adjust the size as needed
//        ) {
//            Icon(
//                painter = painterResource(id = R.drawable.remove),
//                contentDescription = "Remove Product"
//            )
//        }
//    }
//}



