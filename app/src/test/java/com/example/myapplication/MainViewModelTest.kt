package com.example.myapplication

import com.example.myapplication.util.MockResProvider
import org.junit.Test

import org.junit.Assert.*

class MainViewModelTest {

    val viewModel = MainViewModel(MockResProvider())

    @Test
    fun loadData() {
        viewModel.loadData()
    }
}