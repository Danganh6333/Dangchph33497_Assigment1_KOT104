package com.dangchph33497.fpoly.dangchph33497_assigment1_kot104.access

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dangchph33497.fpoly.dangchph33497_assigment1_kot104.R
import com.dangchph33497.fpoly.dangchph33497_assigment1_kot104.navigation.AppNavHost
import com.dangchph33497.fpoly.dangchph33497_assigment1_kot104.navigation.Screens
import com.dangchph33497.fpoly.dangchph33497_assigment1_kot104.ui.theme.Dangchph33497_Assigment1_KOT104Theme

class SignUp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dangchph33497_Assigment1_KOT104Theme {
                AppNavHost(navController = rememberNavController())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopSignUpLayout() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                painter = painterResource(id = R.drawable.group),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(68.dp)
                    .padding(vertical = 6.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun SignUpButtonWithColor(navController: NavHostController,) {
    Button(
        onClick = { navController.navigate("${Screens.Bottom.route}")
        }, colors = ButtonDefaults.buttonColors(
            containerColor = Color("#242424".toColorInt())
        ), shape = RoundedCornerShape(7.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 19.dp, vertical = 10.dp)
            .height(50.dp)
    ) {
        Text(
            text = "SIGN UP",
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 21.sp,
            fontWeight = FontWeight(600)
        )
    }
}

@Composable
fun SignUpBlock(navController: NavHostController,) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 33.dp)
            .border(0.dp, Color.Gray, RoundedCornerShape(10.dp)),
        shape = CardDefaults.elevatedShape,
        colors = CardDefaults.elevatedCardColors(Color.White),
        elevation = CardDefaults.cardElevation(12.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 19.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start

        ) {
            CustomSignUpTextFieldDemo(label = "Name")
            CustomSignUpTextFieldDemo(label = "Email")
            CustomSignUpTextFieldDemo(label = "Password", true)
            CustomSignUpTextFieldDemo(label = "Confim Password", true)

            SignUpButtonWithColor(navController)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp), contentAlignment = Alignment.Center
            ) {
                Text(
                    text = buildAnnotatedString {
                        append("Already have an account? ")
                        pushStyle(SpanStyle(color = Color.Black))
                        append("Sign In")
                    },
                    fontWeight = FontWeight(700),
                    fontStyle = FontStyle.Normal,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(vertical = 10.dp).clickable {
                        navController.navigate("${Screens.SignIn.route}")
                    },
                    textAlign = TextAlign.Center,
                    color = Color.Gray,
                )
            }
        }
    }
}

@Composable
fun CustomSignUpTextField(
    label: String,
    modifier: Modifier = Modifier
) {
    var textState by remember { mutableStateOf(TextFieldValue("")) }
    Column(modifier = modifier.padding(8.dp)) {
        Text(
            text = label,
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .drawBehind {
                    val strokeWidth = 2.dp.toPx()
                    val y = size.height - strokeWidth / 2
                    drawLine(
                        color = Color.Gray,
                        start = Offset(1f, y),
                        end = Offset(size.width, y),
                        strokeWidth = strokeWidth,

                        )
                }
        ) {
            BasicTextField(
                value = textState,
                onValueChange = { textState = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp
                ),
                cursorBrush = SolidColor(Color.Black)
            )
        }
    }
}

@Composable
fun CustomSignUpTextFieldDemo(label: String, isPassword: Boolean = false) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isPassword) {
            CustomSignUpTextField2(
                label = label,
                modifier = Modifier.fillMaxWidth()
            )
        } else {
            CustomSignUpTextField(
                label = label,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun CustomSignUpTextField2(
    label: String,
    modifier: Modifier = Modifier
) {
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    Column(modifier = modifier.padding(8.dp)) {
        Text(
            text = label,
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .drawBehind {
                    val strokeWidth = 2.dp.toPx()
                    val y = size.height - strokeWidth / 2
                    drawLine(
                        color = Color.Gray,
                        start = Offset(1f, y),
                        end = Offset(size.width, y),
                        strokeWidth = strokeWidth,
                    )
                }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                BasicTextField(
                    value = password,
                    onValueChange = { password = it },
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp
                    ),
                    cursorBrush = SolidColor(Color.Black),
                    modifier = Modifier.weight(1f),
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
                )
                IconButton(
                    onClick = { passwordVisible = !passwordVisible },
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    val image = if (passwordVisible)
                        R.drawable.ic_visibility
                    else R.drawable.ic_visibility_off

                    Icon(painter = painterResource(id = image), contentDescription = "Eye")
                }
            }
        }
    }
}
@Composable
fun SignUpScreen(navController: NavHostController) {
    Box(Modifier.fillMaxSize()) {
        Column(
            Modifier
                .background(color = Color("#FFFFFF".toColorInt()))
                .fillMaxSize()
                .padding(
                    top = 24.dp,
                    start = 24.dp,
                    bottom = 24.dp,
                    end = 24.dp
                )
        ) {
            TopLayout()
            Text(
                text = "WELCOME",
                color = Color("#303030".toColorInt()),
                fontWeight = FontWeight(700),
                fontFamily = merriweatherFamily,
                fontSize = 27.sp,
                modifier = Modifier.padding(vertical = 17.dp)
            )
            SignUpBlock(navController)
        }
    }
}
