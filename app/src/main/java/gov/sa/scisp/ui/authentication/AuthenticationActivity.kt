package gov.sa.scisp.ui.authentication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import gov.sa.scisp.domain.utils.storage.ILocalPreferencesStorage
import gov.sa.scisp.domain.utils.storage.Preference
import gov.sa.scisp.navigation.Graph
import gov.sa.scisp.navigation.authentication.authNavGraph
import gov.sa.scisp.ui.theme.MCKCTheme
import gov.sa.scisp.utils.LocalLang
import org.koin.android.ext.android.inject

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
class AuthenticationActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    private val prefs: ILocalPreferencesStorage by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val lang = prefs.getString(Preference.LANGUAGE_KEY, "ar")

        setContent {
            navController = rememberNavController()

            CompositionLocalProvider(
                LocalLang provides lang
            ) {
                MCKCTheme {
                    NavHost(navController = navController, startDestination = Graph.AUTH) {
                        authNavGraph(navController)
                    }
                }
            }
        }
    }
}