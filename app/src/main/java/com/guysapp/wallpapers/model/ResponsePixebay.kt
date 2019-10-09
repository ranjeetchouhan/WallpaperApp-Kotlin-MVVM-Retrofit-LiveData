package com.guysapp.wallpapers.model

data class ResponsePixebay(
    val hits: List<Hit>,
    val total: Int,
    val totalHits: Int
)