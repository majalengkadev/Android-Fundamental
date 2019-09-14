package id.majalengka.androidfundamental.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import id.majalengka.androidfundamental.App
import id.majalengka.androidfundamental.di.module.MainActivityModule
import id.majalengka.androidfundamental.di.module.NetworkModule
import id.majalengka.androidfundamental.di.module.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AndroidSupportInjectionModule::class,
            MainActivityModule::class,
            NetworkModule::class,
            ViewModelModule::class
        ]
)
interface AppComponent: AndroidInjector<DaggerApplication> {

    fun inject(application: App)

    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

}