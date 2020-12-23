package com.example.myapplication

import android.content.Context
import kotlinx.serialization.Serializable

@Serializable
data class Message(val title: String, val message: String)