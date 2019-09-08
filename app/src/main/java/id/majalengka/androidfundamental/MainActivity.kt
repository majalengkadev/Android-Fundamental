package id.majalengka.androidfundamental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.majalengka.androidfundamental.ui.PrayerTimeFragment

class MainActivity : AppCompatActivity() {

    private val prayerTimeFragment = PrayerTimeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
                .add(R.id.container, prayerTimeFragment)
                .commit()
    }
}
