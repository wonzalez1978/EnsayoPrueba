package cl.desafiolatam.ensayoprueba

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface Dao {
    @Query("SELECT * FROM productos_tabla")
    fun getAll(): LiveData<List<ListaProductosEntity>>
}