package gov.sa.scisp.di

import gov.sa.scisp.viewmodels.authentication.AuthenticationViewModel
import gov.sa.scisp.viewmodels.main.token.TokenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
val viewModelsModule = module {
    viewModelOf(::AuthenticationViewModel)
    viewModelOf(::TokenViewModel)
}