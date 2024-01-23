package com.josealfonsomora.dondeestanmispilas

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import coil.compose.AsyncImage
import com.josealfonsomora.dondeestanmispilas.theme.DondeEstanMisPilasTheme

class Activity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DondeEstanMisPilasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Text(text ="Activity 3")
                    if(isSystemInDarkTheme()){
                        Text(text = "Dark theme", color = Color(148, 148, 148, 255))
                    } else {
                        Text(text = "Light theme", color = Color(148, 148, 148, 255))
                    }
                    AsyncImage(
                        model = "https://picsum.photos/200/300",
                        contentDescription = null,
                        modifier = Modifier.clickable {
                            Intent(this, Activity2::class.java).also {
                                startActivity(it)
                            }
                        }
                        )
                }
                Log.d("Testing", "onCreate: "  )
                Log.i("Testing", "onCreate: "  )
                Log.w("Testing", "onCreate: "  )
                Log.e("Testing", "onCreate: "  )
                Log.v("Testing", "onCreate: "  )
            }
        }
    }
}

