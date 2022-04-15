package com.example.rxjava_rxandroid

import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.AsyncSubject
import io.reactivex.rxjava3.subjects.BehaviorSubject
import java.util.concurrent.TimeUnit

fun asyncSubject() {
    val observable = Observable.interval(1, TimeUnit.SECONDS)
        .takeWhile { it <= 5 }

    val subject = AsyncSubject.create<Long>()

    observable.subscribe(subject)

    subject.subscribe(
        {
            Log.d(MainActivity2.TAG, "onNext 1st: $it")
        },
        {
            Log.d(MainActivity2.TAG, "onError 1st: $it")
        },
        {
            Log.d(MainActivity2.TAG, "onComplete 2nd")
        })

    subject.subscribe(
        {
            Log.d(MainActivity2.TAG, "onNext 2nd: $it")
        },
        {
            Log.d(MainActivity2.TAG, "onError 2nd: $it")
        },
        {
            Log.d(MainActivity2.TAG, "onComplete 2nd")
        })
}

/*
fun asyncSubjectT2() {
    val subject = AsyncSubject.create<Int>()
    subject.onNext(1)
    subject.subscribe(
        {
            Log.d(MainActivity2.TAG, "onNext 1st: $it")
        },
        {
            Log.d(MainActivity2.TAG, "onError 1st: $it")
        },
        {
            Log.d(MainActivity2.TAG, "onComplete 1st")
        }
    )

    subject.onNext(2)
    subject.onNext(3)

    subject.subscribe(
        {
            Log.d(MainActivity2.TAG, "onNext 2nd: $it")
        },
        {
            Log.d(MainActivity2.TAG, "onError 2nd: $it")
        },
        {
            Log.d(MainActivity2.TAG, "onComplete 2nd")
        }
    )
    subject.onNext(4)
    subject.onComplete()


    subject.subscribe(
        {
            Log.d(MainActivity2.TAG, "onNext 3rd: $it")
        },
        {
            Log.d(MainActivity2.TAG, "onError 3rd: $it")
        },
        {
            Log.d(MainActivity2.TAG, "onComplete 3rd")
        }
    )
}*/

fun behaviorSubject(){
    val observable = Observable.interval(1, TimeUnit.SECONDS).takeWhile { it < 5 }

    val subject = BehaviorSubject.create<Long>()
    observable.subscribe(subject)
    subject.subscribe(
        {
            Log.d(MainActivity2.TAG, "onNext 1: $it")
        },
        {
            Log.d(MainActivity2.TAG, "onError 1: $it")
        },
        {
            Log.d(MainActivity2.TAG, "onComplete 1")
        }
    )

    subject.subscribe(
        {
            Log.d(MainActivity2.TAG, "onNext 2: $it")
        },
        {
            Log.d(MainActivity2.TAG, "onError 2: $it")
        },
        {
            Log.d(MainActivity2.TAG, "onComplete 2")
        }
    )
}