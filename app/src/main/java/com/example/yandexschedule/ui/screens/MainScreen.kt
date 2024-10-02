package com.example.yandexschedule.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import com.example.domain.model.Schedule
import com.example.domain.model.Segments
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
    vm.schedule.observe(owner) {
        schedule.value = it
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(paddingValues),
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(top = 60.dp)
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
        ) {
            items(schedule.value.segments){
                SegmentItem(it)
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = from.value,
                onValueChange = {
                    from.value = it
                },
                label = {
                    Text(text = "Откуда")
                }
            )

            OutlinedTextField(
                value = where.value,
                onValueChange = {
                    where.value = it
                },
                label = {
                    Text(text = "Куда")
                }
            )

            Button(onClick = {
                vm.getSchedule(from = from.value, to = where.value)
            }) {
                Text(text = "Найти")
            }

        }
    }
}
@Composable
fun SegmentItem(
    segment: Segments = Segments()
) {
    Row (
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Column (
            modifier = Modifier.fillMaxWidth(0.4f)
        ){
            Text(text = segment.thread?.title.toString(), maxLines = 3)
            val subtype = segment.thread?.transportSubtype
            if (subtype?.title != null) {
                Text(text = subtype.title!!, maxLines = 1)
            }
            Text(text = segment.startDate.toString(), fontSize = 12.sp, color = Color.Gray)
        }

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column (
                modifier = Modifier.width(100.dp)
            ){
                Text(text = segment.departure?.takeLast(8)?.dropLast(3).toString(), fontSize = 20.sp)
                Text(text = segment.from?.title?.replace('-', ' ').toString(), maxLines = 2, fontSize = 12.sp)
                Text(text = segment.from?.stationTypeName.toString(), color = Color.Gray, fontSize = 12.sp)
            }
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                var duration = segment.duration
                if (duration != null) {
                    Text(text = "В пути:", fontSize = 10.sp, color = Color.Gray)
                    duration /= 60

                    Text(text = if (duration > 60) "${duration / 60}:${duration % 60}" else duration.toString())
                }
            }
            Column (
                modifier = Modifier.width(100.dp),
                horizontalAlignment = Alignment.End
            ){
                Text(text = segment.arrival?.takeLast(8)?.dropLast(3).toString(), fontSize = 20.sp)
                Text(text = segment.to?.title.toString(), maxLines = 2, textAlign = TextAlign.End, fontSize = 12.sp)
                Text(text = segment.to?.stationTypeName.toString(), color = Color.Gray, fontSize = 12.sp)
            }
        }

    }
}
