package id.majalengka.androidfundamental.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import id.majalengka.androidfundamental.R
import id.majalengka.androidfundamental.viewmodel.ViewModelFactory
import javax.inject.Inject

class PrayerTimeFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_prayer_time, container, false)
    }


}
