package com.example

data class Test(val description: String, val result: Result)

enum class Result { PASSED, FAILED }