package com.example.rxjava_rxandroid

import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.BiFunction
import java.lang.Exception
import java.util.*
import java.util.concurrent.TimeUnit

private val mListNum = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
private val arrayNum = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
private val arrayNum2 = arrayOf(10, 2, 3, 4, 5, 60, 7, 8, 9, 100, 11, 12, 99, 22)
val mUserList = mutableListOf<User>(
    User(1, "demo1", 15),
    User(2, "demo2", 18),
    User(3, "demo3", 20),
    User(4, "demo4", 21),
    User(5, "demo5", 22),
    User(6, "demo6", 26),
    User(9, "demo9", 26),
    User(7, "demo7", 27),
    User(8, "demo8", 27),
    // User(8,"demo8", 27),
)

val mUserProfileList = mutableListOf<UserProfile>(
    UserProfile(1, "demo1", 15, "https:test.com1"),
    UserProfile(2, "demo2", 18, "https:test.com2"),
    UserProfile(3, "demo3", 20, "https:test.com3"),
    UserProfile(4, "demo4", 21, "https:test.com4"),
    UserProfile(5, "demo5", 22, "https:test.com5"),
    UserProfile(6, "demo6", 26, "https:test.com6"),
    UserProfile(9, "demo9", 26, "https:test.com9"),
    UserProfile(7, "demo7", 27, "https:test.com7"),
    UserProfile(8, "demo8", 27, "https:test.com8"),
    UserProfile(8, "demo8", 27, "https:test.com8"),
)

val mBlogList = mutableListOf<Blog>(
    Blog(1, 1, "title1", "content1"),
    Blog(2, 2, "title2", "content2"),
    Blog(3, 3, "title1", "content1"),
    Blog(4, 4, "title2", "content2"),
    Blog(5, 5, "title3", "content3"),
    Blog(6, 6, "title4", "content4"),
    Blog(7, 7, "title5", "content5"),
    Blog(8, 15, "title1", "content1")
)

val mUserListEmpty = emptyList<User>()

fun justOperator() {
    val observable = Observable.just(mListNum)

    val observer = object : Observer<List<Int>> {
        override fun onSubscribe(d: Disposable) {
            Log.d(MainActivity2.TAG, "onSubscribe")
        }

        override fun onNext(t: List<Int>) {
            Log.d(MainActivity2.TAG, "onNext: $t")
        }

        override fun onError(e: Throwable) {
            Log.d(MainActivity2.TAG, "onError: $e")
        }

        override fun onComplete() {
            Log.d(MainActivity2.TAG, "onComplete")
        }


    }
    observable.subscribe(observer)
}

fun fromOperator() {
    val observable = Observable.fromArray(arrayNum, arrayNum2)

    val observer = object : Observer<Array<Int>> {
        override fun onSubscribe(d: Disposable) {
            Log.d(MainActivity2.TAG, "onSubscribe")
        }

        override fun onNext(t: Array<Int>) {
            Log.d(MainActivity2.TAG, "onNext: ${Arrays.toString(t)}")
        }

        override fun onError(e: Throwable) {
            Log.d(MainActivity2.TAG, "onError: $e")
        }

        override fun onComplete() {
            Log.d(MainActivity2.TAG, "onComplete")
        }
    }
    observable.subscribe(observer)
}

fun fromIterableOperator() {
    val observable = Observable.fromIterable(mListNum)

    val observer = object : Observer<Int> {
        override fun onSubscribe(d: Disposable) {
            Log.d(MainActivity2.TAG, "onSubscribe")
        }

        override fun onNext(t: Int) {
            Log.d(MainActivity2.TAG, "onNext: $t")
        }

        override fun onError(e: Throwable) {
            Log.d(MainActivity2.TAG, "onError: $e")
        }

        override fun onComplete() {
            Log.d(MainActivity2.TAG, "onComplete")
        }

    }
    observable.subscribe(observer)
}

fun rangeOperator(): Observable<Int> {
    return Observable.range(1, 10)
}

fun repeatOperator(): Observable<Int> {
    return Observable.range(1, 10).repeat(2)
}

fun intervalOperator(): Observable<Long> {
    return Observable.interval(5, 1, TimeUnit.SECONDS).takeWhile { value ->
        value <= 100
    }
}

fun timerOperator(): Observable<Long> {
    return Observable.timer(5, TimeUnit.SECONDS)
}

fun createOperator(): Observable<Int> {
    return Observable.create(ObservableOnSubscribe<Int> {
        try {
            for (i in mListNum) {
                it.onNext(i * 5)
            }

            it.onComplete()
        } catch (ex: Exception) {
            it.onError(ex)
        }
    })
}

fun filterOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun lastOperator(): Observable<User> {
    return Observable.fromIterable(mUserListEmpty)
}

fun distinctOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun skipOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun bufferOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun mapOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun flatMapOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

//fun getUserProfile(id: Long): Observable<UserProfile> {
//    return Observable.fromIterable(mUserProfileList)
//        .filter{
//            it.id == id
//        }
//}

fun flatMapOperator2(): Observable<List<User>> {
    return Observable.just(mUserList)
}

fun groupByOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun getUser(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun getUserProfile(): Observable<UserProfile> {
    return Observable.fromIterable(mUserProfileList)
}

fun mergeOperator(): Observable<Any> {
    return Observable.merge(getUser(), getUserProfile())
}

fun getNum1to100(): Observable<Int> {
    return Observable.range(1, 10)
}

fun getNum101to150(): Observable<Int> {
    return Observable.range(101, 150)
}

fun concatOperator(): Observable<Int> {
    return Observable.concat(getNum1to100(), getNum101to150())
}

fun startWithOperator(): Observable<User> {
    //   return getNum101to150().startWith(getNum1to100())
    return getUser().startWith(Single.just(User(0, "demo0", 10)))
}

fun getBlogs(): Observable<List<Blog>> {
    return Observable.just(mBlogList)
}

fun getUsers(): Observable<List<User>> {
    return Observable.just(mUserList)
}

fun zipOperator(): Observable<List<BlogDetail>> {
    /* val num = Observable.just(1,2,3,4,5)
     val char = Observable.just("a","b","c", "d", "e")
     return Observable.zip(num, char, BiFunction { t1, t2 ->
         "$t1$t2"
     })*/

    return Observable.zip(getUsers(), getBlogs(), BiFunction { t1, t2 ->
        blogDetail(t1, t2)
    })
}

fun blogDetail(t1: List<User>, t2: List<Blog>): List<BlogDetail> {
    val listBlogDetail: MutableList<BlogDetail> = emptyList<BlogDetail>().toMutableList()
    t1.forEach { user ->
        t2.forEach { blog ->
            if (blog.userId == user.id) {
                listBlogDetail.add(
                    BlogDetail(
                        blog.id, blog.userId, blog.title, blog.content, user
                    )
                )
            }
        }
    }
    return listBlogDetail
}