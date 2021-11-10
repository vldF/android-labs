package me.vldf.lab32

import android.content.Context
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Assert


fun openAbout() = openAboutViaBottomNav()

fun goToSecondFromFirst() {
    onView(withId(R.id.bnToSecond)).perform(click())
}

fun goToThirdFromFirst() {
    goToSecondFromFirst()
    onView(withId(R.id.bnToThird)).perform(click())
}

fun isFragmentShown(id: Int) {
    onView(withId(id)).check(matches(isDisplayed()))
}

fun pressBackNTimes(n: Int) {
    repeat(n) {
        Espresso.pressBack()
    }
}

fun pressBackUpNav(n: Int) {
    repeat(n) {
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
    }
}

fun pressBackUnconditionallyNTimes(n: Int) {
    repeat(n) {
        Espresso.pressBackUnconditionally()
    }
}

fun ActivityScenario<*>.checkBackstackDepth(depth: Int) {
    pressBackUnconditionallyNTimes(depth)
    Assert.assertEquals(state, Lifecycle.State.DESTROYED)
}

fun pressButton(id: Int) {
    onView(withId(id)).perform(click())
}

fun rotateScreen(scenario: ActivityScenario<*>) {
    val context: Context = ApplicationProvider.getApplicationContext()
    val orientation: Int = context.resources.configuration.orientation

    scenario.onActivity {
        it.requestedOrientation =
            if (orientation == Configuration.ORIENTATION_PORTRAIT){
                ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            } else {
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            }
    }

    Thread.sleep(1000)
}

fun checkAboutActivity() {
    onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
}

private fun openAboutViaBottomNav() {
    onView(withId(R.id.nav_view)).perform(click())
}