package com.example.domain.usecase

import com.example.domain.model.Schedule
import com.example.domain.repository.ScheduleRepository

class GetScheduleUseCase (
    private val repository: ScheduleRepository
){
    suspend fun invoke(): Schedule {
        return repository.getSchedule()
    }

}