package com.testingnavcontroller.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.testingnavcontroller.R
import com.testingnavcontroller.databinding.FragmentContentBinding


class Content : Fragment() {
    private lateinit var _binding:FragmentContentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContentBinding.inflate(inflater,container,false)

        // Inflate the layout for this fragment
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentFragmentManager.setFragmentResultListener("key",viewLifecycleOwner) { key, bundle ->
            // Здесь можно передать любой тип, поддерживаемый Bundle-ом
            val result = bundle.getString("bundleKey")
            Snackbar.make(_binding.txtTitle,result.toString(),Snackbar.LENGTH_LONG).show()
        }

        _binding.btnNavigateToFilter.setOnClickListener {
            findNavController().navigate(R.id.action_navigate_to_filters)
        }
    }

    fun receiveData(msg:String){
        Snackbar.make(_binding.txtTitle,msg,Snackbar.LENGTH_LONG).show()
    }

}