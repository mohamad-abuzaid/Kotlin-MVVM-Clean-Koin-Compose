package gov.sa.scisp.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import gov.sa.scisp.navigation.Graph
import gov.sa.scisp.navigation.main.mainNavGraph
import gov.sa.scisp.ui.main.theme.SCTMTTheme

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            SCTMTTheme {
                NavHost(navController = navController, startDestination = Graph.Main) {
                    mainNavGraph(navController)
                }
            }
        }
    }
}