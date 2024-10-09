package com.goals.goalapp.di

import kotlinx.coroutines.CoroutineDispatcher

interface Dispatcher {

    fun providesDefaultDispatcher(): CoroutineDispatcher

    fun providesIODispatcher(): CoroutineDispatcher

    fun providesMainDispatcher(): CoroutineDispatcher
}
