package com.compose.clean.data.network.models.authentication.languages.mappers

import com.compose.clean.data.network.models.authentication.languages.response.LanguageRemote
import com.compose.clean.domain.authentication.models.login.LanguageModel

/**
 * Created by Mohamad Abuzaid on 10/07/2023.
 */
fun LanguageRemote.toLanguageModel() = LanguageModel(
    name, code
)

fun List<LanguageRemote>.toLanguageModelList() =
    map { it.toLanguageModel() }