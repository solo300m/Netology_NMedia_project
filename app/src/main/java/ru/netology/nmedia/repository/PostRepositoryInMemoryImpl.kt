package ru.netology.nmedia.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.dto.Post

class PostRepositoryInMemoryImpl:PostRepository {
    private var posts = listOf(
        Post(
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
        ),
        Post(
            id = 2,
            author = "Компьютеры - это. ",
            published = "21 апреля в 19:00",
            content = "Компьютер - великое изобретение человека, " +
                    "с помощью которого можно сделать что угодно, начиная с " +
                    "решения различных примеров и заканчивая созданием профессиональных " +
                    "программ, которые в дальнейшем помогут самому человеку. Но так было не всегда. " +
                    "Упоминания о первых вычислительных машинах было ещё до нашей эры, однако, первый " +
                    "современный компьютер был создан только в середине XX века немецким инженером Конрадом Цузе. " +
                    "Вид такой компьютер имел отвратительный, как будто перед тобой большая коробка, да и функционал " +
                    "он имел не большой. Главными компонентами такого компьютера в основном были монитор и блок питания. ",
            likes = 9,
            likedByMe = false,
            shared = 99,
            view = 999
        ),
        Post(
            id = 3,
            author = "Монитор - это. ",
            published = "21 апреля в 19:00",
            content = "Монитор (англ. monitor) – это аппаратное устройство которые " +
                    "состоит из жесткого корпуса и экрана (дисплея). Монитор служит " +
                    "для вывода текстовой или графической информации на дисплей." +
                      "Как и большенство ранних телевизоров, первые мониторы " +
                    "компьютера имели ЭЛТ (электронно-лучевую трубку). " +
                    "Сегодня ЭЛТ-монитор заменен на новые ЖК мониторы, так тот, " +
                    "что показан на изображении справа.",
            likes = 119,
            likedByMe = false,
            shared = 199,
            view = 11999
        ),

    );
    private val data = MutableLiveData(posts);

    override fun getAll(): LiveData<List<Post>> = data;

    override fun likeById(id:Long) {
       posts = posts.map {
           (if(it.id != id) it
           else if(it.id == id && !it.likedByMe) it.copy(likedByMe = !it.likedByMe, likes = it.likes + 1)
           else if(it.id == id && it.likedByMe) it.copy(likedByMe = !it.likedByMe, likes = it.likes - 1)
           else null ) as Post
       };
        data.value = posts;
    }

    override fun shareById(id:Long) {
        posts = posts.map {
            if(it.id != id) it else it.copy(shared = it.shared + 1)
        };
        data.value = posts;
    }

    override fun viewById(id:Long) {
        posts = posts.map {
            if(it.id != id) it else it.copy(view = it.view + 1)
        };
        data.value = posts;
    }
}
