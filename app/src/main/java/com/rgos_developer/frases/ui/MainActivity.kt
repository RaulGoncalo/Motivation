package com.rgos_developer.frases.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.rgos_developer.frases.infra.FrasesConstants
import com.rgos_developer.frases.R
import com.rgos_developer.frases.data.Mock
import com.rgos_developer.frases.infra.SecurityPreferences
import com.rgos_developer.frases.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryId = FrasesConstants.FILTER.INFINITE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //esconder barra de navegação, nullSafe
        supportActionBar?.hide()

        //recupera o nome
        handleName()
        handleFilter(R.id.image_infinite)
        handleNextPhrase()

        //estancia do evendo de click
        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageInfinite.setOnClickListener(this)
        binding.imageEmoji.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_new_phrase) {
            handleNextPhrase()
        } else if (view.id in listOf(R.id.image_emoji, R.id.image_infinite, R.id.image_sunny)) {
            handleFilter(view.id)
        }
    }

    private fun handleNextPhrase(){

        binding.textPhrase.text = Mock().getPhrase(this.categoryId, Locale.getDefault().language)
    }

    private fun handleFilter(id: Int) {
        binding.imageInfinite.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageEmoji.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))

        when (id) {
            R.id.image_infinite -> {
                binding.imageInfinite.setColorFilter(ContextCompat.getColor(this, R.color.white))
                this.categoryId = FrasesConstants.FILTER.INFINITE //magic number
            }

            R.id.image_emoji -> {
                binding.imageEmoji.setColorFilter(ContextCompat.getColor(this, R.color.white))
                this.categoryId = FrasesConstants.FILTER.EMOJI
            }

            R.id.image_sunny -> {
                binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
                this.categoryId = FrasesConstants.FILTER.SUNNY
            }
        }
    }

    private fun handleName() {
        val name = SecurityPreferences(this).getString(FrasesConstants.KEY.USER_NAME)
        val hello = getString(R.string.hello)
        binding.textName.text = "$hello, $name!"
    }
}