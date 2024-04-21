package com.example.tugasppb7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.tugasppb7.ui.theme.Tugasppb7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tugasppb7Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xffafd6f0)
                ) {

                    var usedWaterAmount by remember {
                        mutableStateOf(0)
                    }
                    val totalWaterAmount = remember {
                        2500
                    }
                    var waterPercentages = remember {
                        mutableStateOf(0)
                    }
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        WaterBottle(
                            totalWaterAmount = totalWaterAmount,
                            unit = "ml",
                            usedWaterAmount = usedWaterAmount,
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = "Total Amount is : $totalWaterAmount",
                            textAlign = TextAlign.Center
                        )
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Button(
                                onClick = { usedWaterAmount += 250 },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xff279EFF)
                                )
                            ) {
                                Text(text = "Drink")
                            }
                            Button(
                                onClick = { usedWaterAmount = 0 },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xff22649B)
                                )
                            ) {
                                Text(text = "Reset")
                            }
                        }
                    }


                }
            }
        }
    }
}
