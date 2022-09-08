package com.example.newfeeds.model

data class MediaData(
    val available_format: AvailableFormat,
    val duration: String,
    val height: Int,
    val image_id: String,
    val path: String,
    val src: String,
    val store: String,
    val thumb: Thumb,
    val thumb_pattern: String,
    val type: String,
    val video_id: String,
    val width: Int
)