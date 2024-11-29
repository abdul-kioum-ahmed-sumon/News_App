package com.example.news_app.models
data class Source(
    val id: String? = null,
    val name: String? = null
) {
    override fun hashCode(): Int {
        return id?.hashCode() ?: 0 * 31 + (name?.hashCode() ?: 0)
    }
}
