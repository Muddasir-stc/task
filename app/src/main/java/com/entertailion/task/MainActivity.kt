package com.entertailion.task

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {


    //recycler view

    var recyclerview: RecyclerView? = null
    var adpater: MyAdapter? = null
    val data = ArrayList<DataClassItems>()
    var recyclerview2: RecyclerView? = null
    var adpater2: MyAdapter? = null
    val data2 = ArrayList<DataClassItems>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerview = findViewById<RecyclerView>(R.id.recyleview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel




        // This will pass the ArrayList to our Adapter
        adpater = MyAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adpater
        adpater!!.notifyDataSetChanged()


        // this creates a vertical layout Manager


        getDataFromApi()

    }

    //method to get Data from  APi
    fun getDataFromApi() {
        val thread = Thread {

            var url = URL("https://newsapi.org/v2/everything?q=india&apiKey=29647c86e8fc4bca959bb4aec5e2b39f")
            var con = url.openConnection()

            con.setRequestProperty("USER-AGENT", "Mozilla/5.0")

            con.setRequestProperty("Method", "GET")
            //urlConnection.connect()

            var inputStream = con.inputStream

            var allText = inputStream.bufferedReader().use { it.readText() }


            Log.e("alk86",allText)

            var jsonObject2 = JSONObject(allText)

            var dataArray = jsonObject2.getJSONArray("articles")
            var lengthF:Int =0
                 if(dataArray.length()>6)
                 {
                     lengthF = 5
                 }
               else
                 {
                     lengthF = dataArray.length()
                 }
                for (i in 0 until lengthF) {

                var jsonObject = dataArray.getJSONObject(i)
                     Log.e("value of Author",jsonObject.get("author") as String)
                data.add(DataClassItems(
                    jsonObject.get("description") as String,jsonObject.get("author") as String ,jsonObject.get("title") as String,
                    jsonObject.get("urlToImage") as String

                )


                )


            }

            Log.e("result",data.toString())

            runOnUiThread(Runnable() {
                adpater!!.notifyDataSetChanged()

            })
        }.start()

    }

    }






