package com.example

fun report(tests: List<Test>): String =
    tests
        .resultLines()
        .plus("")
        .plus(tests.summaryLine())
        .joinToString(System.lineSeparator())

private fun List<Test>.resultLines(): List<String> =
    this.map { test -> "${test.result}: ${test.description}" }

private fun List<Test>.summaryLine(): String {
    val (passes, fails) = this.partition { test -> test.result == Result.PASSED }

    return "$size tests run, ${passes.size} passed, ${fails.size} failed"
}
