package com.example.myapplication.util

import java.io.InputStream

interface IResProvider {
    fun openFile(fileName: String): InputStream
}