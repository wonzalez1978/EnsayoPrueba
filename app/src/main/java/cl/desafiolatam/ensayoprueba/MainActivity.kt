package cl.desafiolatam.ensayoprueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadApiData()
    }

private fun loadApiData (){
    val service = RetrofitClient.retrofitInstance()
    val call = service.getProductos()
    call.enqueue(object : retrofit2.Callback<ArrayList<ListaProductosEntity>>{
        override fun onResponse(call: Call<ArrayList<ListaProductosEntity>>, response: Response<ArrayList<ListaProductosEntity>>) {
            Log.d("Main", "${response.isSuccessful}")
            Log.d("Main", "${response.body()}")
        }

        override fun onFailure(call: Call<ArrayList<ListaProductosEntity>>, t: Throwable) {
            Log.d("Main", "$t")
        }

    })
}
}