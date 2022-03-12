package com.walton.smarthrm.model

data class UserLoginResponse(
    val accessToken: String,
    val expiresAt: Int,
    val status: Boolean,
    val tokenType: String,
    val user: User
)