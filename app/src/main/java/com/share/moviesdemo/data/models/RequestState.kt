package com.share.moviesdemo.data.models

class RequestState<T> (
    var data: T? = null,
    var state: State = State.LOADING,
    var msg: String? = ""
) {

    fun loading(): RequestState<T> {
        this.state = State.LOADING
        return this
    }

    fun success(data: T): RequestState<T> {
        this.state = State.SUCCESS
        this.data = data
        return this
    }

    fun error(msg: String?): RequestState<T> {
        this.state = State.ERROR
        this.msg = msg
        return this
    }

    fun requestState() = this

}