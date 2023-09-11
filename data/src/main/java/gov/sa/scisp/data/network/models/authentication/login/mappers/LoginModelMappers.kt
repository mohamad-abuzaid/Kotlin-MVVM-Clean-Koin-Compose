package gov.sa.scisp.data.network.models.authentication.login.mappers

import gov.sa.scisp.data.network.models.authentication.login.response.LoginRemote
import gov.sa.scisp.domain.authentication.models.login.LoginModel

/**
 * Created by Mohamad Abuzaid on 05/07/2023.
 */
fun LoginRemote.toLoginModel() = LoginModel(
    username, firstname, lastname
)