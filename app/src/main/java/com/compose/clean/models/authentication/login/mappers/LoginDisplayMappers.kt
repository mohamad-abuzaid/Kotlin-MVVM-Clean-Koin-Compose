package com.compose.clean.models.authentication.login.mappers

import com.compose.clean.domain.authentication.models.login.LoginModel
import com.compose.clean.models.authentication.login.LoginDisplay

/**
 * Created by Mohamad Abuzaid on 05/07/2023.
 */
fun LoginModel.toLoginDisplay() = LoginDisplay(
    username, firstname, lastname
)