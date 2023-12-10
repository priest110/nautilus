package com.example.nautilus.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nautilus.R
import com.example.nautilus.ui.theme.CustomBlue
import com.example.nautilus.ui.theme.CustomDarkBlue
import kotlin.math.roundToInt

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
    val messagesConsideringTotal: List<Pair<Int, Double>> = messages.map { Pair(it.first, (total.toDouble()/it.second.toDouble() * 100.0).roundToInt() / 100.0) }
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
                                    .padding(top = 70.dp, bottom = 70.dp)
                                    .clip(shape = RoundedCornerShape(20.dp))
                                    .background(color = CustomBlue,  shape = RoundedCornerShape(20.dp)),
                                verticalArrangement = Arrangement.Center, // Aligns content vertically
                                horizontalAlignment = Alignment.CenterHorizontally, // Aligns content horizontally
                            ) {
                                Text(
                                    text = "Necessário para",
                                    color = CustomDarkBlue,
                                    textAlign = TextAlign.Center
                                )

                                Text(
                                    text = "${messagesConsideringTotal[0].second} ${stringResource(id = messagesConsideringTotal[0].first)}",
                                    color = CustomDarkBlue,
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
                                    .padding(top = 70.dp, bottom = 70.dp)
                                    .clip(shape = RoundedCornerShape(20.dp))
                                    .background(color = CustomBlue,  shape = RoundedCornerShape(20.dp)),
                                verticalArrangement = Arrangement.Center, // Aligns content vertically
                                horizontalAlignment = Alignment.CenterHorizontally, // Aligns content horizontally
                            ) {
                                Text(
                                    modifier = Modifier
                                        .background(color = CustomBlue),
                                    text = "Necessário para",
                                    color = CustomDarkBlue,
                                    textAlign = TextAlign.Center
                                )

                                Text(
                                    modifier = Modifier
                                        .background(color = CustomBlue),
                                    text = "${messagesConsideringTotal[1].second} ${stringResource(id = messagesConsideringTotal[1].first)}",
                                    color = CustomDarkBlue,
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
                                color = CustomBlue,
                                fontSize = 45.sp,
                                modifier = Modifier.align(Alignment.TopCenter),
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
                                lineHeight = 40.sp,
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
                                    .padding(top = 70.dp, bottom = 70.dp)
                                    .clip(shape = RoundedCornerShape(20.dp))
                                    .background(color = CustomBlue,  shape = RoundedCornerShape(20.dp)),
                                verticalArrangement = Arrangement.Center, // Aligns content vertically
                                horizontalAlignment = Alignment.CenterHorizontally, // Aligns content horizontally
                            ) {
                                Text(
                                    text = "Necessário para",
                                    color = CustomDarkBlue,
                                    textAlign = TextAlign.Center
                                )

                                Text(
                                    text = "${messagesConsideringTotal[2].second} ${stringResource(id = messagesConsideringTotal[2].first)}",
                                    color = CustomDarkBlue,
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
                                    .padding(top = 70.dp, bottom = 70.dp)
                                    .clip(shape = RoundedCornerShape(20.dp))
                                    .background(color = CustomBlue,  shape = RoundedCornerShape(20.dp)),
                                verticalArrangement = Arrangement.Center, // Aligns content vertically
                                horizontalAlignment = Alignment.CenterHorizontally, // Aligns content horizontally
                            ) {
                                Text(
                                    text = "Necessário para",
                                    color = CustomDarkBlue,
                                    textAlign = TextAlign.Center
                                )

                                Text(
                                    text = "${messagesConsideringTotal[3].second} ${stringResource(id = messagesConsideringTotal[3].first)}",
                                    color = CustomDarkBlue,
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