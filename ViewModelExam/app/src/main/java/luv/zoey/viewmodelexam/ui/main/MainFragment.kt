package luv.zoey.viewmodelexam.ui.main

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_blank.*
import kotlinx.android.synthetic.main.main_fragment.*
import luv.zoey.viewmodelexam.MainActivity
import luv.zoey.viewmodelexam.R

class MainFragment : Fragment() {



    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        textView.text = MainViewModel.num.toString()
        btnIncrease.setOnClickListener {
            viewModel.plusOne()
            textView.text = MainViewModel.num.toString()
        }

        nextFragment.setOnClickListener {
            var intent = Intent(view.context,MainActivity::class.java)
            intent.putExtra("change","change")
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        textView.text = MainViewModel.num.toString()
    }

}
