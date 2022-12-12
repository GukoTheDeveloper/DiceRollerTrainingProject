package app.abdelrahman.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import app.abdelrahman.aboutme.databinding.ActivityMainBinding




private lateinit var binding: ActivityMainBinding
private val myName : MyName = MyName("Abdo Samir")

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName = myName

        addUserNickName()
    }

    private fun addUserNickName() {

        binding.doneButton.setOnClickListener {
            addNickName()
        }
    }

    private fun addNickName() {
        if(binding.nicknameEdit.text.isEmpty())
        {
            binding.nicknameEdit.setError("this field can/'t be empty")
            return
        }else{
            binding.nicknameEdit.setError(null)
        }

        binding.apply {
            myName?.nickname = binding.nicknameEdit.text.toString()
            invalidateAll()
            binding.doneButton.visibility = View.GONE
            binding.nicknameEdit.visibility = View.GONE
            binding.nicknameTextview.visibility = View.VISIBLE
        }

    }



}