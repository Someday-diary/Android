package com.yademos.someday.db.repository

import androidx.annotation.WorkerThread
import com.yademos.someday.db.dao.DiaryDao
import com.yademos.someday.db.model.Diary
import java.util.*

class DiaryRepository(private val diaryDao: DiaryDao) {

    @WorkerThread
    suspend fun insertDiary(diary: Diary){
        diaryDao.insertDiary(diary)
    }

    @WorkerThread
    suspend fun deleteDiary(created_at: Date){
        diaryDao.deleteDiary(created_at)
    }

    @WorkerThread
    suspend fun getDiary(created_at: Date) : Diary {
        return diaryDao.getDiary(created_at)
    }
}