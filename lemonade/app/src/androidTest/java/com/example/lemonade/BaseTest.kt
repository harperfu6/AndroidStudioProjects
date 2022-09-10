package com.example.lemonade

import android.view.View
import androidx.annotation.DrawableRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

/**
 * The lemonade app is effectively a state machine.
 * In order to avoid stateful tests (tests that rely on previous tests),
 * these utility methods move states and reduce code duplication.
 * This class is meant to be inherited by the @Test methods to leverage these methods.
 */
class BaseTest {

    /**
     * Test to ensure the app is in the correct state.
     * @param textActionResource Integer for the expected text resource.
     * @param drawableResource Integer for the expected drawable resource.
     */
    fun testState(textActionResource: Int, drawableResource: Int) {
        onView(withId(R.id.text_action)).check(matches(ViewMatchers.withText(textActionResource)))
//        onView(withId(R.id.image_lemon_state)).check(matches())
    }
}

object DrawableMatcher {
//    fun withDrawable(@DrawableRes resourceId: Int): Matcher<View> {
//    }
}