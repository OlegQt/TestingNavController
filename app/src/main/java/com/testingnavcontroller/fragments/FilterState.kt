package com.testingnavcontroller.fragments

sealed class FilterState {
    class Data(val data: String) : FilterState()
    class Empty(val error: String) : FilterState()
}
