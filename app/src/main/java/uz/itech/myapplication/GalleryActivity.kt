package uz.itech.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import okhttp3.OkHttpClient
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import uz.itech.myapplication.api.Api
import uz.itech.myapplication.databinding.ActivityGalleryBinding
import uz.itech.myapplication.model.PhotoModel
import uz.itech.myapplication.view.PhotoAdapter

class GalleryActivity : AppCompatActivity() {
    lateinit var binding:ActivityGalleryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recycler.layoutManager=GridLayoutManager(this,2)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .client(OkHttpClient.Builder().build()).addConverterFactory(GsonConverterFactory.create()).build()

        val api = retrofit.create(Api::class.java)
        api.getPhotos().enqueue(object : Callback<List<PhotoModel>>{
            override fun onResponse(
                call: Call<List<PhotoModel>>,
                response: Response<List<PhotoModel>>
            ) {
               if (api != null){
                   binding.recycler.adapter=PhotoAdapter(response.body()?: emptyList())
               }
            }

            override fun onFailure(call: Call<List<PhotoModel>>, t: Throwable) {
               Toast.makeText(this@GalleryActivity,t.localizedMessage, Toast.LENGTH_LONG).show()
            }
        })
    }
}