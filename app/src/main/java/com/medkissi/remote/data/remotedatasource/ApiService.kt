package com.medkissi.remote.data.remotedatasource

import com.medkissi.remote.data.model.Photo
import com.medkissi.remote.data.model.Post
import com.medkissi.remote.ui.Resource
import retrofit2.http.GET

interface ApiService {
    @GET("posts/")
    suspend fun getAllPosts(): List<Post>

    @GET("photos/")
    suspend fun  getAllPhotos():List<Photo>
}