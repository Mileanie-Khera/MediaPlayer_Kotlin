package com.example.mediaplayer




import android.net.Uri
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView
import dagger.hilt.android.AndroidEntryPoint
import com.google.android.exoplayer2.MediaItem

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var playerView : PlayerView
    private lateinit var player : SimpleExoPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playerView = findViewById(R.id.playerView)
        player = SimpleExoPlayer.Builder(this).build()
        playerView.player = player

        val mediaItem = MediaItem.fromUri(
            Uri.parse("android.resource://" + packageName + "/" + R.raw.sample_music)
        )
        player.setMediaItem(mediaItem)
        player.prepare()
        player.play()

    }

    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }

}