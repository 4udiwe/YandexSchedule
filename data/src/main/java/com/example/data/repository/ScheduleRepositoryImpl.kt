package com.example.data.repository

import com.example.data.ScheduleAPI
import com.example.domain.model.Schedule
import com.example.domain.repository.ScheduleRepository

class ScheduleRepositoryImpl(
    private val api : ScheduleAPI
) : ScheduleRepository {
    override suspend fun getSchedule(): Schedule {
        return api.get().toDomain()
    }

}