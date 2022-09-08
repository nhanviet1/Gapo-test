package com.example.newfeeds.detailmodel

data class DetailModel(
    val comments: List<Comment>,
    val content: String,
    val counts: CountsX,
    val create_time: Int,
    val id: String,
    val mediaData: List<MediaData>,
    val post_type: Int,
    val react_status: Int,
    val update_time: Int,
    val user: UserX,
    val user_id: Int
)