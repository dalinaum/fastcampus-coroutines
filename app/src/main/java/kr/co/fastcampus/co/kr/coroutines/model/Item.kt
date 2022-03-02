package kr.co.fastcampus.co.kr.coroutines.model

import com.google.gson.annotations.SerializedName

data class Item(
    val title: String,
    val link: String,
    val thumbnail: String,
    @SerializedName("sizeheight") val sizeHeight: Int,
    @SerializedName("sizewidth") val sizeWidth: Int
)