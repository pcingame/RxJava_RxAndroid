package com.example.rxjava_rxandroid

import android.util.Log
import com.example.rxjava_rxandroid.MainActivity2.Companion.TAG
import io.reactivex.rxjava3.core.*
import io.reactivex.rxjava3.disposables.Disposable
import java.lang.Exception

fun createObservable(): Observable<Int> {
    return Observable.create { emitter ->
        try {
            if (!emitter.isDisposed){
                for (i in 0..100000){
                    emitter.onNext(i)
                }
                emitter.onComplete()
            }
        }catch (ex: Exception){
            emitter.onError(ex)
        }

    }
}

fun observer(): Observer<Int>{
    return object : Observer<Int>{
        override fun onSubscribe(d: Disposable) {
            d?.let {
                disposable = d
            }
        }

        override fun onNext(t: Int) {
            Log.d(TAG, "onNext: $t")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG, "onError: ${e.message}")
        }

        override fun onComplete() {
            Log.d(TAG, "onComplete")
        }

    }
}

/*Single là một biến thể của Observable. Nó chỉ emit ra item nếu thành công hoặc ném ra lỗi. Single
chỉ emit ra một giá trị và một số operator không có tác dụng khi sử dụng với nó*/
fun createSingleObservable(): Single<List<User>> {
    return Single.create { emitter ->
        try {
            if (!emitter.isDisposed){
//                for (i in 0..100){
//                    emitter.onSuccess(i)
//                }
                emitter.onSuccess(mUserList)
            }
        }catch (ex: Exception){
            emitter.onError(ex)
        }

    }
}

fun observerSingle(): SingleObserver<List<User>>{
    return object : SingleObserver<List<User>>{
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG, "onSubscribe")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG, "onError: ${e.message}")
        }

        override fun onSuccess(t: List<User>) {
            t.forEach {
                Log.d(TAG, "onSuccess: $it")
            }

        }


    }
}

/*Maybe cũng tương tự như Single chỉ có khác biệt là nó cho phép không có item nào được emit ra.*/
fun createMaybeObservable(): Maybe<List<User>> {
    return Maybe.just(mUserList)
}

fun observerMaybe(): MaybeObserver<List<User>>{
    return object : MaybeObserver<List<User>> {
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG, "onSubscribe")
        }

        override fun onSuccess(t: List<User>) {
            Log.d(TAG, "onSuccess: $t")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG, "onError: $e")
        }

        override fun onComplete() {
            Log.d(TAG, "onComplete")
        }

    }

}

/*Completable chỉ quan tâm về hoạt động thực hiện có được hoàn thành hay xảy ra lỗi hay
           không thôi. Mà không hề quan tâm đến kết quả trả về.*/

fun createCompletableObservable(): Completable {
    return Completable.create { emitter ->
        try {
            if (!emitter.isDisposed){
                getLocation()
                emitter.onComplete()
            }
        }catch (ex: Exception){
            emitter.onError(ex)
        }

    }
}

fun observerCompletableObservable(): CompletableObserver{
    return object : CompletableObserver {
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG, "onSubscribe")
        }

        override fun onComplete() {
            Log.d(TAG, "onComplete")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG, "onError: $e")
        }

    }
}

private fun getLocation() {
    Thread.sleep(2000)
    //throw Exception("ex")
    Log.d(TAG, "Latitude: 102.0303 Longitude: 1.2355")
}

/*Đc dùng khi một Observable tạo được số lượng to những event / dữ liệu mà Observer có thể xử lý.
Flowable có thể đc dùng khi nguồn tạo được 10k+ event and Onserver không hề tiêu hao toàn bộ.
Flowable dùng phương thức Backpressure để xử lý dữ liệu né lỗi
MissingBackpressureException and OutOfMemoryError.*/


fun createFlowableObservable(): Flowable<Int> {
    return Flowable.range(1,100)
}

fun createFlowableObservableT2(): Observable<Int> {
    return Observable.range(1,100)
}

lateinit var disposable: Disposable

/* Schedulers là một trong những thành phần chính trong RxJava. Họ chịu trách nhiệm thực hiện các
hoạt động của Observable trên các threads khác nhau dựa trên các phương thức
subscribeOn và observOn*/
