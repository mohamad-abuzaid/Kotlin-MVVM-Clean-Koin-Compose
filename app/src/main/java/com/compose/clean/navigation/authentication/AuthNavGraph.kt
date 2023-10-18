package com.compose.clean.navigation.authentication

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.compose.clean.navigation.Graph
import com.compose.clean.ui.authentication.screens.language.LanguageSelectScreen
import com.compose.clean.ui.authentication.screens.login.LoginScreen
import com.compose.clean.ui.authentication.screens.onboard.OnboardScreen

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreens.LanguageSelect.route
    ) {
        composable(route = AuthScreens.LanguageSelect.route) { LanguageSelectScreen(navController) }
        composable(route = AuthScreens.Onboard.route) { OnboardScreen(navController) }
        composable(route = AuthScreens.Login.route) { LoginScreen(navController) }

//        composable(
//            route = MainScreen.Detail.route + "/{dominantColor}" + "/{name}",
//            arguments = listOf(
//                navArgument(name = "dominantColor") { type = NavType.IntType },
//                navArgument(name = "name") { type = NavType.StringType },
//            )
//        )
//        { entry ->
//            val dominantColor = remember {
//                val color = entry.arguments?.getInt("dominantColor")
//                color?.let { resColor -> Color(resColor) } ?: Color.White
//            }
//            val name = entry.arguments?.getString("name") ?: "Poke"
//            DetailScreen(navController, dominantColor, name)
//        }
    }
}