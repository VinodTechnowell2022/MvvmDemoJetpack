package com.tw.mvvmdemojetpack.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import com.tw.mvvmdemojetpack.MainActivity
import com.tw.mvvmdemojetpack.viewmodels.PostViewModel

@Composable
fun PostsScreen(viewModel: PostViewModel, context: MainActivity){

    val listData by viewModel._posts.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchPosts()
    }

    Column {
        if (listData.isEmpty()) {
            // Show loading indicator or placeholder
            Text(text = "Loading...")
        } else {
            // Display the list of credit cards
            LazyColumn {
                items(listData.size) { index ->

                    Card (
                        shape = RoundedCornerShape(8.dp),
                        colors = CardColors(containerColor = White, contentColor = Black, disabledContentColor = Black, disabledContainerColor = White),
                        modifier = Modifier
                            .padding(10.dp)
                            .wrapContentSize()
                            .clickable {
                                Toast.makeText(context, "${listData[index].id}", Toast.LENGTH_SHORT).show()
                            },
                        elevation =  CardDefaults.cardElevation(defaultElevation = 10.dp),

                    ){
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
                            Column(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                                //.background(color = Color(0xFFF7F2F9))
                            ) {

                                Text(text = "Id : ${listData[index].id}")
                                Text(text = "Title : ${listData[index].title}", color = Color.Blue)
                                //Text(text = creditCards[index].body)
                            }
                        }

                    }

                }
            }
        }

    }

}