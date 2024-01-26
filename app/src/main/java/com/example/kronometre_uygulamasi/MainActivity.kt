package com.example.kronometre_uygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import com.example.kronometre_uygulamasi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var zamaniDurdur:Long = 0

        binding.btnStart.setOnClickListener {
            binding.kronometre.base = SystemClock.elapsedRealtime() + zamaniDurdur
            binding.kronometre.start()
            binding.btnStart.visibility = View.GONE
            binding.btnPause.visibility = View.VISIBLE
            binding.ivStartPause.setImageDrawable(getDrawable(R.drawable.pause01))

        }

        binding.btnPause.setOnClickListener {
            zamaniDurdur = binding.kronometre.base - SystemClock.elapsedRealtime()
            binding.kronometre.stop()
            binding.btnPause.visibility = View.GONE
            binding.btnStart.visibility = View.VISIBLE
            binding.ivStartPause.setImageDrawable(getDrawable(R.drawable.start02))

        }

        binding.btnReset.setOnClickListener {
            binding.kronometre.base = SystemClock.elapsedRealtime()
            binding.kronometre.stop()
            zamaniDurdur = 0
            binding.btnPause.visibility = View.GONE
            binding.btnStart.visibility = View.VISIBLE
            binding.ivStartPause.setImageDrawable(getDrawable(R.drawable.start02))

        }
    }
}