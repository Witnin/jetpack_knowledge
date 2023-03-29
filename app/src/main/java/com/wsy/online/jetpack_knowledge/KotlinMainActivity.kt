//package com.wsy.online.jetpack_knowledge
//
//import android.os.Bundle
//import android.os.UserManager
//import android.text.TextUtils
//import android.view.MenuItem
//import androidx.appcompat.app.AppCompatActivity
//import androidx.lifecycle.Observer
//import androidx.navigation.NavController
//import androidx.navigation.findNavController
//import androidx.navigation.ui.AppBarConfiguration
//import androidx.navigation.ui.setupActionBarWithNavController
//import androidx.navigation.ui.setupWithNavController
//import com.google.android.material.bottomnavigation.BottomNavigationView
//import com.wsy.online.jetpack_knowledge.databinding.ActivityMainBinding
//import com.wsy.online.jetpack_knowledge.model.Destination
//import com.wsy.online.jetpack_knowledge.utils.AppConfig
//import com.wsy.online.jetpack_knowledge.utils.NavGraphBuilder
//
//class KotlinMainActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityMainBinding
//
//
//    private val navController: NavController? = null
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val navView: BottomNavigationView = binding.navView
//
//        val navController = findNavController(R.id.nav_host_fragment_activity_main)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
//
//        NavGraphBuilder.build(navController)
//
//        navView.setOnNavigationItemSelectedListener(this)
//
//    }
//
//    fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
//        val destConfig = AppConfig.getDestConfig()
//        val iterator: Iterator<Map.Entry<String, Destination>> = destConfig.entries.iterator()
//        //遍历 target destination 是否需要登录拦截
//        while (iterator.hasNext()) {
//            val (_, value) = iterator.next()
//            if (value != null && !UserManager.get()
//                    .isLogin() && value.needLogin && value.id === menuItem.itemId
//            ) {
//                UserManager.get().login(this).observe(this,
//                    Observer<Any?> { navView.setSelectedItemId(menuItem.itemId) })
//                return false
//            }
//        }
//        navController!!.navigate(menuItem.itemId)
//        return !TextUtils.isEmpty(menuItem.title)
//    }
//}