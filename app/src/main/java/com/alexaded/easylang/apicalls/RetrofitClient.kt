package com.alexaded.easylang.apicalls

import com.alexaded.easylang.apicalls.translate.TranslateAPI
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClient {

    private const val BASE_URL_TRANSLATE_API =
        "https://translate.yandex.net/api/v1.5/tr.json/translate"
    private var translateApiClient: Retrofit? = null
    val translateApi: TranslateAPI = getTranslateApiClient().create(TranslateAPI::class.java)

    private fun getTranslateApiClient(): Retrofit {
        if (translateApiClient === null) {
            translateApiClient = Retrofit.Builder()
                .baseUrl(BASE_URL_TRANSLATE_API)
                .addConverterFactory(MoshiConverterFactory.create())
                .client(getOkHttpClient())
                .build()
        }
        return translateApiClient!!
    }

    private fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                var request = chain.request()
                request = request.newBuilder().build()
                chain.proceed(request)
            }
            .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }
}