package com.alexaded.easylang.apicalls.translate

class TranslateRepository(private val api: TranslateAPI) {

    suspend fun translateText(text: String, sourceLang: String, targetLang: String): String =
        api.translateText(text, sourceLang, targetLang).data.translations[0].translatedText
}