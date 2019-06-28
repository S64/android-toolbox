package jp.s64.android.toolbox.resultkt

sealed class Result<V>

data class Success<V>(val value: V): Result<V>()
data class Failure<V>(val reason: Throwable): Result<V>()
