package gov.sa.scisp.data.network.models.login.mappers

import gov.sa.scisp.data.network.models.login.response.LoginRemote
import gov.sa.scisp.domain.authentication.models.LoginModel

/**
 * Created by Mohamad Abuzaid on 05/07/2023.
 */
fun LoginRemote.toLoginModel() = LoginModel(
    username, firstname, lastname
)