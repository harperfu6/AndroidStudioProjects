package com.example.wordsapp

import androidx.fragment.app.ListFragment
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

@RunWith(AndroidJUnit4::class)
class NavigationTests {

    lateinit var navHostController: TestNavHostController
    lateinit var letterFragmentScenario: FragmentScenario<LetterListFragment>

    @Before
    fun setup() {
        navHostController = TestNavHostController(
            ApplicationProvider.getApplicationContext()
        )
        letterFragmentScenario = launchFragmentInContainer<LetterListFragment>(themeResId = R.style.Theme_WordsApp)
        letterFragmentScenario.onFragment { fragment ->
            navHostController.setGraph(R.navigation.nav_graph)
            Navigation.setViewNavController(fragment.requireView(), navHostController)
        }
    }

    @Test
    fun test_c() {
        onView(withId(R.id.recycler_view))
            .perform(
                RecyclerViewActions
                    .actionOnItemAtPosition<RecyclerView.ViewHolder>(2, click()))
        assertEquals(navHostController.currentDestination?.id, R.id.wordListFragment)
    }

    @Test
    fun test_z() {
        onView(withId(R.id.recycler_view))
            .perform(
                RecyclerViewActions
                    .actionOnItemAtPosition<RecyclerView.ViewHolder>(25, click()))
        assertEquals(navHostController.currentDestination?.id, R.id.wordListFragment)
    }
}
