package com.example.exercise_recycleview.language.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.FieldPosition

class LanguageViewModel:ViewModel() {

    val languageList = mutableListOf<String>("Java","Phyton","C","Swift","JS","PHP")

    val languagesLiveData:MutableLiveData<MutableList<String>> = MutableLiveData(languageList)

    fun addLanguage(name:String){
        languageList.add(name)
        languagesLiveData.value = languageList
    }

    fun removeLanguage(index: Int){
        languageList.removeAt(index)
        languagesLiveData.value = languageList
    }

}