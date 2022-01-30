package com.example.coroutinesdemo

import kotlinx.coroutines.*

class UserDataManagerStructure {
    //corrtunia estructurada, utilizamos corotineScope para crear un bloque en el que solo retorna información
    //cuando todas las funciones de suspención han terminado.
    var count = 0
    lateinit var deferred: Deferred<Int>

    suspend fun getTotalUserCount(): Int {
        coroutineScope {
            launch(Dispatchers.IO) {
                delay(1000)
                count = 50
            }
            deferred = async {
                delay(3000)
                return@async 70
            }
        }
        return count + deferred.await()
    }
}