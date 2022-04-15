package com.example.rxjava_rxandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.rxjava_rxandroid.MainActivity2.Companion.TAG
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.schedulers.Schedulers.io
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.concurrent.TimeUnit

class MainActivity2 : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
        const val TAG2 = "MainActivity2"
    }

    val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //fromOperator()
        /*        fromIterableOperator()
                rangeOperator().subscribe(
                    {
                        Log.d(TAG, "onNext: $it")
                    },
                    {
                        Log.d(TAG, "onError: ${it.toString()}")
                    },
                    {
                        Log.d(TAG, "onComplete")
                    },
                )*/

        /*        repeatOperator()
.subscribe(
            {
                Log.d(TAG, "onNext: $it")
            },
            {
                Log.d(TAG, "onError: ${it.toString()}")
            },
            {
                Log.d(TAG, "onComplete")
            })*/

        /*        intervalOperator()
        .subscribe(
                    {
                        Log.d(TAG, "onNext: $it")
                        getLocation()
                    },
                    {
                        Log.d(TAG, "onError: ${it.toString()}")
                    },
                    {
                        Log.d(TAG, "onComplete")
                    })*/

        /*        timerOperator()
        .subscribe(
                    {
                        Log.d(TAG, "onNext: $it")
                        getLocation()
                    },
                    {
                        Log.d(TAG, "onError: ${it.toString()}")
                    },
                    {
                        Log.d(TAG, "onComplete")
                    }
                )*/

        /*        createOperator()
        .subscribe(
            {
                Log.d(TAG, "onNext: $it")
            },
            {
                Log.d(TAG, "onError: ${it.toString()}")
            },
            {
                Log.d(TAG, "onComplete")
            }
       )*/

        /*        filterOperator()
            .filter {
                it.name.contains("demo")
            }.subscribe(
                {
                    Log.d(TAG, "onNext: $it")
                },
                {
                    Log.d(TAG, "onError: $it")
                },
                {
                    Log.d(TAG, "onComplete")
                }
            )*/

        /*        lastOperator()
                    //.last(User(1,"demo1", 15))
                    //.lastElement()
                    .lastOrError()
                    .subscribe(
                        {
                            Log.d(TAG, "onNext: $it")
                        },
                        {
                            Log.d(TAG, "onError: $it")
                        }
                    )*/

        /*        distinctOperator()
                    //.distinct{ it.age }
                    .distinct()
                    .subscribe(
                        {
                            Log.d(TAG, "onNext: $it")
                        },
                        {
                            Log.d(TAG, "onError: $it")
                        },
                        {
                            Log.d(TAG, "onComplete")
                        }
                    )*/

        /*        skipOperator()
            .distinct()
            //.skipLast(2)
            .skip(1, TimeUnit.MILLISECONDS)
            .subscribe(
                {
                    Log.d(TAG, "onNext: $it")
                },
                {
                    Log.d(TAG, "onError: $it")
                },
                {
                    Log.d(TAG, "onComplete")
                }
            )*/

        /*   bufferOperator()
       .buffer(3)
       .subscribe(
           {
               Log.d(TAG, "onNext: $it")
           },
           {
               Log.d(TAG, "onError: $it")
           },
           {
               Log.d(TAG, "onComplete")
           }
       )*/

        /*mapOperator()
            .map {
                //it.age + 5
                UserProfile(it.id, it.name, it.age, "https://test.com/${it.id}")
            }
            .subscribe(
                {
                    Log.d(TAG, "onNext: $it")
                },
                {
                    Log.d(TAG, "onError: $it")
                },
                {
                    Log.d(TAG, "onComplete")
                }
            )*/

        /*flatMapOperator()
            .flatMap {
                //it.age + 5
                getUserProfile(it.id)
            }
            .subscribe(
                {
                    Log.d(TAG, "onNext: $it")
                },
                {
                    Log.d(TAG, "onError: $it")
                },
                {
                    Log.d(TAG, "onComplete")
                }
            )*/

        /*flatMapOperator2()
            .flatMap {
                //it.age + 5
                Observable.fromIterable(it)
            }
            .flatMap { getUserProfile(it.id) }
         //   .map { getUserProfile(it.id) }
            .subscribe(
                {
                    Log.d(TAG, "onNext: $it")
                },
                {
                    Log.d(TAG, "onError: $it")
                },
                {
                    Log.d(TAG, "onComplete")
                }
            )*/

        /*groupByOperator()
            .groupBy {
                it.age
            }
            //.filter { it.key == 23 }
            .flatMapSingle { group -> group.toList()  }
            .subscribe(
                {
                    Log.d(TAG, "onNext $it")
                },
                {
                    Log.d(TAG, "onError: $it")
                },
                {
                    Log.d(TAG, "onComplete")
                }
            )*/

        /*mergeOperator()
           .subscribe(
               {
                   Log.d(TAG, "onNext: $it")
               },
               {
                   Log.d(TAG, "onError: $it")
               },
               {
                   Log.d(TAG, "onComplete")
               }
           )*/

        /*concatOperator()
            .subscribe(
                {
                    Log.d(TAG, "onNext: $it")
                },
                {
                    Log.d(TAG, "onError: $it")
                },
                {
                    Log.d(TAG, "onComplete")
                }
            )*/

        /*startWithOperator()
            .subscribe(
                {
                    Log.d(TAG, "onNext: $it")
                },
                {
                    Log.d(TAG, "onError: $it")
                },
                {
                    Log.d(TAG, "onComplete")
                }
            )*/

        /* zipOperator()
             .subscribe(
                 {
                     Log.d(TAG, "onNext: $it")
                 },
                 {
                     Log.d(TAG, "onError: $it")
                 },
                 {
                     Log.d(TAG, "onComplete")
                 }
             )*/

        /*zipOperator()
            .subscribe(
                {   it.forEach{
                    Log.d(TAG, "onNext: $it")
                }

                },
                {
                    Log.d(TAG, "onError: $it")
                },
                {
                    Log.d(TAG, "onComplete")
                }
            )*/

        /*createObservable()
            .subscribe(
                {
                    Log.d(TAG, "onNext $it")
                },
                {
                    Log.d(TAG, "onError: $it")
                },
                {
                    Log.d(TAG, "onComplete")
                })*/

