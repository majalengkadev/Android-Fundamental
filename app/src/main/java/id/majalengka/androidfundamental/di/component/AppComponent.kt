package id.majalengka.androidfundamental.di.component

import dagger.Component
import id.majalengka.androidfundamental.di.module.NetworkModule
import id.majalengka.androidfundamental.di.subcomponent.PrayerTimesListComponent

@Component(modules = [NetworkModule::class])
interface AppComponent {
    fun prayerTimeListComponent(): PrayerTimesListComponent
}