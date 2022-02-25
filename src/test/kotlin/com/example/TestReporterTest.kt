package com.example

import com.example.Result.*
import com.oneeyedmen.okeydoke.Approver
import com.oneeyedmen.okeydoke.junit5.ApprovalsExtension
import org.junit.jupiter.api.Test as JUnitTest
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(ApprovalsExtension::class)
class TestReporterTest {
    @JUnitTest
    fun `it reports the results of all tests`(approver: Approver) {
        val report =
            TestReporter()
                .report(
                    tests = listOf(
                        Test("A line can be drawn", PASSED),
                        Test("A rectangle can be drawn", FAILED),
                    )
                )

        approver.assertApproved(report)
    }
}

