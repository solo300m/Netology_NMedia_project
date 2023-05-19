package ru.netology.nmedia.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.CardPostBinding
import ru.netology.nmedia.dto.Post

typealias OnFunListener = (post:Post)->Unit
class PostAdapter(val likeCallback:OnFunListener,
                  val shareCallback:OnFunListener,
                  val viewCallback:OnFunListener):RecyclerView.Adapter<PostViewHolder>() {

    var list:List<Post> = emptyList()
        set(value) {
            field = value;
            notifyDataSetChanged();
        };

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = CardPostBinding.inflate(LayoutInflater.from(parent.context), parent, false);
        return PostViewHolder(view,likeCallback,shareCallback,viewCallback);
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = list[position];
        holder.bind(post)
    }

    override fun getItemCount() = list.size;

}

class PostViewHolder(private val binding: CardPostBinding,
                     val likeCallback:OnFunListener,
                    val shareCallback:OnFunListener,
                    val viewCallback:OnFunListener)
    : RecyclerView.ViewHolder(binding.root){
    fun bind(post: Post) {
        with(binding) {
            author.text = post.author
            published.text = post.published
            context.text = post.content
            likeButton.setImageResource(
                if (post.likedByMe) R.drawable.baseline_favorite_full_24 else R.drawable.is_baseline_favorite_border_24
            )
            like.text = Post.intToString(post.likes);
            shared.text = Post.intToString(post.shared);
            view.text = Post.intToString(post.view);

            likeButton.setOnClickListener {
               likeCallback(post);
            };

            sharedButton.setOnClickListener {
                shareCallback(post);

            };

            viewButton.setOnClickListener {
                viewCallback(post);

            }
        };
    }

}
