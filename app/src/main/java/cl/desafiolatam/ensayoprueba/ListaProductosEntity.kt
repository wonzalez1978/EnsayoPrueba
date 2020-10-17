package cl.desafiolatam.ensayoprueba

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "productos_tabla")
data class ListaProductosEntity (
    @PrimaryKey val idProducto : Int,
    val id : Int,
    val name : String,
    val price : Int,
    val image : String)