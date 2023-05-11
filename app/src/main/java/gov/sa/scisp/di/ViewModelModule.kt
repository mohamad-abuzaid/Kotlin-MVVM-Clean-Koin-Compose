package gov.sa.scisp.di

import gov.sa.scisp.viewmodels.authentication.AuthenticationViewModel
import gov.sa.scisp.viewmodels.authentication.base.BaseAuthenticationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
val viewModelsModule = module {
    viewModel<BaseAuthenticationViewModel> { AuthenticationViewModel(get(), get(), get(), get(), get()) }
}