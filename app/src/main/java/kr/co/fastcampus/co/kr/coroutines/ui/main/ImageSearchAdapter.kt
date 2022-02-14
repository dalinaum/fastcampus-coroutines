package kr.co.fastcampus.co.kr.coroutines.ui.main

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import kr.co.fastcampus.co.kr.coroutines.model.Item

class ImageSearchAdapter(
    private val like: (Item) -> Unit
) : PagingDataAdapter<Item, ImageSearchViewHolder>(comparator) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageSearchViewHolder {
        return ImageSearchViewHolder.create(like, parent)
    }

    override fun onBindViewHolder(holder: ImageSearchViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    companion object {
        val comparator = object : DiffUtil.ItemCallback<Item>() {
            TODO("ItemCallback을 구현해야합니다.")
        }
    }
}