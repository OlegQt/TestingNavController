package com.testingnavcontroller.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.testingnavcontroller.R
import com.testingnavcontroller.databinding.FragmentFiltersBinding


class Filters : Fragment() {
    private lateinit var _binding:FragmentFiltersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFiltersBinding.inflate(inflater,container,false)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_filters, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding.navigationBar.setNavigationOnClickListener {
            Snackbar.make(_binding.txtTitle,"Back pressed",Snackbar.LENGTH_LONG).show()
        }
    }

}