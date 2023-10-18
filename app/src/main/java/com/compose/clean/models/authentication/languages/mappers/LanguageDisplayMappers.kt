package com.compose.clean.models.authentication.languages.mappers

import com.compose.clean.domain.authentication.models.login.LanguageModel
import com.compose.clean.models.authentication.languages.LanguageDisplay

/**
 * Created by Mohamad Abuzaid on 10/07/2023.
 */
fun LanguageModel.toLanguageDisplay() = LanguageDisplay(
    name, code
)

fun List<LanguageModel>.toLanguageDisplayList() =
    map { it.toLanguageDisplay() }