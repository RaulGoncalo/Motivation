package com.rgos_developer.frases.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.rgos_developer.frases.infra.FrasesConstants
import com.rgos_developer.frases.R
import com.rgos_developer.frases.infra.SecurityPreferences
import com.rgos_developer.frases.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.buttonSave.setOnClickListener(this)

        supportActionBar?.hide()

        verifyUserName()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_save) {
            handleSave()
        }
    }

    private fun verifyUserName(){
        val name =  SecurityPreferences(this).getString(FrasesConstants.KEY.USER_NAME)
        if(name !=""){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun handleSave() {
        val name = binding.editName.text.toString()
        if (name != "") {
            SecurityPreferences(this).storeString(FrasesConstants.KEY.USER_NAME, name)
            //navegação entre telas
            startActivity(Intent(this, MainActivity::class.java))
            //destroi a activity que esta inserido
            finish()
        } else {
            Toast.makeText(
                /* context = */ this,
                /* resId = */ R.string.validation_mandatory_name,
                /* duration = */ Toast.LENGTH_SHORT).show()
        }
    }
}