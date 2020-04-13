package com.example.musicalapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_history, R.id.navigation_mail))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


    }

    //menuの表示
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.web -> {
                val uri: String = "https://sugiope.org/活動内容/ミュージカルの活動説明/"
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(uri)
                if (intent.resolveActivity(packageManager) != null){
                    startActivity(intent)
                }
                return true
            }
            R.id.twitter -> {
                val uri: String = "https://twitter.com/web_pool?lang=ja"
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(uri)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
                return true
            }
            R.id.mail -> {
                val email = "anandpita18@icloud.com"
                val subject = "問い合わせ"
                val text = "以下のとおり質問します"
                val uri = Uri.parse("mailto:")
                val intent = Intent(Intent.ACTION_SENDTO)
                intent.data = uri
                intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
                    .putExtra(Intent.EXTRA_SUBJECT,subject)
                    .putExtra(Intent.EXTRA_TEXT, text)
                if (intent.resolveActivity(packageManager) != null){
                    startActivity(intent)
                }
                return true
            }
            R.id.sms ->{
                val number = "03-3380-1042"
                val uri = Uri.parse("sms:$number")
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = uri
                startActivity(intent)
                return true
            }




        }

        return super.onOptionsItemSelected(item)
    }
}
