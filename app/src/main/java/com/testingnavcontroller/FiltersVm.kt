package com.testingnavcontroller

import androidx.lifecycle.ViewModel
import com.testingnavcontroller.fragments.FilterState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FiltersVm:ViewModel() {
    private val _state = MutableStateFlow<FilterState>(FilterState.Empty("No data"))
    val state = _state as StateFlow<FilterState>
}