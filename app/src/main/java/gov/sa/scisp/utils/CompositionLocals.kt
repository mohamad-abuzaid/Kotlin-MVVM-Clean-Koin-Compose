package gov.sa.scisp.utils

import androidx.compose.runtime.staticCompositionLocalOf
import gov.sa.scisp.models.authentication.login.LoginDisplay

/**
 * Created by "Mohamad Abuzaid" on 01/06/2023.
 * Email: mabuzaid@sure.com.sa
 */

val LocalUser = staticCompositionLocalOf<LoginDisplay?> { null }
val LocalLang = staticCompositionLocalOf { "ar" }
val LocalToken = staticCompositionLocalOf { "" }
