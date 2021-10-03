package com.wuhao.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wuhao.test.presentation.Screen
import com.wuhao.test.presentation.SearchView
import com.wuhao.test.presentation.commentlist.CommentListScreen
import com.wuhao.test.presentation.postlist.PostListScreen
import com.wuhao.test.ui.theme.TestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.PostListScreen.route
                    ) {
                        composable(
                            route = Screen.PostListScreen.route
                        ) {
                            val textState = remember { mutableStateOf(TextFieldValue("")) }
                            Column {
                                SearchView(textState)
                                PostListScreen(navController, textState)
                            }
                        }
                        composable(
                            route = Screen.CommentListScreen.route + "/{postId}"
                        ) {
                            CommentListScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestTheme {
        Greeting("Android")
    }
}