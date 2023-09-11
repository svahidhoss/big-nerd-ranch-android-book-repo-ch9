package com.bignerdranch.android.criminalintent

import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.navArgs
import com.bignerdranch.android.criminalintent.databinding.FragmentCrimeDetailBinding
import java.util.Date
import java.util.UUID

private const val TAG = "CrimeDetailFragment"

/**
 * A simple [Fragment] subclass.
 */
class CrimeDetailFragment : Fragment() {

    private var _binding: FragmentCrimeDetailBinding? = null

    // Make binding a computed value
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

    private val args: CrimeDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCrimeDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            editTextCrimeTitle.doOnTextChanged { text, _, _, _ ->
            }

            buttonCrimeDate.apply {
                isEnabled = false
            }

            checkBoxCrimeSolved.setOnCheckedChangeListener { _, isChecked ->
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
