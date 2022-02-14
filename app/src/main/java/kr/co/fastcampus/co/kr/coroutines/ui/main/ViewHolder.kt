package kr.co.fastcampus.co.kr.coroutines.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kr.co.fastcampus.co.kr.coroutines.R
import kr.co.fastcampus.co.kr.coroutines.databinding.ImageSearchItemBinding
import kr.co.fastcampus.co.kr.coroutines.model.Item

class ImageSearchViewHolder(
    private val like: (Item) -> Unit,
    private val binding: ImageSearchItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Item?) {
        TODO("이미지 불러오기를 구현해야합니다.")
    }

    companion object {
        fun create(
            like: (Item) -> Unit,
            parent: ViewGroup
        ): ImageSearchViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.image_search_item, parent, false)
            val binding = ImageSearchItemBinding.bind(view)
            return ImageSearchViewHolder(like, binding)
        }
    }
}