/*        createSingleObservable()
            .subscribe(
                {
                    Log.d(TAG, "onNext: $it")
                },
                {
                    Log.d(TAG, "onError: $it")
                },
            )*/

        /*  createMaybeObservable()
            .subscribe(observerMaybe())*/

        /*createCompletableObservable()
            .subscribe(observerCompletableObservable())*/

        /*createFlowableObservable()
          //  .onBackpressureLatest()
          //  .onBackpressureDrop()
            .onBackpressureBuffer()
            .observeOn(Schedulers.io(), false, 10)
            .subscribe(
                {
                    Log.d(TAG, "onNext: $it")
                },
                {
                    Log.d(TAG, "onError: $it")
                },
                {
                    Log.d(TAG, "onComplete")
                }
            )*/

        /*createFlowableObservableT2()
            .toFlowable(BackpressureStrategy.DROP)
            .observeOn(Schedulers.io(), false, 10)
            .subscribe(
                {
                    Log.d(TAG, "onNext: $it")
                },
                {
                    Log.d(TAG, "onError: $it")
                },
                {
                    Log.d(TAG, "onComplete")
                }
            )*/

        /*compositeDisposable.add(
            createObservable()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        Log.d(TAG, "onNext: $it")
                    },
                    {
                        Log.d(TAG, "onError: $it")
                    },
                    {
                        Log.d(TAG, "onComplete")
                    }
                )
        )*/

        /*compositeDisposable.add(
            intervalOperator().subscribe(
                {
                    Log.d(TAG2, "onNext: $it")
                },
                {
                    Log.d(TAG2, "onError: $it")
                },
                {
                    Log.d(TAG2, "onComplete")
                }
            )
        )*/

        /*compositeDisposable.add(
            Observable.just(mUserList)
                .flatMap {
                    Observable.fromIterable(it)
                }
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        tv.text = it.toString()
                        Log.d(TAG2, "onNext: $it threadName: ${Thread.currentThread().name}")
                    },
                    {
                        Log.d(TAG2, "onError: $it")
                    },
                    {
                        Log.d(TAG2, "onComplete")
                    }
                )
        )*/

        /* coldObservable().subscribe(coldObserver())
         Thread.sleep(200)
         coldObservable().subscribe(coldObserver())
         Thread.sleep(300)
         coldObservable().subscribe(coldObserver())*/

       /* val hotObservable = hotObservable()

        hotObservable().subscribe(
            {
                Log.d(TAG, "onNext 1st: $it")
            },
            {
                Log.d(TAG, "onError: $it")
            },
            {
                Log.d(TAG, "onComplete")
            })
        hotObservable.connect()

        hotObservable().subscribe(
            {
                Log.d(TAG, "onNext 2nd: $it")
            },
            {
                Log.d(TAG, "onError 2nd: $it")
            },
            {
                Log.d(TAG, "onComplete 2nd")
            })*/

        /*val hotObservable = hotObservableT2()
        hotObservable.connect()
        hotObservable.subscribe(
            {
                Log.d(TAG, "onNext 1st: $it")
            },
            {
                Log.d(TAG, "onError: $it")
            },
            {
                Log.d(TAG, "onComplete")
            }
        )

        Thread.sleep(5000)
        hotObservable.subscribe(
            {
                Log.d(TAG, "onNext 2nd: $it")
            },
            {
                Log.d(TAG, "onError 2nd: $it")
            },
            {
                Log.d(TAG, "onComplete 2nd")
            }
        )*/

        //asyncSubject()
       // asyncSubjectT2()
        behaviorSubject()
    }

    private fun getLocation() {
        Log.d(TAG, "Latitude: 102.0303 Longitude: 1.2355")
    }

    override fun onDestroy() {
        //  disposable.dispose()
        compositeDisposable.clear()
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }
}



