package gov.sa.scisp.ui.authentication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import gov.sa.scisp.navigation.Graph
import gov.sa.scisp.navigation.authentication.authNavGraph
import gov.sa.scisp.ui.authentication.theme.SCTMTTheme

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
class AuthenticationActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            SCTMTTheme {
                NavHost(navController = navController, startDestination = Graph.AUTH) {
                    authNavGraph(navController)
                }
            }
        }
    }
}