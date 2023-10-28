package com.testingnavcontroller.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.testingnavcontroller.FiltersVm
import com.testingnavcontroller.databinding.FragmentFiltersBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class Filters : Fragment() {
    private lateinit var _binding:FragmentFiltersBinding
    private lateinit var vm:FiltersVm


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFiltersBinding.inflate(inflater,container,false)
        vm = ViewModelProvider(this)[FiltersVm::class.java]

        // Start a coroutine in the lifecycle scope
        lifecycleScope.launch {
            vm.state.flowWithLifecycle(lifecycle,Lifecycle.State.STARTED).collect{
                when(it){
                    is FilterState.Empty -> _binding.navigationBar.title = it.error
                    is FilterState.Data ->_binding.navigationBar.title = it.data
                }
            }
        }

        // Inflate the layout for this fragment
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding.navigationBar.setNavigationOnClickListener {
            parentFragmentManager.setFragmentResult("key", Bundle().apply { putString("bundleKey","Возврат с фрагмента Фильтры. Можно выполнить любую функцию") })
            findNavController().popBackStack()
        }
    }


}