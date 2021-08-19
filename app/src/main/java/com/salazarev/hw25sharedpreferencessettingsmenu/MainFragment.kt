package com.salazarev.hw25sharedpreferencessettingsmenu

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
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
                        activity?.supportFragmentManager?.beginTransaction()
                            ?.replace(R.id.fragment_layout_place, PreferencesFragment())
                            ?.addToBackStack(null)?.commit()
                        true
                    }
                    else -> super.onOptionsItemSelected(it)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}