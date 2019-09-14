package id.majalengka.androidfundamental.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.majalengka.androidfundamental.viewmodel.MainViewModel
import id.majalengka.androidfundamental.databinding.FragmentPrayerTimeBinding
import id.majalengka.androidfundamental.adapters.PrayerTimeAdapter
import id.majalengka.androidfundamental.utils.Result
import javax.inject.Inject

class PrayerTimeFragment : Fragment() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: MainViewModel by viewModels { viewModelFactory }
    val adapter: PrayerTimeAdapter by lazy {
        PrayerTimeAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = FragmentPrayerTimeBinding.inflate(inflater, container, false)
                .apply {
                    recyclerView.adapter = adapter
                }



        subscribeUi(binding, adapter)

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun subscribeUi(binding: FragmentPrayerTimeBinding, adapter: PrayerTimeAdapter) {
        viewModel.data.observe(viewLifecycleOwner, Observer { result ->
            when (result.status) {
                Result.Status.SUCCESS -> {
                    //binding.progressBar.hide()
                    result.data?.let { adapter.submitList(it.items) }
                }
                Result.Status.LOADING -> {

                }//binding.progressBar.show()
                Result.Status.ERROR -> {
                    ///binding.progressBar.hide()
                    //Snackbar.make(binding.root, result.message!!, Snackbar.LENGTH_LONG).show()
                }
            }
        })
    }


}
