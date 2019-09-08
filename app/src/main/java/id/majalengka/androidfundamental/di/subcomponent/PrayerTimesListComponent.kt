package id.majalengka.androidfundamental.di.subcomponent

import dagger.Subcomponent
import id.majalengka.androidfundamental.di.module.ViewModelFactoryModule
import id.majalengka.androidfundamental.di.scope.FragmentScope

@FragmentScope
@Subcomponent(modules = [ViewModelFactoryModule::class])
interface PrayerTimesListComponent {
}