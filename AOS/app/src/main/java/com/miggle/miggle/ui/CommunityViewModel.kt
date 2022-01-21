package com.miggle.miggle.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miggle.miggle.model.Post
import com.miggle.miggle.server.PostNetwork
import kotlinx.coroutines.launch

class CommunityViewModel : ViewModel() {

    val singlePost: MutableLiveData<Post> = MutableLiveData()
    val postList: MutableLiveData<List<Post>> = MutableLiveData()
//    val userList: MutableLiveData<List<User>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            singlePost.value = PostNetwork.retrofit.getPost() // new Post(1,2,3,4)
        }
    }

    fun getPosts() {
        viewModelScope.launch {
            try{
                postList.value = PostNetwork.retrofit.getPosts()
            }catch(e: Exception ){
                Log.e("error", e.localizedMessage)
            }

        }
    }

    fun getUsers() {
        viewModelScope.launch {
//            postList.value = PostNetwork.retrofit.getUsers()
        }
    }
}