package id.majalengka.androidfundamental.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import id.majalengka.androidfundamental.viewmodel.MainViewModel
import id.majalengka.androidfundamental.viewmodel.ViewModelKey

@Module
abstract class PrayerTimesListComponentModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}