package com.vogella.retrofitapp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listUrl = ArrayList<String>()
        CoroutineScope(Dispatchers.IO).launch {
            RetrofitClient.instance
                .getPhotosAsync()
                .await()
                .body()
                ?.forEach {
                    listUrl.add(it.download_url)
                }
        }
        imageView.setOnClickListener{
            Picasso.get()
                .load(listUrl[Random.nextInt(listUrl.size-1)])
                .into(imageView)
        }
    }
}