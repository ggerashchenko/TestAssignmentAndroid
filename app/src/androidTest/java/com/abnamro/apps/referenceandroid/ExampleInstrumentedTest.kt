package com.abnamro.apps.referenceandroid

import android.app.Activity
import android.app.Instrumentation
import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
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

    @Before
    fun setup() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun testTextElementsAreDisplayedOnMainScreen() {
        onView(withText("ReferenceAndroid"))
            .check(matches(isDisplayed()))
        onView(withText("Hello World!"))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testEnvelopFloatingButtonClick() {
        onView(withId(R.id.fab))
            .perform(ViewActions.click())
        onView(withText("Replace with your own action"))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testIntentToOpenSettingsActivity() {
        Intents.intending(IntentMatchers.hasComponent(SettingsActivity::class.java.name))
            .respondWith(Instrumentation.ActivityResult(Activity.RESULT_OK, null))
        openActionBarOverflowOrOptionsMenu(
            ApplicationProvider.getApplicationContext<Context>()
        )
        onView(withText("Settings"))
            .perform(ViewActions.click())
        Intents.intended(IntentMatchers.hasComponent(SettingsActivity::class.java.name), Intents.times(1))
    }
}
