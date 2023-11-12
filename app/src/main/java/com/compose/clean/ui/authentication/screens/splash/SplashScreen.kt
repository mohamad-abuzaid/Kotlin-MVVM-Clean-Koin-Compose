package com.compose.clean.ui.authentication.screens.splash

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.compose.clean.R
import com.compose.clean.domain.utils.storage.ILocalPreferencesStorage
import com.compose.clean.domain.utils.storage.Preference
import com.compose.clean.navigation.authentication.AuthScreens
import com.compose.clean.ui.main.MainActivity
import com.compose.clean.utils.findActivity
import kotlinx.coroutines.delay
import org.koin.compose.koinInject

/**
 * Created by "Mohamad Abuzaid" on 22/06/2023.
 * Email: mabuzaid@sure.com.sa
 */

@Composable
fun SplashScreen(
    navController: NavController,
    prefs: ILocalPreferencesStorage = koinInject()
) {
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.splash_background),
            contentDescription = "Splash Image",
            contentScale = ContentScale.FillBounds
        )
    }

    val currentTime = System.currentTimeMillis()
    val firstTime = prefs.getBoolean(Preference.FIRST_TIME_LAUNCH, true)
    val userToken = prefs.getString(Preference.USER_TOKEN, "")

    LaunchedEffect(key1 = currentTime) {
        delay(3000)
        if (firstTime) {
            navController.navigate(route = AuthScreens.LanguageSelect.route)
        } else if (userToken.isEmpty()) {
            navController.navigate(route = AuthScreens.Login.route)
        } else {
            goToMainActivity(context.findActivity())
        }
    }
}

fun goToMainActivity(activity: Activity?) {
    val intent = Intent(activity, MainActivity::class.java)
    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
    activity?.startActivity(intent)

    activity?.finish()
}

@Preview(showSystemUi = false, showBackground = true, locale = "ar")
@Composable
fun PreviewSplashScreenScreen() {
    SplashScreen(
        rememberNavController()
    )
}