package id.majalengka.androidfundamental.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
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
                .apply {
                    lifecycleOwner = viewLifecycleOwner
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL,false)
                        adapter = this@PrayerTimeFragment.adapter
                    }
                }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.data.observe(this, Observer {
            adapter.submitList(it.items)
        })
    }



}
