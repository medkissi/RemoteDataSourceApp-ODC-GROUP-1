package com.medkissi.remote.data.repository

import com.medkissi.remote.data.model.Photo
import com.medkissi.remote.data.model.Post
import com.medkissi.remote.data.remotedatasource.ApiService
import com.medkissi.remote.ui.Resource
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostRepository {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service =  retrofit.create(ApiService::class.java)

   suspend fun getAllPosts(): List<Post> {
        return service.getAllPosts()
    }

    suspend fun  getAllPhotos():List<Photo>{
        return service.getAllPhotos()

    }

}