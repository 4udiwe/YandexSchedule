package com.example.domain.repository

import com.example.domain.model.Schedule

interface ScheduleRepository {
    suspend fun getSchedule() : Schedule
}