package id.majalengka.androidfundamental

import android.app.Application
import id.majalengka.androidfundamental.di.component.AppComponent
import id.majalengka.androidfundamental.di.component.DaggerAppComponent
import id.majalengka.androidfundamental.di.module.NetworkModule

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        this.appComponent = this.initDagger()
    }

    private fun initDagger() = DaggerAppComponent.builder()
            .networkModule(NetworkModule())
            .build()


}