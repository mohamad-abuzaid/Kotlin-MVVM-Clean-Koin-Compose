package com.compose.clean.ui.authentication.screens.language

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.compose.clean.domain.utils.storage.ILocalPreferencesStorage
import com.compose.clean.domain.utils.storage.Preference
import com.compose.clean.utils.LocalizationHelper
import com.compose.clean.viewmodels.authentication.AuthenticationViewModel
import com.compose.clean.viewmodels.authentication.states.LanguageUiState
import org.koin.androidx.compose.get
import org.koin.androidx.compose.koinViewModel

/**
 * Created by "Mohamad Abuzaid" on 10/05/2023.
 * Email: mabuzaid@sure.com.sa
 */

@Composable
fun LanguageSelectScreen(
    navController: NavController,
    authViewModel: AuthenticationViewModel = koinViewModel(),
    prefs: ILocalPreferencesStorage = get()
) {

    val context = LocalContext.current
    val languageUiState by authViewModel.languageUiState.collectAsState(initial = LanguageUiState.Idle)

    var selectedLanguage by remember {
        mutableStateOf(
            prefs.getString(Preference.LANGUAGE_KEY, "ar")
        )
    }
    var dropdownExpanded by remember { mutableStateOf(false) }

    // Handle languageUiState
    when (val langState = languageUiState) {
        is LanguageUiState.Idle -> {
            // Nothing to display
            Text("IDLE")
        }

        is LanguageUiState.Loading -> {
            // Display loading indicator
            Text("LOADING")
        }

        is LanguageUiState.Success -> {
            Column {
                TextField(
                    value = selectedLanguage,
                    onValueChange = { selectedLanguage = it },
                    label = { Text("Select a language") },
                    readOnly = true,
                )

                DropdownMenu(
                    expanded = dropdownExpanded,
                    onDismissRequest = { dropdownExpanded = false }
                ) {
                    langState.languages?.forEach { language ->
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = language.code,
                                    style = TextStyle(fontSize = 24.sp)
                                )
                            },
                            onClick = {
                                dropdownExpanded = false
                                prefs.putString(Preference.LANGUAGE_KEY, language.code)
                                selectedLanguage = language.code
                                LocalizationHelper.setLocale(context, selectedLanguage)
                                (context as Activity).recreate()
                            }
                        )
                    }
                }
            }
        }

        is LanguageUiState.Error -> {
            // Display error message
            Text("ERROR")
        }
    }

    LaunchedEffect(key1 = languageUiState) {
        authViewModel.fetchLanguages("")
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewLanguageSelectScreen() {
    LanguageSelectScreen(
        rememberNavController()
    )
}