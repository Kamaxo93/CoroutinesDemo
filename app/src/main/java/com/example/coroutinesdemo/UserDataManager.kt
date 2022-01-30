package com.example.coroutinesdemo

import kotlinx.coroutines.*

class UserDataManager {

    //Corrutina no estructrada, lo que con lleva que no termine todas las tareas antes de lanzar la respuesta
    suspend fun getTotalUserCount(): Int {
        var count = 0

        CoroutineScope(Dispatchers.IO).async {
            delay(1000)
            count = 50
        }

        val deferred = CoroutineScope(Dispatchers.IO).async {
            delay(3000)
            return@async 70
        }
        return count + deferred.await()
    }
}