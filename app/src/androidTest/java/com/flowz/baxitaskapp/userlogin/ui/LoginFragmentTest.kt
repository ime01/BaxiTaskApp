package com.flowz.baxitaskapp.userlogin.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.flowz.baxitaskapp.MainActivity
import com.flowz.baxitaskapp.R
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginFragmentTest{

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun confirmingLoginScreenViews() {

        onView(withId(R.id.welcome_user)).check(matches(isDisplayed()))

        onView(withId(R.id.remember_me)).check(matches(isDisplayed()))

        onView(withId(R.id.password_layout)).check(matches(isDisplayed()))

        onView(withId(R.id.name_layout)).check(matches(isDisplayed()))

        onView(withId(R.id.login_button)).check(matches(isDisplayed()))
    }


}