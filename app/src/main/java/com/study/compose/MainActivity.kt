package com.study.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.study.compose.room.AppDataBase
import com.study.compose.room.dao.WorkerDao
import com.study.compose.room.entity.WorkerEntity
import com.study.compose.ui.theme.ComposeTheme
import java.time.LocalDateTime

class MainActivity : ComponentActivity() {
    private lateinit var room: AppDataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        room =
            Room.databaseBuilder(applicationContext, AppDataBase::class.java, "worker-db").build()
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TextButton(onClick = {
                        addTest()

                    }) {
                        Text(text = "입력")
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        if (room.isOpen) room.close()
        super.onDestroy()
    }

    fun addTest() {
        val r = Runnable {
            room.workerDao().saveWorker(
                WorkerEntity(
                    0,
                    "test@test.com",
                    "1234",
                    1,
                    "test",
                    null,
                    LocalDateTime.now()
                )
            )
        }
        Thread(r).start()
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTheme {
        Greeting("Android")
    }
}