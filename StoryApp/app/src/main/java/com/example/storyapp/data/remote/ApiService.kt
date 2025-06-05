package com.example.storyapp.data.remote
import LoginRequest
import LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse

    // Tambahkan endpoint lain di sini
}