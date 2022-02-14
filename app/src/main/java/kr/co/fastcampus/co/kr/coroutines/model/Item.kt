package kr.co.fastcampus.co.kr.coroutines.model

import com.google.gson.annotations.SerializedName

data class Item(
    val title: String,
    val link: String,
    val thumbnail: String,
    val sizeHeight: Int,
    val sizeWidth: Int
)
TODO("필드를 맞춰야 합니다.")