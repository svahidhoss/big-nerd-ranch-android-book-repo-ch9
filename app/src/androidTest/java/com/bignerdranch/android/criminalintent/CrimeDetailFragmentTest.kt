package com.bignerdranch.android.criminalintent

import androidx.fragment.app.testing.FragmentScenario
import org.junit.Assert.*

import org.junit.After
import org.junit.Before

class CrimeDetailFragmentTest {

    private lateinit var scenario: FragmentScenario<CrimeDetailFragment>

    @Before
    fun setUp() {
        scenario = FragmentScenario.launch(CrimeDetailFragment::class.java)
    }

    @After
    fun tearDown() {
        scenario.close()
    }


}