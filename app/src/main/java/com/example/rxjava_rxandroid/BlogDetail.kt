package com.example.rxjava_rxandroid

data class BlogDetail(
    val id: Long,
    val userId: Long,
    val title: String,
    val content: String,
    val user: User
)
