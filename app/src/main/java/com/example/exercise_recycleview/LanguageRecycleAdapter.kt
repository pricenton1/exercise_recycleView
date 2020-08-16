package com.example.exercise_recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.language_item_layout.view.*

class LanguageRecycleAdapter(private val languageList: MutableList<String>) :
    RecyclerView.Adapter<LanguageViewHolder>() {

    lateinit var listener: RecyclerViewClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.language_item_layout, parent, false)
        return LanguageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return languageList.size
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.orderNumber.text = (position + 1).toString()
        holder.languageName.text = languageList[position]

        holder.itemView.setOnClickListener {
            listener.onItemClicked(it, languageList[position])
        }

        holder.itemView.delete_button.setOnClickListener {
            listener.onItemClicked(it, position, languageList[position])
        }
    }

}

class LanguageViewHolder(v: View) : RecyclerView.ViewHolder(v) {

    val orderNumber: TextView = v.findViewById(R.id.order_number)
    val languageName: TextView = v.findViewById(R.id.language_name)

}

interface RecyclerViewClickListener {

    fun onItemClicked(view: View, language: String)
    fun onItemClicked(view: View, position: Int, language: String)

}