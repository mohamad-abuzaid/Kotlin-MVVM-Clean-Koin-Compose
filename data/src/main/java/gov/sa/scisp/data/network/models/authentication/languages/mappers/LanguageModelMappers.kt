package gov.sa.scisp.data.network.models.authentication.languages.mappers

import gov.sa.scisp.data.network.models.authentication.languages.response.LanguageRemote
import gov.sa.scisp.domain.authentication.models.login.LanguageModel

/**
 * Created by Mohamad Abuzaid on 10/07/2023.
 */
fun LanguageRemote.toLanguageModel() = LanguageModel(
    name, code
)

fun List<LanguageRemote>.toLanguageModelList() =
    map { it.toLanguageModel() }