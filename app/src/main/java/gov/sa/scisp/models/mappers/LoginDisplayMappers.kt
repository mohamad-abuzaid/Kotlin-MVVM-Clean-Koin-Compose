package gov.sa.scisp.models.mappers

import gov.sa.scisp.domain.authentication.models.LoginModel
import gov.sa.scisp.models.authentication.LoginDisplay

/**
 * Created by Mohamad Abuzaid on 05/07/2023.
 */
fun LoginModel.toLoginDisplay() = LoginDisplay(
    username, firstname, lastname
)