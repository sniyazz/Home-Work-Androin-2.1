package ru.netology.homeworkandroid13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.viewbinding.ViewBinding
import androidx.viewbinding.ViewBindings
import ru.netology.homeworkandroid13.databinding.ActivityMainBinding
import ru.netology.homeworkandroid13.dto.CountService
import ru.netology.homeworkandroid13.dto.Post

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.root.setOnClickListener { println("root") }
        binding.imageViewNonLike.setOnClickListener { println("like") }

        val post = Post(
            id = 1,
            autor = "Нетология. Меняем карьеру через образование",
            published = "30 октября 2022",
            content = "Если вы умеете находить баги в играх, выводить «Hello, world» в консоли, бэкапить резервные копии, то вы уже немного разработчик. Попробуйте себя в профессии 7 ноября в 19:00 на бесплатном занятии «Что нужно уметь разработчику».  На лекции рассказываем: · как изменился рынок труда в IT, · почему спрос на разработчиков продолжает стремительно расти, · какие направления востребованы в 2022 году.  Присоединяйтесь: https://netolo.gy/kQT",
            likedByMe = false,
            likes = 1099,
            share = 999
        )

        with(binding){
            textViewHeader.text = post.autor
            textViewPublishDate.text = post.published
            textViewPostText.text = post.content
            if (post.likedByMe){
                binding.imageViewNonLike.setImageResource(R.drawable.like_red)
            }
            textViewLikeCount.text = CountService.countServise(post.likes)
            imageViewNonLike.setOnClickListener {
                if (post.likedByMe) post.likes-- else post.likes++
                post.likedByMe = !post.likedByMe
                imageViewNonLike.setImageResource(if (post.likedByMe) R.drawable.like_red else R.drawable.ic_baseline_favorite_border_24)
                textViewLikeCount.text = CountService.countServise(post.likes)
            }
            textViewShareCount.text = CountService.countServise(post.share)
            imageViewShare.setOnClickListener {
                post.share++
                textViewShareCount.text = CountService.countServise(post.share)
            }
        }
    }
}
