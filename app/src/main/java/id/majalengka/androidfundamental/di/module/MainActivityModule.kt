package id.majalengka.androidfundamental.di.module


import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.majalengka.androidfundamental.MainActivity

@Suppress("unused")
@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity
}
