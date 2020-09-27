package com.citest.espresso_tutorials;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void sampleTestCase() {
        String username = "AUTOMATED_USERNAME";
        String password = "AUTOMATED_PASSWORD";
        String expectedValue = username + " " + password;

        onView(withId(R.id.usernameEditText))
                .perform(typeText(username), closeSoftKeyboard());
        onView(withId(R.id.passwordEditText))
                .perform(typeText(password), closeSoftKeyboard());
        onView(withId(R.id.submitButton)).perform(click());

        onView(withId(R.id.resultTextView)).check(matches(withText(expectedValue)));
    }

}
