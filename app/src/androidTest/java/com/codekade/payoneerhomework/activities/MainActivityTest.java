package com.codekade.payoneerhomework.activities;

import com.codekade.payoneerhomework.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.annotation.ContentView;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

@LargeTest
public class MainActivityTest {
//    @Rule
//    public ActivityScenarioRule<MainActivity> mainActivity = new ActivityScenarioRule<>(MainActivity.class);
//
//    @Before
//    public void initValidString() {
//        // Specify a valid string.
//        //stringToBetyped = "Espresso";
//    }
//
//    @Test
//    public void checkPayoneerButton() throws Throwable {
//        onView(withId(R.id.payoneer_button))            // withId(R.id.my_view) is a ViewMatcher
//                .perform(click())               // click() is a ViewAction
//                .check(matches(isDisplayed())); // matches(isDisplayed()) is a ViewAssertion
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        mainActivity = null;
//    }
}