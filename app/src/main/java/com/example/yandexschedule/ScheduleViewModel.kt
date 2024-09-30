package com.example.yandexschedule

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Schedule
import com.example.domain.usecase.GetScheduleUseCase
import kotlinx.coroutines.launch

class ScheduleViewModel(
    private val getSchedule: GetScheduleUseCase
) : ViewModel(){

    private val innerSchedule = MutableLiveData<Schedule>()
    val schedule: LiveData<Schedule> = innerSchedule


    init {
        viewModelScope.launch {
            innerSchedule.value = getSchedule.invoke()
            Log.d("RRR", schedule.value.toString())
        }
    }
}