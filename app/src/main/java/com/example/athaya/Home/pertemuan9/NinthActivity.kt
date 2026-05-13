package com.example.athaya.Home.pertemuan9

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.athaya.databinding.ActivityNinthBinding
import com.google.android.material.chip.Chip

class NinthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNinthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityNinthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // Handle Window Insets agar tidak tertutup Status Bar/Nav Bar
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom)
            binding.toolbar.setPadding(0, systemBars.top, 0, 0)
            insets
        }

        // Login Button Click
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            
            if (email.isNotEmpty() && password.isNotEmpty()) {
                Toast.makeText(this, "Login Berhasil untuk $email", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Harap isi Email dan Password", Toast.LENGTH_SHORT).show()
            }
        }

        // Chip Group Selection
        binding.chipGroupFilter.setOnCheckedStateChangeListener { group, checkedIds ->
            val selectedChipId = checkedIds.firstOrNull()
            if (selectedChipId != null) {
                val chip = group.findViewById<Chip>(selectedChipId)
                Toast.makeText(this, "Filter aktif: ${chip.text}", Toast.LENGTH_SHORT).show()
            }
        }

        // Grid Menu Button Clicks
        val menuButtons = listOf(
            binding.btnMenu1, binding.btnMenu2, binding.btnMenu3,
            binding.btnMenu4, binding.btnMenu5, binding.btnMenu6
        )

        menuButtons.forEachIndexed { index, button ->
            button.setOnClickListener {
                Toast.makeText(this, "Membuka Menu ${index + 1}", Toast.LENGTH_SHORT).show()
            }
        }

        // Circular Menu Button
        binding.btnCircularMenu.setOnClickListener {
            Toast.makeText(this, "Circular Menu Diklik", Toast.LENGTH_SHORT).show()
        }
    }
}
