package com.bignerdranch.android.criminalintent

import android.app.Dialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.navArgs

class TimePickerFragment : DialogFragment() {

    private val args: TimePickerFragmentArgs by navArgs()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        calendar.time = args.crimeTime

        val listener =
            TimePickerDialog.OnTimeSetListener { _, hour: Int, minute: Int ->
                calendar.set(Calendar.HOUR_OF_DAY, hour)
                calendar.set(Calendar.MINUTE, minute)
                val resultDate = calendar.time

                setFragmentResult(
                    REQUEST_KEY_TIME,
                    bundleOf(BUNDLE_KEY_TIME to resultDate)
                )
            }

        val initialHour = calendar.get(Calendar.HOUR)
        val initialMinute = calendar.get(Calendar.MINUTE)

        return TimePickerDialog(
            requireContext(),
            listener,
            initialHour,
            initialMinute,
            true
        )
    }

    companion object {
        const val REQUEST_KEY_TIME = "REQUEST_KEY_TIME"
        const val BUNDLE_KEY_TIME = "BUNDLE_KEY_TIME"
    }
}