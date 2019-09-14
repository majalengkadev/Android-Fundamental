package id.majalengka.androidfundamental.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import id.majalengka.androidfundamental.viewmodel.MainViewModel
import id.majalengka.androidfundamental.databinding.FragmentPrayerTimeBinding
import id.majalengka.androidfundamental.adapters.PrayerTimeAdapter

import javax.inject.Inject

class PrayerTimeFragment : DaggerFragment() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: MainViewModel by viewModels { viewModelFactory }
    val adapter: PrayerTimeAdapter by lazy {
        PrayerTimeAdapter()
    }

    lateinit var binding: FragmentPrayerTimeBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPrayerTimeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        subscribeUi()
    }

    private fun subscribeUi() {
        viewModel.data.observe(viewLifecycleOwner, Observer { result ->
            Toast.makeText(activity, result.toString(), Toast.LENGTH_SHORT).show()
//            when (result.status) {
//                Result.Status.SUCCESS -> {
//                    //binding.progressBar.hide()
//                    result.data?.let { adapter.submitList(it.items) }
//                }
//                Result.Status.LOADING -> {
//
//                }//binding.progressBar.show()
//                Result.Status.ERROR -> {
//                    ///binding.progressBar.hide()
//                    //Snackbar.make(binding.root, result.message!!, Snackbar.LENGTH_LONG).show()
//                }
//            }
        })
    }


}
