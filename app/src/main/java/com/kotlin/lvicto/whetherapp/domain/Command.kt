package com.kotlin.lvicto.whetherapp.domain

interface Command<out T> {
    fun execute(): T
}