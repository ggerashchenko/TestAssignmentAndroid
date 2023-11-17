package com.abnamro.apps.referenceandroid

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val activityRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testEnvelopFloatingButtonClick() {
        Espresso.onView(ViewMatchers.withId(R.id.fab))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withText("Replace with your own action"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
