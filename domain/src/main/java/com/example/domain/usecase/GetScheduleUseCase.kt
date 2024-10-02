package com.example.domain.usecase

import com.example.domain.model.Schedule
import com.example.domain.repository.ScheduleRepository

class GetScheduleUseCase (
    private val repository: ScheduleRepository
){
    suspend fun invoke(fromCode: String, toCode: String, transport: String = "", date: String = ""): Schedule {
        return repository.getSchedule(fromCode = fromCode, toCode = toCode, transport = transport, date = date)
    }
}