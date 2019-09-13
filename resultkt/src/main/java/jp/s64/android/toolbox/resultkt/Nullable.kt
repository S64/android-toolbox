package jp.s64.android.toolbox.resultkt

sealed class Nullable<V> {
    abstract fun unwrap(): V?
    abstract fun toResult(): Result<V>
}

data class NonNull<V>(val value: V): Nullable<V>() {

    override fun toResult(): Result<V> = Success(value)

    override fun unwrap(): V? = value

}

data class Null<V>(val noValue: Unit = Unit): Nullable<V>() {

    override fun toResult(): Result<V> = toResult(NullPointerException())
    fun toResult(reason: Throwable): Result<V> = Failure(reason)

    override fun unwrap(): V? = null

}
