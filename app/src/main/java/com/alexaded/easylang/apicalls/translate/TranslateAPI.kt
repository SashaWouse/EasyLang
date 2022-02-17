package com.alexaded.easylang.apicalls.translate

import androidx.room.vo.Field
import com.alexaded.easylang.BuildConfig
import com.alexaded.easylang.models.TranslationResult
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface TranslateAPI {

    @FormUrlEncoded
    @POST("v2?key=${BuildConfig.TRANSLATE_API_KEY}")
    suspend fun translateText(
        @Field("q") textToTranslate: String,
        @Field("source") sourceLang: String,
        @Field("target") targetLang: String
    ): TranslationResult

}