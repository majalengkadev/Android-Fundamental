package id.majalengka.androidfundamental.di.module


import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.majalengka.androidfundamental.MainActivity
import id.majalengka.androidfundamental.di.scope.AppScope

@Suppress("unused")
@Module
abstract class MainActivityModule {
    @AppScope
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity
}
