package jp.s64.android.toolbox.resultkt

sealed class Result<V> {
    abstract fun unwrap(): V?
}

data class Success<V>(val value: V): Result<V>() {

    override fun unwrap(): V? = value

}

data class Failure<V>(val reason: Throwable): Result<V>() {

    override fun unwrap(): V? = null

}
