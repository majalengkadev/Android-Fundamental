package id.majalengka.androidfundamental.di.module

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import id.majalengka.androidfundamental.viewmodel.ViewModelFactory

@Module
abstract class ViewModelFactoryModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}