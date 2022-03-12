package com.walton.smarthrm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.walton.smarthrm.databinding.ActivityUserListBinding

class UserListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}