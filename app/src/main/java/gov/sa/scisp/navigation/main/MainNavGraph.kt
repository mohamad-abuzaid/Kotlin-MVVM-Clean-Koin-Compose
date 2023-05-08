package gov.sa.scisp.navigation.main

import androidx.navigation.*
import androidx.navigation.compose.composable
import gov.sa.scisp.navigation.Graph
import gov.sa.scisp.ui.main.screens.home.HomeScreen

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
fun NavGraphBuilder.mainNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.Main,
        startDestination = MainScreens.Home.route
    ) {
        // ADD MAIN SCREENS
        composable(route = MainScreens.Home.route) { HomeScreen(navController) }

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