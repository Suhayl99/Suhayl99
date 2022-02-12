package uz.itech.myapplication.di.model

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.itech.myapplication.api.Api
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideOKHttpClient():OkHttpClient{
        val okHttpClient= OkHttpClient.Builder()
        return okHttpClient.build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient):Retrofit{
        return Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .client(client).addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit):Api{
        return retrofit.create(Api::class.java)
    }
}