package com.example.exercise_recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exercise_recycleview.language.view_model.LanguageViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.language_item_layout.*

class MainActivity : AppCompatActivity(),RecyclerViewClickListener {

    private val languageViewModel by viewModels<LanguageViewModel>()
    private lateinit var languageRecycleAdapter: LanguageRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        language_recycleView.layoutManager = LinearLayoutManager(this)

        languageRecycleAdapter = LanguageRecycleAdapter(languageViewModel.languagesLiveData.value!!)
        languageRecycleAdapter.listener = this
        language_recycleView.adapter = languageRecycleAdapter

//        adapter = LanguageRecycleAdapter.kt(languageList)
//        language_recycleView.adapter = adapter
//        languageViewModel.languagesLiveData.observe(this, Observer {
//            languageRecycleAdapter.notifyDataSetChanged()
//        })
        languageViewModel.languagesLiveData.observe(this, Observer {
            languageRecycleAdapter.notifyDataSetChanged()
        })
    }

    fun addLanguage(view: View) {
        val languageName = language_name_input.text.toString()
//        languageList.add(languageName)
        languageViewModel.addLanguage(languageName)
//        language_recycleView.adapter?.notifyDataSetChanged()
    }

    //implement method from RecyclerViewClickListener interface
    override fun onItemClicked(view: View, language: String) {
        Toast.makeText(this, "$language CLICKED", Toast.LENGTH_SHORT).show()
    }
    //implement method from RecyclerViewClickListener interface
    override fun onItemClicked(view: View, index: Int,language: String) {
        languageViewModel.removeLanguage(index)
        Toast.makeText(this, "$index DELETED", Toast.LENGTH_SHORT).show()

    }
}