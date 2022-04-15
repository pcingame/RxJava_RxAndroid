package com.example.rxjava_rxandroid

import android.util.Log
import com.example.rxjava_rxandroid.MainActivity2.Companion.TAG
import io.reactivex.rxjava3.core.*
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.*

/*Khi dữ liệu được tạo ra bởi chính Observable, ta gọi đó là COLD Observable.*/
fun coldObservable(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun coldObserver() : Observer<User>{
    return object : Observer<User>{
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG, "onSubscribe")
        }

        override fun onNext(t: User) {
            Log.d(TAG, "onNext: $t")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG, "onError: $e")
        }

        override fun onComplete() {
            Log.d(TAG, "onComplete")
        }

    }
}