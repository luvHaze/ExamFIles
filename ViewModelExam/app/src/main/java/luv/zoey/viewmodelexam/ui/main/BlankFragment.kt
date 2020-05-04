package luv.zoey.viewmodelexam.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_blank.*
import kotlinx.android.synthetic.main.main_fragment.*
import luv.zoey.viewmodelexam.R

/**
 * A simple [Fragment] subclass.
 */
class BlankFragment : Fragment() {


    companion object {
        fun newInstance() = BlankFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        ViewModel
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        frag2TextView.text = MainViewModel.num.toString()
        viewModel.plusOne()
        frag2Button.setOnClickListener {
            viewModel.plusOne()
            frag2TextView.text = MainViewModel.num.toString()
        }

    }

    override fun onResume() {
        super.onResume()
        frag2TextView.text = MainViewModel.num.toString()
    }
}