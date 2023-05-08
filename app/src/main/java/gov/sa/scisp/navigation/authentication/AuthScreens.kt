package gov.sa.scisp.navigation.authentication

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
sealed class AuthScreens(val route: String) {
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