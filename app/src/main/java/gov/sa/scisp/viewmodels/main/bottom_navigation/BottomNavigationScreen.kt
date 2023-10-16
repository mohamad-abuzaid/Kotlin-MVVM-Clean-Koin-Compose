package gov.sa.scisp.viewmodels.main.bottom_navigation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import gov.sa.scisp.ui.authentication.AuthenticationActivity
import gov.sa.scisp.utils.C
import gov.sa.scisp.utils.findActivity
import gov.sa.scisp.viewmodels.main.token.TokenViewModel
import org.koin.androidx.compose.koinViewModel

/**
 * Created by "Mohamad Abuzaid" on 25/05/2023.
 * Email: mabuzaid@sure.com.sa
 */

@Composable
fun BottomNavigationScreen(
    navController: NavHostController,
    tokenViewModel: TokenViewModel = koinViewModel(),
) {
    val context = LocalContext.current

    val tokenState by tokenViewModel.tokenState.collectAsState(initial = false)
    LaunchedEffect(key1 = tokenState) {
        if (tokenState) {
            tokenViewModel.resetTokenState()
            goToAuthActivity(context.findActivity())
        }
    }

}

private fun goToAuthActivity(activity: Activity?) {
    val mBundle = Bundle().apply { putInt("skip_to_screen", C.LOGIN_SCREEN) }
    val intent = Intent(activity, AuthenticationActivity::class.java)
    intent.putExtras(mBundle)
    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK

    activity?.startActivity(intent)
    activity?.finish()
}

@Preview(showSystemUi = false, showBackground = true, locale = "ar")
@Composable
fun PreviewBottomNavigationScreen() {
    BottomNavigationScreen(rememberNavController())
}