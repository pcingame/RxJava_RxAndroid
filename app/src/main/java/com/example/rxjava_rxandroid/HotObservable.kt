package com.example.rxjava_rxandroid

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observables.ConnectableObservable
import java.util.*
import java.util.concurrent.TimeUnit

/*Khi dữ liệu được tạo ra bên ngoài Observable, ta gọi đó là HOT Observable.*/
fun hotObservable(): ConnectableObservable<User> {
    return Observable.fromIterable(mUserList).publish()

}

fun hotObservableT2(): ConnectableObservable<Long> {
    return Observable.interval(1, TimeUnit.SECONDS).publish()
}