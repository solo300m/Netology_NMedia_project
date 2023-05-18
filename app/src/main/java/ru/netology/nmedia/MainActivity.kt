package ru.netology.nmedia

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.activity.viewModels
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.viewModel.PostViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        val viewModel by viewModels<PostViewModel>()
        viewModel.data.observe(this) { post ->
            with(binding){
                author.text = post.author
                published.text = post.published
                context.text = post.content
                likeButton.setImageResource(
                    if(post.likedByMe) R.drawable.baseline_favorite_full_24 else R.drawable.is_baseline_favorite_border_24
                )
                like.text = Post.intToString(post.likes);
                shared.text = Post.intToString(post.shared);
                view.text = Post.intToString(post.view);


            }
        }
        binding.likeButton.setOnClickListener {
           viewModel.like();
        };

        binding.sharedButton.setOnClickListener{
            viewModel.share();
            // shared.text = post.intToString(post.shared);
        };

        binding.viewButton.setOnClickListener{
            viewModel.view();
            // view.text = post.intToString(post.view);
        };
        binding.likeButton.setOnClickListener{
            viewModel.like()
        }
    };
};
