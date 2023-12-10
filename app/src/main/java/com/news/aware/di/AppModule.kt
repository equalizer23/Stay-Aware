package com.news.aware.di

import com.news.aware.data.news_api.ApiClient
import com.news.aware.data.news_api.ApiRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    fun provideClient() : ApiClient = ApiClient()

    @Provides
    fun provideApiRepo(client: ApiClient): ApiRepoImpl = ApiRepoImpl(client)


}