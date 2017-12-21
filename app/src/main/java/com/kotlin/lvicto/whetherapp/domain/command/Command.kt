package com.kotlin.lvicto.whetherapp.domain.command

interface Command<out T> {
    fun execute(): T
}