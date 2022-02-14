package kr.co.fastcampus.co.kr.coroutines.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.co.fastcampus.co.kr.coroutines.api.NaverImageSearchService
import kr.co.fastcampus.co.kr.coroutines.model.Item
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NaverImageSearchRepository {
    private val service: NaverImageSearchService

    init {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BASIC

        val client = OkHttpClient.Builder()
            .addInterceptor { chain ->
                TODO("헤더를 추가해야합니다.")
                val request = chain.request().newBuilder()
                    .build()
                chain.proceed(request)
            }
            .addInterceptor(logger)
            .build()

        service = Retrofit.Builder()
            .baseUrl("https://openapi.naver.com")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NaverImageSearchService::class.java)
    }

    fun getImageSearch(query: String): Flow<PagingData<Item>> {
        return Pager(
            config = PagingConfig(
                pageSize = NaverImageSearchDataSource.defaultDisplay,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                NaverImageSearchDataSource(query, service)
            }
        ).flow
    }
}