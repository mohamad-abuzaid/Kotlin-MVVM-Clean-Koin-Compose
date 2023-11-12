package com.compose.clean.ui.authentication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.compose.clean.domain.utils.storage.ILocalPreferencesStorage
import com.compose.clean.domain.utils.storage.Preference
import com.compose.clean.navigation.Graph
import com.compose.clean.navigation.authentication.authNavGraph
import com.compose.clean.ui.theme.MCKCTheme
import com.compose.clean.utils.C
import com.compose.clean.utils.LocalLang
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
            val skipToScreen = intent.extras?.getInt("skip_to_screen") ?: C.SPLASH_SCREEN

            MCKCTheme {
                NavHost(navController = navController, startDestination = Graph.AUTH) {
                    authNavGraph(navController, skipToScreen)
                }
            }
        }
    }
}