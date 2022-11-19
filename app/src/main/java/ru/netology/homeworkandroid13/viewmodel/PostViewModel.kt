package ru.netology.homeworkandroid13.viewmodel

import androidx.lifecycle.ViewModel
import ru.netology.homeworkandroid13.repository.PostRepository
import ru.netology.homeworkandroid13.repository.PostRepositoryInMemoryImpl

class PostViewModel: ViewModel() {
    private val repository: PostRepository = PostRepositoryInMemoryImpl()
    val data = repository.get()
    fun like() = repository.like()
    fun share() = repository.share()
}
