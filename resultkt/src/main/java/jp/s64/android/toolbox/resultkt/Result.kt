package jp.s64.android.toolbox.resultkt

sealed class Result<V> {
    abstract fun unwrap(): V?
    abstract fun toNullable(): Nullable<V>
}

data class Success<V>(val value: V): Result<V>() {

    override fun toNullable(): Nullable<V> = NonNull(value)

    override fun unwrap(): V? = value

}

data class Failure<V>(val reason: Throwable): Result<V>() {

    override fun toNullable(): Nullable<V> = Null()

    override fun unwrap(): V? = null

}
