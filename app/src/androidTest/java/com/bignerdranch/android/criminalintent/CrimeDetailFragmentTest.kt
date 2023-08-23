package com.bignerdranch.android.criminalintent

import androidx.fragment.app.testing.FragmentScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test

class CrimeDetailFragmentTest {

    private lateinit var scenario: FragmentScenario<CrimeDetailFragment>

    @Before
    fun setUp() {
        scenario = FragmentScenario.launchInContainer(CrimeDetailFragment::class.java)
    }

    @After
    fun tearDown() {
        scenario.close()
    }

    @Test
    fun showsCorrectCheckBoxAndEditTextOnLaunch() {
        onView(withId(R.id.check_box_crime_solved)).check(matches(withText(R.string.crime_solved_label)))
        onView(withId(R.id.edit_text_crime_title)).check(matches(withHint(R.string.crime_title_hint)))
    }

    @Test
    fun fragmentStateIsUpdatedWhenTitleIsChanged() {
        // change the title
        val newTitle = "New Text for title"
        onView(withId(R.id.edit_text_crime_title)).perform(ViewActions.typeText(newTitle))
        onView(withId(R.id.edit_text_crime_title)).check(matches(withText(newTitle)))
        // check the value of crime in fragment
        scenario.onFragment {
            assertEquals(it.crime.title, newTitle)
            assertFalse(it.crime.isSolved)
        }
    }
}