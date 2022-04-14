package com.example.rxjava_rxandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.rxjava_rxandroid.MainActivity2.Companion.TAG
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.concurrent.TimeUnit

class MainActivity2 : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //fromOperator()
//        fromIterableOperator()
//        rangeOperator().subscribe(
//            {
//                Log.d(TAG, "onNext: $it")
//            },
//            {
//                Log.d(TAG, "onError: ${it.toString()}")
//            },
//            {
//                Log.d(TAG, "onComplete")
//            },
//        )
//        repeatOperator().subscribe(
//            {
//                Log.d(TAG, "onNext: $it")
//            },
//            {
//                Log.d(TAG, "onError: ${it.toString()}")
//            },
//            {
//                Log.d(TAG, "onComplete")
//            })
//        intervalOperator().subscribe(
//            {
//                Log.d(TAG, "onNext: $it")
//                getLocation()
//            },
//            {
//                Log.d(TAG, "onError: ${it.toString()}")
//            },
//            {
//                Log.d(TAG, "onComplete")
//            })
//
//        timerOperator().subscribe(
//            {
//                Log.d(TAG, "onNext: $it")
//                getLocation()
//            },
//            {
//                Log.d(TAG, "onError: ${it.toString()}")
//            },
//            {
//                Log.d(TAG, "onComplete")
//            }
//        )
//        createOperator().subscribe(
//            {
//                Log.d(TAG, "onNext: $it")
//            },
//            {
//                Log.d(TAG, "onError: ${it.toString()}")
//            },
//            {
//                Log.d(TAG, "onComplete")
//            }
//       )
//        filterOperator()
//            .filter {
//                it.name.contains("demo")
//            }.subscribe(
//                {
//                    Log.d(TAG, "onNext: $it")
//                },
//                {
//                    Log.d(TAG, "onError: $it")
//                },
//                {
//                    Log.d(TAG, "onComplete")
//                }
//            )
//        lastOperator()
//            //.last(User(1,"demo1", 15))
//            //.lastElement()
//            .lastOrError()
//            .subscribe(
//                {
//                    Log.d(TAG, "onNext: $it")
//                },
//                {
//                    Log.d(TAG, "onError: $it")
//                }
//            )

//        distinctOperator()
//            //.distinct{ it.age }
//            .distinct()
//            .subscribe(
//                {
//                    Log.d(TAG, "onNext: $it")
//                },
//                {
//                    Log.d(TAG, "onError: $it")
//                },
//                {
//                    Log.d(TAG, "onComplete")
//                }
//            )
//        skipOperator()
//            .distinct()
//            //.skipLast(2)
//            .skip(1, TimeUnit.MILLISECONDS)
//            .subscribe(
//                {
//                    Log.d(TAG, "onNext: $it")
//                },
//                {
//                    Log.d(TAG, "onError: $it")
//                },
//                {
//                    Log.d(TAG, "onComplete")
//                }
//            )
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

        flatMapOperator()
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
            )
    }
}

private fun getLocation() {
    Log.d(TAG, "Latitude: 102.0303 Longitude: 1.2355")
}