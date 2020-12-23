package com.example.myapplication

import android.content.Context
import androidx.lifecycle.*
import com.example.myapplication.Config.JSON_FILE_NAME
import com.example.myapplication.util.IResProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.lang.Exception

class MainViewModel(
    private val resProvider: IResProvider
) : ViewModel() {
    val liveData = MutableLiveData<Message>()
//    val liveData: LiveData<Message>
//        get() = _liveData

    fun loadData() {
        viewModelScope
            .launch(Dispatchers.IO) {
                val inputStream = resProvider.openFile(JSON_FILE_NAME)
                inputStream.use {
                    val byteArray = inputStream.readBytes()
                    val jsonString = String(byteArray)
                    val message = Json.decodeFromString<Message>(jsonString)

                    liveData.postValue(message)
//                    _liveData.postValue(message)
                }
            }
    }
}

class MainViewModelFactory(private val resProvider: IResProvider) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(resProvider) as T
    }
}