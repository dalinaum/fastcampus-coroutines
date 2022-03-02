package kr.co.fastcampus.co.kr.coroutines.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kr.co.fastcampus.co.kr.coroutines.api.NaverImageSearchService
import kr.co.fastcampus.co.kr.coroutines.model.Item
import java.lang.Exception

class NaverImageSearchDataSource(
    private val query: String,
    private val imageSearchService: NaverImageSearchService
) : PagingSource<Int, Item>() {
    override fun getRefreshKey(state: PagingState<Int, Item>): Int? {
        return state.anchorPosition?.let {
            val closestPageToPosition = state.closestPageToPosition(it)
            closestPageToPosition?.prevKey?.plus(defaultDisplay)
                ?: closestPageToPosition?.nextKey?.minus(defaultDisplay)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {
        val start = params.key ?: defaultStart

        return try {
            val response = imageSearchService.getImages(query, params.loadSize, start)

            val items = response.items
            val nextKey = if (items.isEmpty()) {
                null
            } else {
                start + params.loadSize
            }
            val prevKey = if (start == defaultStart) {
                null
            } else {
                start - defaultDisplay
            }
            LoadResult.Page(items, prevKey, nextKey)
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    companion object {
        const val defaultStart = 1
        const val defaultDisplay = 10
    }
}