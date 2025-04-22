package com.hydra.axiommanager

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView

    private val urls = mapOf(
        R.id.nav_freeboard to "http://192.168.0.146:3000/@signalk/freeboard-sk/",
        R.id.nav_kip to "http://192.168.0.146:3000/@mxtommy/kip/#/page/0",
        R.id.nav_logbook to "http://192.168.0.146:3000/admin/#/e/_meri_imperiumi_signalk_logbook",
        R.id.nav_polars to "http://192.168.0.146:3000/signalk-polar-recorder/"
    )

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webview)
        val nav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        webSettings.useWideViewPort = true
        webSettings.loadWithOverviewMode = true
        webSettings.allowFileAccess = true
        webSettings.builtInZoomControls = true
        webSettings.displayZoomControls = false

        webView.webViewClient = WebViewClient()

        // Default tab
        webView.loadUrl(urls[R.id.nav_freeboard]!!)

        nav.setOnItemSelectedListener { item ->
            urls[item.itemId]?.let { url ->
                webView.loadUrl(url)
                true
            } ?: false
        }
    }
}
