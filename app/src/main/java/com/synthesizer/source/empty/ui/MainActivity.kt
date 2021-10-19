package com.synthesizer.source.empty.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.synthesizer.source.empty.R
import com.synthesizer.source.empty.data.api.RetrofitBase.service
import com.synthesizer.source.empty.ui.main.CharacterListAdapter
import com.synthesizer.source.empty.ui.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}