package com.gamespace.home.data

sealed class Resource<T> {
    class Fetching<T> : Resource<T>()
    data class Content<T>(val data: T?) : Resource<T>()
    data class Error<T>(val message: String) : Resource<T>()
}
