package com.mjapa21.productdetailsscreen

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mjapa21.productdetailsscreen.ui.theme.ProductDetailsScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProductDetailsScreenTheme {
                ProductScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductScreen() {
    val selectedSize: MutableState<String?> = remember { mutableStateOf(null) }
    val context = LocalContext.current


    Scaffold(topBar = {
        TopAppBar(
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        painterResource(R.drawable.baseline_arrow_back_24),
                        contentDescription = "Back"
                    )
                }
            }, title = {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Text("Product Details", fontWeight = FontWeight.Bold)
                }
            }, actions = {
                IconButton(onClick = {}) {
                    Icon(
                        painterResource(R.drawable.baseline_notifications_none_24),
                        contentDescription = "Notifications"
                    )
                }
            })
    }, bottomBar = {
        BottomAppBar {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Column {
                    Text("Price", fontWeight = FontWeight.Normal, fontSize = 18.sp)
                    Text("$ 1,190", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                }
                Button(
                    modifier = Modifier
                        .fillMaxWidth(),
                    onClick = {
                        if (selectedSize.value == null) Toast.makeText(
                            context,
                            "Please select a size",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_add_shopping_cart_24),
                            contentDescription = "Add to Cart",
                        )
                        Text("Add to Cart")
                    }

                }
            }
        }
    }) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            Box {
                Image(
                    painterResource(R.drawable.product_image),
                    contentDescription = "Product Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    contentScale = ContentScale.FillWidth
                )
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(16.dp),
                    shape = IconButtonDefaults.standardShape
                ) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(color = Color.White), contentAlignment = Alignment.Center
                    ) {


                        Icon(
                            painterResource(R.drawable.baseline_favorite_border_24),
                            contentDescription = "Favorite",
                        )
                    }
                }
            }

            Text(
                "Just a nice T-shirt",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Icon(
                    painterResource(R.drawable.baseline_star_24),
                    contentDescription = "Rating",
                    tint = Color(0xFFD3A209)
                )
                Text(
                    "4.0/5",
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
                Text(
                    "(45 reviews)",
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }


            Text(
                "This is a cool T-shirt. This is a cool T-shirt. "
                        + "This is a cool T-shirt. This is a cool T-shirt. This is a cool T-shirt. "
                        + "This is a cool T-shirt. This is a cool T-shirt. This is a cool T-shirt. "
                        + "This is a cool T-shirt. This is a cool T-shirt. This is a cool T-shirt. ",
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )

            Text(
                "Choose Size",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                val listOfSizes = listOf("S", "M", "L")
                for (size in listOfSizes) {

                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (selectedSize.value == size) Color.Black else Color.Transparent,
                            contentColor = if (selectedSize.value == size) Color.White else Color.Black
                        ), onClick = {
                            if (selectedSize.value != size) selectedSize.value = size
                            else selectedSize.value = null
                        }, border = BorderStroke(
                            width = 1.dp,
                            color = Color.Black
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(size)
                    }

                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ProductScreenPreview() {
    ProductDetailsScreenTheme {
        ProductScreen()
    }
}