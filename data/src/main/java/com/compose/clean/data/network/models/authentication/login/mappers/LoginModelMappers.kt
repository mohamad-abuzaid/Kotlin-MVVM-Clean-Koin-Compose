package com.compose.clean.data.network.models.authentication.login.mappers

import com.compose.clean.data.network.models.authentication.login.response.LoginRemote
import com.compose.clean.domain.authentication.models.login.LoginModel

/**
 * Created by Mohamad Abuzaid on 05/07/2023.
 */
fun LoginRemote.toLoginModel() = LoginModel(
    username, firstname, lastname
)