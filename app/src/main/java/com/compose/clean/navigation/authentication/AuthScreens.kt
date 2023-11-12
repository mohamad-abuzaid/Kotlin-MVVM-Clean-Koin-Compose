package com.compose.clean.navigation.authentication

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
sealed class AuthScreens(val route: String) {
    object Splash : AuthScreens("splash_screen")
    object LanguageSelect : AuthScreens("language_select_screen")
    object Login : AuthScreens("login_screen")

    // pass args ext function
    // works only with mandatory args
    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}