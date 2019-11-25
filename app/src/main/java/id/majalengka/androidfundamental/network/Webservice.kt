package id.majalengka.androidfundamental.network

import id.majalengka.androidfundamental.model.ResultResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface Webservice {

    @GET("{location}/weekly.json")
    suspend fun getWeeklyPrayerTime(@Path("location") location: String ): ResultResponse

    @GET("{location}.json")
    suspend fun getTodayPrayerTime(@Path("location") location: String ): ResultResponse
}