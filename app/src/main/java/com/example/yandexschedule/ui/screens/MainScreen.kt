package com.example.yandexschedule.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import com.example.domain.model.Schedule
import com.example.domain.model.Segments
import com.example.yandexschedule.R
import com.example.yandexschedule.ScheduleViewModel


@Composable
fun MainScreen(
    vm: ScheduleViewModel,
    owner: LifecycleOwner,
    paddingValues: PaddingValues
) {
    val from = remember {
        mutableStateOf("")
    }
    val where = remember {
        mutableStateOf("")
    }
    val schedule = remember {
        mutableStateOf(Schedule())
    }
    vm.schedule.observe(owner) { schedule.value = it }

    val dateState = remember {
        mutableStateOf(listOf(true, false, false))
    }
    val transportState = remember {
        mutableStateOf(listOf(true, false, false, false, false))
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues).padding(horizontal = 4.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.65f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            when (schedule.value.pagination!!.total) {
                null -> {
                    item {
                        Text(text = "Найдите ваш маршрут", fontSize = 22.sp, color = Color.Gray)
                    }
                }
                0 -> {
                    item {
                        Text(text = "Ничего не найдено", fontSize = 22.sp, color = Color.Gray)
                    }
                }
                else -> {
                    items(schedule.value.segments) {
                        SegmentItem(it)
                    }
                }
            }
        }
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(0.85f),
                        value = from.value,
                        onValueChange = {
                            from.value = it
                        },
                        label = {
                            Text(text = "Откуда")
                        }
                    )
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(0.85f),
                        value = where.value,
                        onValueChange = {
                            where.value = it
                        },
                        label = {
                            Text(text = "Куда")
                        }
                    )
                }
                IconButton(onClick = {
                    val temp = from.value
                    from.value = where.value
                    where.value = temp
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.outline_sync_24),
                        contentDescription = "arrows",
                        Modifier.size(40.dp)
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(0.33f),
                    onClick = {
                        dateState.value = listOf(true, false, false)
                    },
                    colors =
                    if (dateState.value[0])
                        ButtonColors(
                            contentColor = Color.LightGray,
                            containerColor = Color.DarkGray,
                            disabledContentColor = Color.LightGray,
                            disabledContainerColor = Color.DarkGray,
                        )
                    else
                        ButtonColors(
                            contentColor = Color.DarkGray,
                            containerColor = Color.LightGray,
                            disabledContentColor = Color.DarkGray,
                            disabledContainerColor = Color.LightGray,
                        ),
                    shape = CutCornerShape(0.dp)
                ) {
                    Text(text = "Сегодня")
                }
                Button(
                    modifier = Modifier.fillMaxWidth(0.5f),
                    onClick = {
                        dateState.value = listOf(false, true, false)
                    },
                    colors =
                    if (dateState.value[1])
                        ButtonColors(
                            contentColor = Color.LightGray,
                            containerColor = Color.DarkGray,
                            disabledContentColor = Color.LightGray,
                            disabledContainerColor = Color.DarkGray,
                        )
                    else
                        ButtonColors(
                            contentColor = Color.DarkGray,
                            containerColor = Color.LightGray,
                            disabledContentColor = Color.DarkGray,
                            disabledContainerColor = Color.LightGray,
                        ),
                    shape = CutCornerShape(0.dp)
                ) {
                    Text(text = "Завтра")
                }
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        dateState.value = listOf(false, false, true)
                    },
                    colors =
                    if (dateState.value[2])
                        ButtonColors(
                            contentColor = Color.LightGray,
                            containerColor = Color.DarkGray,
                            disabledContentColor = Color.LightGray,
                            disabledContainerColor = Color.DarkGray,
                        )
                    else
                        ButtonColors(
                            contentColor = Color.DarkGray,
                            containerColor = Color.LightGray,
                            disabledContentColor = Color.DarkGray,
                            disabledContainerColor = Color.LightGray,
                        ),
                    shape = CutCornerShape(0.dp)
                ) {
                    Text(text = "Дата")
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        transportState.value = listOf(true, false, false, false, false)
                    },
                    colors =
                    if (transportState.value[0])
                        ButtonColors(
                            contentColor = Color.LightGray,
                            containerColor = Color.DarkGray,
                            disabledContentColor = Color.LightGray,
                            disabledContainerColor = Color.DarkGray,
                        )
                    else
                        ButtonColors(
                            contentColor = Color.DarkGray,
                            containerColor = Color.LightGray,
                            disabledContentColor = Color.DarkGray,
                            disabledContainerColor = Color.LightGray,
                        ),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(text = "Любой")
                }
                Button(
                    onClick = {
                        transportState.value = listOf(false, true, false, false, false)
                    },
                    colors =
                    if (transportState.value[1])
                        ButtonColors(
                            contentColor = Color.LightGray,
                            containerColor = Color.DarkGray,
                            disabledContentColor = Color.LightGray,
                            disabledContainerColor = Color.DarkGray,
                        )

                    else
                        ButtonColors(
                            contentColor = Color.DarkGray,
                            containerColor = Color.LightGray,
                            disabledContentColor = Color.DarkGray,
                            disabledContainerColor = Color.LightGray,
                        ),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_airplanemode_active_24),
                        contentDescription = "plane"
                    )
                }
                Button(
                    onClick = { transportState.value = listOf(false, false, true, false, false) },
                    colors =
                    if (transportState.value[2])
                        ButtonColors(
                            contentColor = Color.LightGray,
                            containerColor = Color.DarkGray,
                            disabledContentColor = Color.LightGray,
                            disabledContainerColor = Color.DarkGray,
                        )

                    else
                        ButtonColors(
                            contentColor = Color.DarkGray,
                            containerColor = Color.LightGray,
                            disabledContentColor = Color.DarkGray,
                            disabledContainerColor = Color.LightGray,
                        ),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_directions_boat_24),
                        contentDescription = "boat"
                    )
                }
                Button(
                    onClick = { transportState.value = listOf(false, false, false, true, false) },
                    colors =
                    if (transportState.value[3])
                        ButtonColors(
                            contentColor = Color.LightGray,
                            containerColor = Color.DarkGray,
                            disabledContentColor = Color.LightGray,
                            disabledContainerColor = Color.DarkGray,
                        )

                    else
                        ButtonColors(
                            contentColor = Color.DarkGray,
                            containerColor = Color.LightGray,
                            disabledContentColor = Color.DarkGray,
                            disabledContainerColor = Color.LightGray,
                        ),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_train_24),
                        contentDescription = "train"
                    )
                }
                Button(
                    onClick = { transportState.value = listOf(false, false, false, false, true) },
                    colors =
                    if (transportState.value[4])
                        ButtonColors(
                            contentColor = Color.LightGray,
                            containerColor = Color.DarkGray,
                            disabledContentColor = Color.LightGray,
                            disabledContainerColor = Color.DarkGray,
                        )

                    else
                        ButtonColors(
                            contentColor = Color.DarkGray,
                            containerColor = Color.LightGray,
                            disabledContentColor = Color.DarkGray,
                            disabledContainerColor = Color.LightGray,
                        ),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_directions_bus_24),
                        contentDescription = "bus"
                    )
                }
            }


            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    vm.getSchedule(
                        from = from.value,
                        to = where.value,
                        transportStateValue = transportState.value,
                        dateStateValue = dateState.value
                    )
                },
                shape = RoundedCornerShape(4.dp),
                colors = ButtonColors(
                    contentColor = Color.Black,
                    containerColor = Color(252, 200, 3),
                    disabledContentColor = Color.Black,
                    disabledContainerColor = Color(252, 200, 3),
                )
            ) {
                Text(text = "Найти", fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun SegmentItem(
    segment: Segments = Segments()
) {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(0.4f)
        ) {
            Text(text = segment.thread?.title.toString(), maxLines = 3)
            val subtype = segment.thread?.transportSubtype
            if (subtype?.title != null) {
                Text(text = subtype.title!!, maxLines = 1)
            }
            Text(text = segment.startDate.toString(), fontSize = 12.sp, color = Color.Gray)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.width(100.dp)
            ) {
                Text(
                    text = segment.departure?.takeLast(8)?.dropLast(3).toString(),
                    fontSize = 20.sp
                )
                Text(
                    text = segment.from?.title?.replace('-', ' ').toString(),
                    maxLines = 2,
                    fontSize = 12.sp
                )
                Text(
                    text = segment.from?.stationTypeName.toString(),
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var duration = segment.duration
                if (duration != null) {
                    Text(text = "В пути:", fontSize = 10.sp, color = Color.Gray)
                    duration /= 60

                    Text(text = if (duration > 60) "${duration / 60}:${duration % 60}" else duration.toString())
                }
            }
            Column(
                modifier = Modifier.width(100.dp),
                horizontalAlignment = Alignment.End
            ) {
                Text(text = segment.arrival?.takeLast(8)?.dropLast(3).toString(), fontSize = 20.sp)
                Text(
                    text = segment.to?.title.toString(),
                    maxLines = 2,
                    textAlign = TextAlign.End,
                    fontSize = 12.sp
                )
                Text(
                    text = segment.to?.stationTypeName.toString(),
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }
        }

    }
}
