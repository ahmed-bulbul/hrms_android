package com.walton.smarthrm.model

data class UserListResponse(
    val code: Int,
    val currentPage: Int,
    val data: List<User2>,
    val message: String,
    val reverseSortDir: String,
    val status: Boolean,
    val totalItems: Int,
    val totalPages: Int
)