package id.majalengka.androidfundamental.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import id.majalengka.androidfundamental.viewmodel.MainViewModel
import id.majalengka.androidfundamental.viewmodel.ViewModelFactory
import id.majalengka.androidfundamental.viewmodel.ViewModelKey

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel


    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
