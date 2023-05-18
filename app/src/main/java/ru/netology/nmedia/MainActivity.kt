package ru.netology.nmedia

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.Post

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);


        var post = Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий",
            published = "21 мая в 18:30",
            content = "Привет, это новая Нетология! Когда-то " +
                    "Нетология насиналась с интенсивов по онлайн-маркетингу. " +
                    "Затем появились курсы по дизайну, разработке аналитике и управлению. " +
                    "Мы растем сами и помогаем расти студентам: от новичков до уверенных профессионалов. " +
                    "Но самое важное остается с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, " +
                    "целиться выше, бежать быстрее. Наша миссия - помочь встать на путь роста и начать цепочку перемен - " +
                    "https://netology.gy/fyb.",
            likes = 9999,
            likedByMe = false,
            shared = 999,
            view = 999999
        );
        with(binding) {
            author.text = post.author;
            published.text = post.published;
            context.text = post.content;
            if (post.likedByMe) {
                likeButton?.setImageResource(R.drawable.baseline_favorite_full_24);
            } else {
                likeButton?.setImageResource(R.drawable.is_baseline_favorite_border_24);
            }
            like.text = Post.intToString(post.likes);
            shared.text = Post.intToString(post.shared);
            view.text = Post.intToString(post.view);

            likeButton.setOnClickListener {
                post.likedByMe = !post.likedByMe;
                likeButton.setImageResource(
                    if (post.likedByMe) R.drawable.baseline_favorite_full_24 else R.drawable.is_baseline_favorite_border_24
                )
                if (post.likedByMe) post.likes++ else post.likes--
                // like.text = post.likes.toString();
                like.text = Post.intToString(post.likes);
            };

            sharedButton.setOnClickListener{
                post.shared++;
                shared.text = Post.intToString(post.shared);
            };

            viewButton.setOnClickListener{
                post.view++;
                view.text = Post.intToString(post.view);
            };
        };
    };
};
