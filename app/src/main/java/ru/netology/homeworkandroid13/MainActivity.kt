package ru.netology.homeworkandroid13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ru.netology.homeworkandroid13.databinding.ActivityMainBinding
import ru.netology.homeworkandroid13.dto.CountService
import ru.netology.homeworkandroid13.viewmodel.PostViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()

        viewModel.data.observe(this) { post ->
            with(binding) {
                textViewHeader.text = post.autor
                textViewPublishDate.text = post.published
                textViewPostText.text = post.content
                imageViewNonLike.setImageResource(if (post.likedByMe) R.drawable.like_red else R.drawable.ic_baseline_favorite_border_24)
                textViewLikeCount.text = CountService.countServise(post.likes)
                textViewShareCount.text = CountService.countServise(post.share)
            }
        }

        binding.imageViewNonLike.setOnClickListener {
            viewModel.like()
        }
        binding.imageViewShare.setOnClickListener {
            viewModel.share()
        }
    }
}
