package ru.netology.homeworkandroid13.repository

import androidx.lifecycle.LiveData
import ru.netology.homeworkandroid13.dto.Post

interface PostRepository {
    fun get(): LiveData<Post>
    fun like()
}
