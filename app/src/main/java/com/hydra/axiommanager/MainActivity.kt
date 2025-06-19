package com.hydra.axiommanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private val titles = listOf("Freeboard", "KIP", "Logbook", "Polars", "Node-RED", "Grafana")
    private val urls = listOf(
        "http://192.168.0.146:3000/@signalk/freeboard-sk/",
        "http://192.168.0.146:3000/@mxtommy/kip/#/page/0",
        "http://192.168.0.146:3000/admin/#/e/_meri_imperiumi_signalk_logbook",
        "http://192.168.0.146:3000/polar-recorder/",
        "http://192.168.0.146:3000/plugins/signalk-node-red/redApi/ui/",
        "http://192.168.0.146:3001/d/befj85vejfke8c/temperature?orgId=1&from=now-24h&to=now&timezone=browser&refresh=auto&kiosk"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val tabLayout: TabLayout = findViewById(R.id.tabLayout)

        viewPager.isUserInputEnabled = false;

        viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = urls.size
            override fun createFragment(position: Int): Fragment {
                return WebViewFragment.newInstance(urls[position])
            }
        }

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = titles[position]
        }.attach()
    }
}
