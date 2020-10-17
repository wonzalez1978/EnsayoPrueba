package cl.desafiolatam.ensayoprueba

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.Response

class Repository(context: Context) {
    var productosDao: Dao = ProductosDatabase.getDatabase(context).dao()
    val getAll: LiveData<List<ListaProductosEntity>> = productosDao.getAll()

        fun loadApiData() {
        val service = RetrofitClient.retrofitInstance()
        val call = service.getProductos()
        call.enqueue(object : retrofit2.Callback<ArrayList<ListaProductosEntity>> {
            override fun onResponse(
                call: Call<ArrayList<ListaProductosEntity>>,
                response: Response<ArrayList<ListaProductosEntity>>
            ) {
                Log.d("Main", "${response.isSuccessful}")
                Log.d("Main", "${response.body()}")
            }

            override fun onFailure(call: Call<ArrayList<ListaProductosEntity>>, t: Throwable) {
                Log.d("Main", "$t")
            }

        })
    }
}