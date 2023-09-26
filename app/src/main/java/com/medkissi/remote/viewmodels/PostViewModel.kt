package com.medkissi.remote.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.medkissi.remote.data.model.Photo
import com.medkissi.remote.data.model.Post
import com.medkissi.remote.data.repository.PostRepository
import com.medkissi.remote.ui.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class PostViewModel : ViewModel() {
    private val repository = PostRepository()

    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> = _posts
    private val _state = MutableLiveData<Resource<List<Photo>>>()
    val state: LiveData<Resource<List<Photo>>> = _state

    init {
        getData()
    }

    fun getData() = liveData(Dispatchers.IO) {
        emit(Resource.Loading(data = null))
        try {
            emit(Resource.Success(data = repository.getAllPhotos()))
        } catch (e: Exception) {
            emit(Resource.Error(data = null, message = "Error"))
        }
    }

}