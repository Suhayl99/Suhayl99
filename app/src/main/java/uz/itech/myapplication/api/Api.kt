package uz.itech.myapplication.api

import android.telecom.Call
import retrofit2.http.GET
import uz.itech.myapplication.model.PhotoModel
import uz.itech.myapplication.model.PostModel

interface Api {
    @GET("posts")
    fun getPosts(): retrofit2.Call<List<PostModel>>

    @GET("photos")
    fun getPhotos():retrofit2.Call<List<PhotoModel>>
}