package id.majalengka.androidfundamental.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.majalengka.androidfundamental.di.scope.FragmentScope
import id.majalengka.androidfundamental.ui.PrayerTimeFragment

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributePrayerFragment(): PrayerTimeFragment

}
