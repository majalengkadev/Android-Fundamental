package id.majalengka.androidfundamental

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import id.majalengka.androidfundamental.databinding.ActivityMainBinding
import id.majalengka.androidfundamental.ui.BaseActivity

class MainActivity : BaseActivity() {

    private val navController by lazy { findNavController(R.id.nav_host) }

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController)
    }
}
