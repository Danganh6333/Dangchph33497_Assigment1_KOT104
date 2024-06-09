package com.dangchph33497.fpoly.dangchph33497_assigment1_kot104.navigation


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.dangchph33497.fpoly.dangchph33497_assigment1_kot104.NavigationLayout
import com.dangchph33497.fpoly.dangchph33497_assigment1_kot104.ProductDetailScreen
import com.dangchph33497.fpoly.dangchph33497_assigment1_kot104.SplashScreen
import com.dangchph33497.fpoly.dangchph33497_assigment1_kot104.access.SignInScreen
import com.dangchph33497.fpoly.dangchph33497_assigment1_kot104.access.SignUpScreen
import com.dangchph33497.fpoly.dangchph33497_assigment1_kot104.screen.BookmarkLayout
import com.dangchph33497.fpoly.dangchph33497_assigment1_kot104.screen.CartLayout
import com.dangchph33497.fpoly.dangchph33497_assigment1_kot104.screen.CongratulationLayout
import com.dangchph33497.fpoly.dangchph33497_assigment1_kot104.screen.GreetingPreview4
import com.dangchph33497.fpoly.dangchph33497_assigment1_kot104.screen.GreetingPreview5
import com.dangchph33497.fpoly.dangchph33497_assigment1_kot104.screen.HomeScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = Screens.Splash.route,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screens.Splash.route) {
            SplashScreen(navController)
        }
        composable(Screens.SignIn.route) {
            SignInScreen(navController)
        }
        composable(Screens.SignUp.route) {
            SignUpScreen(navController)
        }
        composable(Screens.Bottom.route) {
            NavigationLayout(navController)
        }
        composable(Screens.Congratulation.route) {
            CongratulationLayout(navController)
        }
        composable(Screens.Home.route) {
            HomeScreen(navController)
        }
        composable(Screens.Bookmark.route) {
            BookmarkLayout()
        }
        composable(Screens.Notification.route) {
            GreetingPreview4(navController)
        }
        composable(Screens.Profile.route) {
            GreetingPreview5(navController)
        }
        composable(Screens.Congratulation.route) {
            CongratulationLayout(navController)
        }
        composable(Screens.Detail.route) {
            ProductDetailScreen(navController)
        }
        composable(Screens.Bookmark.route) {
            BookmarkLayout()
        }
        composable(Screens.Cart.route) {
            CartLayout(navController)
        }
    }
}