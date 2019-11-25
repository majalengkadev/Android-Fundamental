package id.majalengka.androidfundamental.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import id.majalengka.androidfundamental.BuildConfig
import id.majalengka.androidfundamental.network.Webservice
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideInterceptor(): Interceptor {
        return Interceptor { chain ->
            val original = chain.request()
            val originalHttpUrl = original.url()
                    .newBuilder()
                    .addQueryParameter("key", BuildConfig.API_KEY)
                    .build()
            val builderNew = original.newBuilder().apply {
                addHeader("Accept", "application/json")
                addHeader("Content-Type", "application/json")
                url(originalHttpUrl)
            }
            val requestNew = builderNew.build()
            chain.proceed(requestNew)
        }
    }

    @Provides
    @Singleton
    fun provideHttpLogging(): HttpLoggingInterceptor =
            HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    @Provides
    @Singleton
    fun provideOkHttpBuilder(
            interceptor: Interceptor,
            httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient =
            OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .followRedirects(false)
                    .addInterceptor(interceptor)
                    .apply { if (BuildConfig.DEBUG) addInterceptor(httpLoggingInterceptor) }
                    .build()

    @Provides
    @Singleton
    fun provideRetrofit(
            gson: Gson,
            okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): Webservice =
            retrofit.create(Webservice::class.java)
}