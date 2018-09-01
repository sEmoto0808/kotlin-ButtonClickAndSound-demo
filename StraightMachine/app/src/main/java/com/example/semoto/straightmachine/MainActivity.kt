package com.example.semoto.straightmachine

import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var soundPool:SoundPool

    var soundId_Omedetou = 0
    var soundId_Fugoukaku = 0
    var soundId_Ganba = 0
    var soundId_Goukaku = 0
    var soundId_Yokudekimashita = 0
    var soundId_Zannen = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            soundPool.play(soundId_Omedetou, 1.0f, 1.0f, 0, 0, 1.0f)
        }
        button2.setOnClickListener {
            soundPool.play(soundId_Yokudekimashita, 1.0f, 1.0f, 0, 0, 1.0f)
        }
        button3.setOnClickListener {
            soundPool.play(soundId_Goukaku, 1.0f, 1.0f, 0, 0, 1.0f)
        }
        button4.setOnClickListener {
            soundPool.play(soundId_Fugoukaku, 1.0f, 1.0f, 0, 0, 1.0f)
        }
        button5.setOnClickListener {
            soundPool.play(soundId_Zannen, 1.0f, 1.0f, 0, 0, 1.0f)
        }
        button6.setOnClickListener {
            soundPool.play(soundId_Ganba, 1.0f, 1.0f, 0, 0, 1.0f)
        }
    }

    override fun onResume() {
        super.onResume()

        soundPool = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            SoundPool.Builder().setAudioAttributes(AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build())
                    .setMaxStreams(1)
                    .build()
        } else {
            SoundPool(1, AudioManager.STREAM_MUSIC, 0)
        }

        soundId_Omedetou = soundPool.load(this, R.raw.omedetougozaimasu1, 1)
        soundId_Fugoukaku = soundPool.load(this, R.raw.fugoukakudesu1, 1)
        soundId_Ganba = soundPool.load(this, R.raw.ganbarimasyou1, 1)
        soundId_Goukaku = soundPool.load(this, R.raw.goukakudesu1, 1)
        soundId_Yokudekimashita = soundPool.load(this, R.raw.yokudekimashita1, 1)
        soundId_Zannen = soundPool.load(this, R.raw.zannendeshita1, 1)
    }

    override fun onPause() {
        super.onPause()

        soundPool.release()
    }
}
