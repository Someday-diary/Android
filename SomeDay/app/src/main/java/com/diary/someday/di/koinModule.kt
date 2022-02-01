package com.diary.someday.di

import com.diary.someday.model.db.SearchDatabase
import com.diary.someday.model.network.RetrofitClient
import com.diary.someday.model.network.dao.DiaryService
import com.diary.someday.model.network.dao.UserService
import com.diary.someday.model.network.util.Constants.API
import com.diary.someday.model.repository.DiaryRepository
import com.diary.someday.model.repository.FeedbackRepository
import com.diary.someday.viewModel.DiaryViewModel
import com.diary.someday.viewModel.FeedbackViewModel
import com.diary.someday.viewModel.SearchViewModel
import com.diary.someday.viewModel.repository.SearchRepository
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.create

val serviceModule = module {
    single {
        RetrofitClient.getClient(API.BASE_URL)?.create(UserService::class.java)
    }
    single {
        RetrofitClient.getClient(API.BASE_URL)?.create(DiaryService::class.java)
    }
}

val roomModule = module {
    single {
        SearchDatabase.getDatabase(androidContext())
    }
    single {
        SearchRepository(get())
    }
    viewModel {
        SearchViewModel(get())
    }
}

val repositoryModule = module {
    single {
        FeedbackRepository(get())
    }
    single {
        DiaryRepository(get())
    }
}

val viewModelModule = module {
    viewModel {
        FeedbackViewModel(get())
    }
    viewModel {
        DiaryViewModel(get())
    }
}