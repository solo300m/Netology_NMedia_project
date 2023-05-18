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
                like.text = post.intToString(post.likes);
                shared.text = post.intToString(post.shared);
                view.text = post.intToString(post.view);


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
//        var post = Post(
//            id = 1,
//            author = "Нетология. Университет интернет-профессий",
//            published = "21 мая в 18:30",
//            content = "Привет, это новая Нетология! Когда-то " +
//                    "Нетология насиналась с интенсивов по онлайн-маркетингу. " +
//                    "Затем появились курсы по дизайну, разработке аналитике и управлению. " +
//                    "Мы растем сами и помогаем расти студентам: от новичков до уверенных профессионалов. " +
//                    "Но самое важное остается с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, " +
//                    "целиться выше, бежать быстрее. Наша миссия - помочь встать на путь роста и начать цепочку перемен - " +
//                    "https://netology.gy/fyb.",
//            likes = 999999,
//            likedByMe = false,
//            shared = 999,
//            view = 999999
//        );
//        with(binding) {
//            author.text = post.author;
//            published.text = post.published;
//            context.text = post.content;
//            if (post.likedByMe) {
//                likeButton?.setImageResource(R.drawable.baseline_favorite_full_24);
//            } else {
//                likeButton?.setImageResource(R.drawable.is_baseline_favorite_border_24);
//            }
//            like.text = post.intToString(post.likes);
//            shared.text = post.intToString(post.shared);
//            view.text = post.intToString(post.view);
//
//            likeButton.setOnClickListener {
//                post.likedByMe = !post.likedByMe;
//                likeButton.setImageResource(
//                    if (post.likedByMe) R.drawable.baseline_favorite_full_24 else R.drawable.is_baseline_favorite_border_24
//                )
//                if (post.likedByMe) post.likes++ else post.likes--
//                // like.text = post.likes.toString();
//                like.text = post.intToString(post.likes);
//            };
//
//            sharedButton.setOnClickListener{
//                post.shared++;
//                shared.text = post.intToString(post.shared);
//            };
//
//            viewButton.setOnClickListener{
//                post.view++;
//                view.text = post.intToString(post.view);
//            };
//        };
    };
};
