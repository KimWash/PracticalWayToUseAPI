package com.kimwash.practicalwaytouseapi.usecase

import android.util.Log

abstract class UseCase<ParamT, ResultT> () {
    private val TAG = "[UseCase]"

    suspend fun run(params: ParamT):ResultT {
        Log.d(TAG, "Running UseCase $this with following params: $params")
        return onExecute(params)
    }

    abstract suspend fun onExecute(params:ParamT): ResultT
}