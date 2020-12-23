package com.example.myapplication.util

import android.content.Context
import java.io.InputStream

class ResProvider(context: Context) : IResProvider {
    private val asset = context.assets

    override fun openFile(fileName: String): InputStream {
        return asset.open(fileName)
    }
}