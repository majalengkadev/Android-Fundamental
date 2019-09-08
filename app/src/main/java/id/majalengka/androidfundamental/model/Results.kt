package id.majalengka.androidfundamental.model

data class Results (
        val title: String = "",
        val latitude: String = "",
        val longitude: String = "",
        val address: String = "",
        val city: String = "",
        val state: String = "",
        val country: String = "",
        val country_code: String = "",
        val items: List<Item> = emptyList()
)

data class Item(
        val date_for: String = "",
        val fajr: String = "",
        val shurooq: String = "",
        val dhuhr: String = "",
        val asr: String = "",
        val maghrib: String = "",
        val isha: String = ""
)