package com.wuhao.test.di

import android.content.Context
import com.google.gson.Gson
import com.wuhao.test.common.Constants
import com.wuhao.test.data.repository.LocalData
import com.wuhao.test.data.repository.PostRepositoryImpl
import com.wuhao.test.data.repository.RetrofitService
import com.wuhao.test.domain.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalRepository(@ApplicationContext context: Context, gson: Gson): LocalData {
        return LocalData(context, gson)
    }

    @Provides
    @Singleton
    fun provideRetrofitService(): RetrofitService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitService::class.java)
    }

    @Provides
    @Singleton
    fun providePostRepository(api: RetrofitService): PostRepository {
        return PostRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }
}