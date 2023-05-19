package ru.netology.nmedia.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ru.netology.nmedia.R
import ru.netology.nmedia.adapter.PostAdapter
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.databinding.CardPostBinding
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.viewModel.PostViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        val viewModel by viewModels<PostViewModel>()

        val adapter = PostAdapter({viewModel.likeById(it.id)},{viewModel.shareById(it.id)},{viewModel.viewById(it.id)});
        binding.list.adapter = adapter;

        viewModel.data.observe(this) { posts ->
            adapter.submitList(posts);
        }
    };
};
