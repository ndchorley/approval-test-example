package com.example

class TestReporter {
    fun report(tests: List<Test>): String {
        val (passes, fails) = tests.partition { test -> test.result == Result.PASSED }

        return tests
            .reportLines()
            .plus("")
            .plus("${tests.size} tests run, ${passes.size} passed, ${fails.size} failed")
            .joinToString(System.lineSeparator())
    }
}

private fun List<Test>.reportLines(): List<String> =
    this.map { test -> "${test.result}: ${test.description}" }

