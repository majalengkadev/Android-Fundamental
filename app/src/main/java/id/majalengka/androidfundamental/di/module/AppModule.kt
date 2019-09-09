package id.majalengka.androidfundamental.di.module

import dagger.Module
import dagger.Provides
import id.majalengka.androidfundamental.data.remote.RemoteDataSource
import id.majalengka.androidfundamental.di.scope.CoroutineScropeIO
import id.majalengka.androidfundamental.di.scope.PrayerTimeAPI
import id.majalengka.androidfundamental.network.AuthInterceptor
import id.majalengka.androidfundamental.network.Webservice
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class, CoreDataModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideWebService(@PrayerTimeAPI okhttpClient: OkHttpClient,
                           converterFactory: GsonConverterFactory
    ) = provideService(okhttpClient, converterFactory, Webservice::class.java)

    @Singleton
    @Provides
    fun provideRemoteDataSource(webservice: Webservice)
            = RemoteDataSource(webservice)


    @PrayerTimeAPI
    @Provides
    fun providePrivateOkHttpClient(
            upstreamClient: OkHttpClient
    ): OkHttpClient {
        return upstreamClient.newBuilder()
                .addInterceptor(AuthInterceptor("")).build()
    }


    @CoroutineScropeIO
    @Provides
    fun provideCoroutineScopeIO() = CoroutineScope(Dispatchers.IO)


    private fun createRetrofit(
            okhttpClient: OkHttpClient,
            converterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
                .baseUrl("")
                .client(okhttpClient)
                .addConverterFactory(converterFactory)
                .build()
    }

    private fun <T> provideService(okhttpClient: OkHttpClient,
            converterFactory: GsonConverterFactory, clazz: Class<T>): T {
        return createRetrofit(okhttpClient, converterFactory).create(clazz)
    }
}
