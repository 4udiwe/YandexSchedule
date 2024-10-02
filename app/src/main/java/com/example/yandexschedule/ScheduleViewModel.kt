package com.example.yandexschedule


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.domain.codemodel.Suggestions
import com.example.domain.model.Schedule
import com.example.domain.usecase.GetScheduleUseCase
import com.example.domain.usecase.GetSuggestionsUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ScheduleViewModel(
    private val getSchedule: GetScheduleUseCase,
    private val getSuggestions: GetSuggestionsUseCase
) : ViewModel() {

    private val innerSchedule = MutableLiveData<Schedule>()
    val schedule: LiveData<Schedule> = innerSchedule


    fun getSchedule(from: String, to: String) = viewModelScope.launch {
        val fromCodeSuggestions = viewModelScope.async { getStationSuggests(city = from)}
        val toCodeSuggestions = viewModelScope.async { getStationSuggests(city = to)}

        val fromCodeResult = fromCodeSuggestions.await()
        val toCodeResult = toCodeSuggestions.await()
        if (fromCodeResult.totalFound != 0 && toCodeResult.totalFound != 0) {
            innerSchedule.value = getSchedule.invoke(
                fromCode = fromCodeResult.suggests[0].pointKey!!,
                toCode = toCodeResult.suggests[0].pointKey!!
            )
        } else {
            Log.d("RRR", "не нашел код")
        }
    }
    private suspend fun getStationSuggests(city: String): Suggestions {
        return getSuggestions.invoke(city = city)
    }
}