package id.majalengka.androidfundamental.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.majalengka.androidfundamental.ui.PrayerTimeFragment

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributePrayerFragment(): PrayerTimeFragment

}
