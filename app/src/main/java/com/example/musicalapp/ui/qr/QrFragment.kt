package com.example.musicalapp.ui.qr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.musicalapp.R

class QrFragment : Fragment() {
    private lateinit var qrViewModel: QrViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        qrViewModel =
            ViewModelProviders.of(this).get(qrViewModel::class.java)
        val root = inflater.inflate(R.layout.fragmen_qr, container, false)
        val textView: TextView = root.findViewById(R.id.text_qr)
        qrViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}