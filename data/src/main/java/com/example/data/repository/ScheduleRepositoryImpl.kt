package com.example.data.repository

import com.example.data.api.ScheduleAPI
import com.example.domain.model.Schedule
import com.example.domain.repository.ScheduleRepository

class ScheduleRepositoryImpl(
    private val api : ScheduleAPI
) : ScheduleRepository {
    override suspend fun getSchedule(fromCode: String, toCode: String): Schedule {
        return api.get(from = fromCode, to = toCode).toDomain()
    }

}