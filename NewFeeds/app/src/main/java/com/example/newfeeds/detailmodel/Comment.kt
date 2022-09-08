package com.example.newfeeds.detailmodel

data class Comment(
    val comment_as: String,
    val content: String,
    val counts: Counts,
    val create_time: Int,
    val id: String,
    val mediaData: List<Any>,
    val parent_id: String,
    val post_id: String,
    val react_status: Int,
    val status: Int,
    val update_time: Any,
    val user: UserX
)