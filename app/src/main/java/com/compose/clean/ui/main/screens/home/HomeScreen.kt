package com.compose.clean.ui.main.screens.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

/**
 * Created by "Mohamad Abuzaid" on 08/05/2023.
 * Email: mabuzaid@sure.com.sa
 */

@Composable
fun HomeScreen(
    navController: NavController,
) {
    Text("Hello Home!")
}

@Preview
@Composable
fun PreviewLoginScreen() {
    HomeScreen(rememberNavController())
}