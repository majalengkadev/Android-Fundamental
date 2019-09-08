package id.majalengka.androidfundamental.di.component

import dagger.Component
import id.majalengka.androidfundamental.di.module.NetworkModule

@Component(modules = [NetworkModule::class])
interface AppComponent {

}