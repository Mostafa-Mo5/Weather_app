package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.weatherapp.data.WeatherModel
import com.example.weatherapp.MainActivity.componian.TAG
import com.example.weatherapp.databinding.ActivityMainBinding
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val client = OkHttpClient().newBuilder().addInterceptor(MyInterceptor()).build()


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonFetch.setOnClickListener {
            makeRequestUsingOKHTTP(binding.lan.text.toString(),binding.lon.text.toString())
        }
    }
    private fun makeRequestUsingOKHTTP(lat :String , lon :String) {

        val url = HttpUrl.Builder()
            .scheme("https")
            .host("api.openweathermap.org")
            .addPathSegment("data/2.5/weather")
            .addQueryParameter("lat",lat)
            .addQueryParameter("lon",lon)
            .setQueryParameter("appid","7273ef06cfccd063055454a17302a291")
            .build()

        val request = Request.Builder().url(url).build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.i(TAG , "fail:${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                response.body?.string()?.let { jsonString ->
                    val result = Gson().fromJson(jsonString, WeatherModel::class.java)
                    Log.i(TAG,result.toString())
                    runOnUiThread {
                        binding.speed.text= result.wind?.speed?.toKM()

                        binding.country.text= result.country?.country

                        binding.city.text=result.name

                        binding.main.text= result.weather?.joinToString { it.main.toString() }

                        binding.degree.text = result.main?.temp?.toC()

                        binding.humidity.text = result.main?.humidity?.tom()

                        binding.description.text= result.weather?.joinToString { it.description.toString() }
                    }
                }
            }
        })
    }
    object componian{
        const val TAG = "MOSTAFA"
    }
}