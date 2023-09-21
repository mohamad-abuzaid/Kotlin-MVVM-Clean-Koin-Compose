package gov.sa.scisp.ui.authentication.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

/**
 * Created by "Mohamad Abuzaid" on 08/05/2023.
 * Email: mabuzaid@sure.com.sa
 */

@Composable
fun LoginScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Login Screen")
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen(rememberNavController())
}