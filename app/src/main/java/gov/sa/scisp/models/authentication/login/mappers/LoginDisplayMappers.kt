package gov.sa.scisp.models.authentication.login.mappers

import gov.sa.scisp.domain.authentication.models.login.LoginModel
import gov.sa.scisp.models.authentication.login.LoginDisplay

/**
 * Created by Mohamad Abuzaid on 05/07/2023.
 */
fun LoginModel.toLoginDisplay() = LoginDisplay(
    username, firstname, lastname
)