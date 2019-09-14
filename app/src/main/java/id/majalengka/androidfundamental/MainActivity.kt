package id.majalengka.androidfundamental

import android.os.Bundle
import id.majalengka.androidfundamental.ui.BaseActivity
import id.majalengka.androidfundamental.ui.PrayerTimeFragment

class MainActivity : BaseActivity() {

    private val prayerTimeFragment = PrayerTimeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
                .add(R.id.container, prayerTimeFragment)
                .commit()
    }
}
