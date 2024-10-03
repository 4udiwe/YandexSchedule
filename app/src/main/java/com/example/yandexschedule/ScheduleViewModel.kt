package com.example.yandexschedule


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.codemodel.Suggestions
import com.example.domain.model.Schedule
import com.example.domain.usecase.GetScheduleUseCase
import com.example.domain.usecase.GetSuggestionsUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.util.Date

class ScheduleViewModel(
    private val getSchedule: GetScheduleUseCase,
    private val getSuggestions: GetSuggestionsUseCase
) : ViewModel() {

    private val innerSchedule = MutableLiveData<Schedule>()
    val schedule: LiveData<Schedule> = innerSchedule


    fun getSchedule(from: String, to: String, transportStateValue: List<Boolean>, dateStateValue: List<Boolean>, otherDate: String? = null) = viewModelScope.launch {
        val fromCodeSuggestions = viewModelScope.async { getStationSuggests(city = from)}
        val toCodeSuggestions = viewModelScope.async { getStationSuggests(city = to)}

        val transport: String =
        if (transportStateValue[0]) ""
        else if (transportStateValue[1]) "plane"
        else if (transportStateValue[2]) "water"
        else if (transportStateValue[3]) "train"
        else "bus"


        val searchDate =
            if (otherDate != null && dateStateValue[2])
                otherDate
            else {
                val stringDate = Date().toString()

                "${stringDate.takeLast(4)}-${
                    when (stringDate.substring(4, 7)) {
                        "Jan" -> "01"
                        "Feb" -> "02"
                        "Mar" -> "03"
                        "Apr" -> "04"
                        "May" -> "05"
                        "Jun" -> "06"
                        "Jul" -> "07"
                        "Aug" -> "08"
                        "Sep" -> "09"
                        "Oct" -> "10"
                        "Nov" -> "11"
                        "Dec" -> "12"
                        else -> "01"
                    }
                }-${
                    if (dateStateValue[1]) (stringDate.substring(8, 10)
                        .toInt() + 1).toString() else stringDate.substring(8, 10)
                }"
            }



        val fromCodeResult = fromCodeSuggestions.await()
        val toCodeResult = toCodeSuggestions.await()
        if (fromCodeResult.totalFound != 0 && toCodeResult.totalFound != 0) {
            innerSchedule.value = getSchedule.invoke(
                fromCode = fromCodeResult.suggests[0].pointKey!!,
                toCode = toCodeResult.suggests[0].pointKey!!,
                transport = transport,
                date = searchDate
            )
        } else {
            Log.d("RRR", "не нашел код")
        }
    }
    private suspend fun getStationSuggests(city: String): Suggestions {
        return getSuggestions.invoke(city = city)
    }
}