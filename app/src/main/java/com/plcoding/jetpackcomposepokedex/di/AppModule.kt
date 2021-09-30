package com.plcoding.jetpackcomposepokedex.di

import com.plcoding.jetpackcomposepokedex.data.PokeRepo
import com.plcoding.jetpackcomposepokedex.data.remote.PokedexApi
import com.plcoding.jetpackcomposepokedex.repository.PokeRepoImpl
import com.plcoding.jetpackcomposepokedex.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesOkhttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor())
            .build()
    }

    @Provides
    @Singleton
    fun providePokedexApi(client: OkHttpClient): PokedexApi {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(PokedexApi::class.java)
    }

    @Provides
    @Singleton
    fun providePokedexRepo(api: PokedexApi): PokeRepo {
        return PokeRepoImpl(api)
    }

}