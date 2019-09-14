package id.majalengka.androidfundamental.network

import id.majalengka.androidfundamental.model.ResultResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface Webservice {

    @GET("{location}.json")
    suspend fun getPrayerTime(@Path("location") location: String ): ResultResponse
}