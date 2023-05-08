package gov.sa.scisp.ui.authentication.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import gov.sa.scisp.R

/**
 * Created by "Mohamad Abuzaid" on 08/05/2023.
 * Email: mabuzaid@sure.com.sa
 */

@Composable
fun LoginScreen(navController: NavController) {

    var tabIndex by remember { mutableStateOf(0) }

    val padding = dimensionResource(R.dimen.login_screen_padding)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TabRow(
            selectedTabIndex = tabIndex,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(tabPositions[tabIndex])
                )
            },
        ) {
            Tab(
                text = { Text(stringResource(R.string.vip_login)) },
                selected = tabIndex == 0,
                onClick = { tabIndex = 0 }
            )
            Tab(
                text = { Text(stringResource(R.string.user_login)) },
                selected = tabIndex == 1,
                onClick = { tabIndex = 1 }
            )
        }

        when (tabIndex) {
            0 -> VipLoginScreen(navController)
            1 -> UserLoginScreen(navController)
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen(rememberNavController())
}