package com.kulads.aplikasi2.ui.skill

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SkillViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Skill Fragment"
    }
    val text: LiveData<String> = _text
}