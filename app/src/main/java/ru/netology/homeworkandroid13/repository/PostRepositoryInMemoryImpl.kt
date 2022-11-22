package ru.netology.homeworkandroid13.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.homeworkandroid13.dto.Post

class PostRepositoryInMemoryImpl : PostRepository {
    private var post = Post(
        id = 1,
        autor = "Нетология. Меняем карьеру через образование",
        published = "30 октября 2022",
        content = "Если вы умеете находить баги в играх, выводить «Hello, world» в консоли, бэкапить резервные копии, то вы уже немного разработчик. Попробуйте себя в профессии 7 ноября в 19:00 на бесплатном занятии «Что нужно уметь разработчику».  На лекции рассказываем: · как изменился рынок труда в IT, · почему спрос на разработчиков продолжает стремительно расти, · какие направления востребованы в 2022 году.  Присоединяйтесь: https://netolo.gy/kQT",
        likedByMe = false,
        likes = 1099,
        share = 995
    )

    private val data = MutableLiveData(post)

    override fun get(): LiveData<Post> = data
    override fun like() {
        post = post.copy(likedByMe = !post.likedByMe)
        if (post.likedByMe) {
            post = post.copy(likes = post.likes + 1)
        }else post = post.copy(likes = post.likes - 1)

        //post = post.copy(likedByMe = post.likedByMe)
        //if(!post.likedByMe) post = post.copy(likes = post.likes - 1)

        data.value = post
    }

    override fun share() {
        post = post.copy(share = post.share +1)
        //post = post.copy(share = post.share + 1)

        data.value = post
    }
}
