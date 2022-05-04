package com.example.wsimf

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}