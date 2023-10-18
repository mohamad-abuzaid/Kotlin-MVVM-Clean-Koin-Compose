package com.compose.clean.ui.authentication.screens.onboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import com.compose.clean.R
import com.compose.clean.viewmodels.authentication.AuthenticationViewModel
import com.compose.clean.viewmodels.authentication.states.LoginUiState
import org.koin.androidx.compose.koinViewModel

/**
 * Created by "Mohamad Abuzaid" on 10/05/2023.
 * Email: mabuzaid@sure.com.sa
 */

@Composable
fun OnboardScreen(
    navController: NavController,
    authViewModel: AuthenticationViewModel = koinViewModel()
) {

    val loginUiState by authViewModel.loginUiState.collectAsState(initial = LoginUiState.Idle)

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

        Button(onClick = { authViewModel.vipLogin(username.text, password.text) }) {
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
    OnboardScreen(
        rememberNavController()
    )
}