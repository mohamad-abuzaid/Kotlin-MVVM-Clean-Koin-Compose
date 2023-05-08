package gov.sa.scisp.ui.authentication.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import gov.sa.scisp.R
import gov.sa.scisp.states.authentication.LoginUiState
import gov.sa.scisp.viewmodels.authentication.AuthenticationViewModel
import org.koin.androidx.compose.getViewModel

/**
 * Created by "Mohamad Abuzaid" on 08/05/2023.
 * Email: mabuzaid@sure.com.sa
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserLoginScreen(
    navController: NavController,
) {
    val authViewModel: AuthenticationViewModel = getViewModel()
    val loginUiState by authViewModel.loginUiState.collectAsState(initial = LoginUiState.Idle)

    val onLoginClick: (String, String) -> Unit = { username, password ->
        authViewModel.vipLogin(username, password)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.login_screen_padding)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var username by remember { mutableStateOf(TextFieldValue()) }
        var password by remember { mutableStateOf(TextFieldValue()) }

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(stringResource(R.string.username_label)) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.login_screen_spacing)))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(stringResource(R.string.password_label)) },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.login_screen_spacing)))

        Button(onClick = { onLoginClick(username.text, password.text) }) {
            Text(stringResource(R.string.login_button))
        }

        // Handle loginUiState
        when (loginUiState) {
            is LoginUiState.Idle -> {
                // Nothing to display
            }

            is LoginUiState.Loading -> {
                // Display loading indicator
            }

            is LoginUiState.Success -> {
                // Display success message or navigate to another screen
            }

            is LoginUiState.Error -> {
                // Display error message
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewUserLoginScreen() {
    UserLoginScreen(rememberNavController())
}