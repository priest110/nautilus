package com.example.nautilus.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nautilus.R

/**
 * Composable that raises awareness about the water consumption depending on the amount
 * water consumed
 */
@Composable
fun InfoScreen(
    total: Int,
    messages: List<Pair<Int, Int>>,
    modifier: Modifier = Modifier
) {
    // Reusable strings and images
    val water_amount = stringResource(id = R.string.water_amount)
    val messagesConsideringTotal: List<Pair<Int, Int>> = messages.map { Pair(it.first, total/it.second) }
    val background = painterResource(id = R.drawable.total_liters)

    Box {
        // Background
        Image(
            painter = background,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxSize()
        )

        Row(
            modifier = modifier
                .fillMaxSize()
        ) {

            Column(
                modifier = Modifier.weight(1f).fillMaxHeight().padding(8.dp)
            ) {
                Row(
                    modifier = Modifier.weight(1f).fillMaxWidth()
                ) {
                    Column {
                        Box(
                            modifier = Modifier.weight(1f).fillMaxWidth().padding(8.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(8.dp),
                                verticalArrangement = Arrangement.Center, // Aligns content vertically
                                horizontalAlignment = Alignment.CenterHorizontally, // Aligns content horizontally
                            ) {
                                Text(
                                    text = "O necessário para",
                                    color = Color.White,
                                    textAlign = TextAlign.Center
                                )

                                Text(
                                    text = "${messagesConsideringTotal[0].second} ${stringResource(id = messagesConsideringTotal[0].first)}",
                                    color = Color.White,
                                    fontSize = 30.sp,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .padding(8.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(8.dp),
                                verticalArrangement = Arrangement.Center, // Aligns content vertically
                                horizontalAlignment = Alignment.CenterHorizontally, // Aligns content horizontally
                            ) {
                                Text(
                                    text = "O necessário para",
                                    color = Color.White,
                                    textAlign = TextAlign.Center
                                )

                                Text(
                                    text = "${messagesConsideringTotal[1].second} ${stringResource(id = messagesConsideringTotal[1].first)}",
                                    color = Color.White,
                                    fontSize = 30.sp,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }
            }

            Column(
                modifier = Modifier.weight(1f).fillMaxHeight().padding(8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.weight(1f).fillMaxWidth()
                ) {
                    Column {
                        Box(
                            modifier = Modifier.weight(1f).fillMaxWidth().padding(8.dp)
                        ) {
                            Text(
                                text = "Sabias que?",
                                color = Color.White,
                                fontSize = 50.sp,
                                modifier = Modifier.align(Alignment.Center),
                                textAlign = TextAlign.Center
                            )
                        }
                        Box(
                            modifier = Modifier.weight(1f).fillMaxWidth().padding(8.dp)
                        ) {
                            Text(
                                text = "$water_amount $total litros",
                                color = Color.White,
                                fontSize = 30.sp,
                                modifier = Modifier.align(Alignment.Center),
                                textAlign = TextAlign.Center
                            )
                        }
                        Box(
                            modifier = Modifier.weight(1f).fillMaxWidth().padding(8.dp)
                        ) {
                        }
                    }
                }
            }

            Column(
                modifier = Modifier.weight(1f).fillMaxHeight().padding(8.dp)
            ) {
                Row(
                    modifier = Modifier.weight(1f).fillMaxWidth()
                ) {
                    Column {
                        Box(
                            modifier = Modifier.weight(1f).fillMaxWidth().padding(8.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(8.dp),
                                verticalArrangement = Arrangement.Center, // Aligns content vertically
                                horizontalAlignment = Alignment.CenterHorizontally, // Aligns content horizontally
                            ) {
                                Text(
                                    text = "O necessário para",
                                    color = Color.White,
                                    textAlign = TextAlign.Center
                                )

                                Text(
                                    text = "${messagesConsideringTotal[2].second} ${stringResource(id = messagesConsideringTotal[2].first)}",
                                    color = Color.White,
                                    fontSize = 30.sp,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .padding(8.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(8.dp),
                                verticalArrangement = Arrangement.Center, // Aligns content vertically
                                horizontalAlignment = Alignment.CenterHorizontally, // Aligns content horizontally
                            ) {
                                Text(
                                    text = "O necessário para",
                                    color = Color.White,
                                    textAlign = TextAlign.Center
                                )

                                Text(
                                    text = "${messagesConsideringTotal[3].second} ${stringResource(id = messagesConsideringTotal[3].first)}",
                                    color = Color.White,
                                    fontSize = 30.sp,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}