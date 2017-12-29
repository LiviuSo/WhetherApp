package com.kotlin.lvicto.whetherapp.domain.commands

interface Command<out T> {
    fun execute(): T
}