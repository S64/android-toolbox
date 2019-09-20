package jp.s64.android.toolbox.ktx.rxjavainterop

import hu.akarnokd.rxjava.interop.RxJavaInterop
import io.reactivex.disposables.Disposable
import rx.Subscription as Subscription1
import io.reactivex.Observable as Observable2
import rx.Observable as Observable1

fun <T> Observable1<T>.toV2(): Observable2<T> {
    return RxJavaInterop.toV2Observable(this)
}

fun <T> Disposable.toV1(): Subscription1 {
    return RxJavaInterop.toV1Subscription(this)
}
