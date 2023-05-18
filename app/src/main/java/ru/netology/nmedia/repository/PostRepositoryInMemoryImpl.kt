package ru.netology.nmedia.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.dto.Post

class PostRepositoryInMemoryImpl:PostRepository {
    private var post = Post(
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
        likes = 999999,
        likedByMe = false,
        shared = 999,
        view = 999999
    );
    private val data = MutableLiveData(post);

    override fun get(): LiveData<Post> = data;

    override fun like() {
       post = post.copy(likedByMe = !post.likedByMe, likes = if(post.likedByMe) post.likes - 1 else post.likes + 1);
        data.value = post;
    }

    override fun share() {
        post = post.copy(shared = post.shared + 1);
        data.value = post;
    }

    override fun view() {
        post = post.copy(view = post.view + 1);
        data.value = post;
    }
}
