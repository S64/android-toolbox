package jp.s64.android.toolbox.resultkt

sealed class Nullable<V> {
    abstract fun unwrap(): V?
}

data class NonNull<V>(val value: V): Nullable<V>() {

    override fun unwrap(): V? = value

}

data class Null<V>(val noValue: Unit = Unit): Nullable<V>() {

    override fun unwrap(): V? = null

}
