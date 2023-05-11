package gov.sa.scisp.models.authentication.languages.mappers

import gov.sa.scisp.domain.authentication.models.login.LanguageModel
import gov.sa.scisp.models.authentication.languages.LanguageDisplay

/**
 * Created by Mohamad Abuzaid on 10/07/2023.
 */
fun LanguageModel.toLanguageDisplay() = LanguageDisplay(
    name, code
)

fun List<LanguageModel>.toLanguageDisplayList() =
    map { it.toLanguageDisplay() }