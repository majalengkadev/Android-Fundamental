package id.majalengka.androidfundamental

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import id.majalengka.androidfundamental.di.component.DaggerAppComponent


class App: DaggerApplication() {

    private val appComponent by lazy {
        DaggerAppComponent.builder()
                .application(this)
                .build()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent.inject(this)
        return appComponent
    }



}