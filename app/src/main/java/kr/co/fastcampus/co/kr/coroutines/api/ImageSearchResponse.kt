package kr.co.fastcampus.co.kr.coroutines.api

import kr.co.fastcampus.co.kr.coroutines.model.Item

data class ImageSearchResponse(
    val lastBuildDate: String,
    val total: Int,
    val start: Int,
    val display: Int,
    val items: List<Item>
)