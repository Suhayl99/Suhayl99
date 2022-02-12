package uz.itech.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import okhttp3.OkHttpClient
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import uz.itech.myapplication.api.Api
import uz.itech.myapplication.databinding.ActivityMainBinding
import uz.itech.myapplication.model.PostModel
import uz.itech.myapplication.view.PostAdapter
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var api:Api

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MyApp.app.appComponent.inject(this)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floating.setOnClickListener {
            startActivity(Intent(this,GalleryActivity::class.java))
        }

//        val retrofit= Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
//            .client(OkHttpClient.Builder().build()).addConverterFactory(GsonConverterFactory.create()).build()
//        val api = retrofit.create(Api::class.java)
            binding.recycler.layoutManager=LinearLayoutManager(this)
        api.getPosts().enqueue(object : Callback<List<PostModel>>{
            override fun onResponse(
                call: Call<List<PostModel>>,
                response: Response<List<PostModel>>
            ) {
                if (api != null){
                    binding.recycler.adapter=PostAdapter(response.body()?: emptyList())
                }
            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                Toast.makeText(this@MainActivity,t.localizedMessage, Toast.LENGTH_LONG).show()
            }
        })
    }
}