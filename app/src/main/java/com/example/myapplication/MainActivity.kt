package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.*
import com.example.myapplication.util.ResProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel //TODO viewModel
    //kotlin property delegate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resProvider = ResProvider(this)
        val factory = MainViewModelFactory(resProvider)
        viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)


        findViewById<FloatingActionButton>(R.id.fab)
            .setOnClickListener {
                showData()
            }
        listenData()
    }

    private fun listenData() {
        val tv = findViewById<TextView>(R.id.tv)
        viewModel
            .liveData
            .observe(this, Observer { message: Message ->
                tv.text = "title:${message.title}\n message:${message.message}"
            })
    }

    private fun showData() {
        viewModel.loadData()
    }

//    override fun getLastNonConfigurationInstance(): Any? {
//        return viewModel
//    }
//
//    override fun getLastCustomNonConfigurationInstance(): Any? {
//        return super.getLastCustomNonConfigurationInstance()
//    }
}