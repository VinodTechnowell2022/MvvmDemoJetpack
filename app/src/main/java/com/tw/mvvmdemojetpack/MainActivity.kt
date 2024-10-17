package com.tw.mvvmdemojetpack

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.tw.mvvmdemojetpack.screens.PostsScreen
import com.tw.mvvmdemojetpack.ui.theme.MvvmDemoJetpackTheme
import com.tw.mvvmdemojetpack.viewmodels.PostViewModel

class MainActivity : ComponentActivity() {

    val TAG:String = this.javaClass.javaClass.toString()
    private val viewModel: PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MvvmDemoJetpackTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Log.e(TAG, "onCreate innerPadding : $innerPadding")
                    PostsScreen(viewModel, this@MainActivity)
                }
            }
        }
    }
}

