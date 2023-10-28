package com.testingnavcontroller.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.testingnavcontroller.BackNavigateListener
import com.testingnavcontroller.R
import com.testingnavcontroller.databinding.FragmentFiltersBinding


class Filters : Fragment() {
    private lateinit var _binding:FragmentFiltersBinding
    private lateinit var backNavigateListener: BackNavigateListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFiltersBinding.inflate(inflater,container,false)

        backNavigateListener = requireContext() as BackNavigateListener

        // Inflate the layout for this fragment
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding.navigationBar.setNavigationOnClickListener {
            backNavigateListener.setOnBackNavigateListener("from Filters")
            findNavController().popBackStack()
        }
    }
}