package ru.netology.yandexmapmarkers.activity

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.yandex.mapkit.MapKitFactory
import dagger.hilt.android.AndroidEntryPoint
import ru.netology.yandexmapmarkers.R
import javax.annotation.Nullable


@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

//    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
//        override fun handleOnBackPressed() {
////            val i = 1
////            if (supportFragmentManager.backStackEntryCount > 1) {
////                supportFragmentManager.popBackStack();
////            } else {
//////                finish();
////            }
//        }
//    }

//    override fun registerReceiver(
//        @Nullable receiver: BroadcastReceiver?,
//        filter: IntentFilter?
//    ): Intent? {
//        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//            super.registerReceiver(receiver, filter, RECEIVER_NOT_EXPORTED)
//        } else {
//            super.registerReceiver(receiver, filter)
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
        MapKitFactory.initialize(this)
    }
}
