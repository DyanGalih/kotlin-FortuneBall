package com.dyangalih.kotlin

import android.media.Image
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo

import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var fortuneList = arrayOf("Don’t count on it", "Ask again later", "You may rely on it", "Without a doubt", "Outlook not so good", "It's decidedly so", "Signs point to yes", "Yes definitely", "Yes", "My sources say NO")
    private lateinit var fortuneText:TextView
    private lateinit var generateFortuneButton: Button
    private lateinit var fortuneBallImage: ImageView

    override fun onClick(v: View?) {
        val index = Random().nextInt(fortuneList.size)
        fortuneText.text = fortuneList[index]
        YoYo.with(Techniques.Swing)
                .duration(500)
                .playOn(fortuneBallImage)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        fortuneText = findViewById(R.id.fortuneText)
        fortuneBallImage = findViewById(R.id.fortunateImage)
        generateFortuneButton = findViewById(R.id.fortuneButton)

        generateFortuneButton.setOnClickListener(this)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "First Application Use Kotlin", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
