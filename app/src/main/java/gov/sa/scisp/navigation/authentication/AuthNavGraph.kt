package gov.sa.scisp.navigation.authentication

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import gov.sa.scisp.navigation.Graph
import gov.sa.scisp.ui.authentication.screens.login.LoginScreen

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreens.Login.route
    ) {
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