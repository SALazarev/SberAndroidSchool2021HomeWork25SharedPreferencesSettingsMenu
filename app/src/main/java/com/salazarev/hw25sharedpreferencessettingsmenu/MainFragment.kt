package com.salazarev.hw25sharedpreferencessettingsmenu

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.salazarev.hw25sharedpreferencessettingsmenu.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.apply {
            inflateMenu(R.menu.toolbar_menu)
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.btn_menu -> {
                        startActivity(Intent(activity, PreferencesActivity::class.java))
                        true
                    }
                    else -> super.onOptionsItemSelected(it)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        val prefs = PreferenceManager.getDefaultSharedPreferences(activity)


        val keepCalmAndStatus = if (prefs.getBoolean(
                getString(R.string.pref_key_keep_calm_and),
                true
            )
        ) View.VISIBLE else View.GONE
        binding.tvKeep.visibility = keepCalmAndStatus
        binding.tvCalm.visibility = keepCalmAndStatus
        binding.tvAnd.visibility = keepCalmAndStatus

        val doShowStatus = prefs.getBoolean(
                getString(R.string.pref_key_show_action),
                true
            )

        if (doShowStatus){
            val doHomeWorkStatus = if (prefs.getBoolean(
                    getString(R.string.pref_key_do_homework_action),
                    true
                )
            ) View.VISIBLE else View.GONE
            val writeProjectStatus = if (prefs.getBoolean(
                    getString(R.string.pref_key_write_project_action),
                    true
                )
            ) View.VISIBLE else View.GONE
            val keepMovingInterviewStatus = if (prefs.getBoolean(
                    getString(R.string.pref_key_keep_moving_interview),
                    true
                )
            ) View.VISIBLE else View.GONE

            binding.tvAction1.visibility = doHomeWorkStatus
            binding.tvAction2.visibility = writeProjectStatus
            binding.tvAction3.visibility = keepMovingInterviewStatus
        } else{
            binding.tvAction1.visibility = View.GONE
            binding.tvAction2.visibility = View.GONE
            binding.tvAction3.visibility = View.GONE
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}