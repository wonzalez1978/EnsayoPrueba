package cl.desafiolatam.ensayoprueba

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ListaProductosEntity::class], version = 1)

public abstract class ProductosDatabase : RoomDatabase() {
    abstract fun dao(): Dao

    companion object {
        @Volatile
        private var INSTANCE: ProductosDatabase? = null

        fun getDatabase(context: Context): ProductosDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, ProductosDatabase::class.java, "word_database"
                ).build()
                INSTANCE = instance
                return instance
            }

        }
    }

    class ProductosApp : Application() {
        companion object {
            lateinit var database: ProductosDatabase
        }

        override fun onCreate() {
            super.onCreate()
            ProductosApp.database =
                Room.databaseBuilder(this, ProductosDatabase::class.java, "buen_nombre").build()
        }
    }
}