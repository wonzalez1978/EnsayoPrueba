package cl.desafiolatam.ensayoprueba

import retrofit2.Call
import retrofit2.http.GET

interface ProductosApi {

@GET("Himuravidal/FakeAPIdata/details")
fun getProductos ():Call <ArrayList<ListaProductosEntity>>
}