package cl.desafiolatam.ensayoprueba

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ViewModel(application: Application) : AndroidViewModel(application) {
    val selected = MutableLiveData<ListaProductosEntity>()
    val repository: Repository = Repository(application)
    val getAll: LiveData<List<ListaProductosEntity>> = repository.getAll

    fun select(producto: ListaProductosEntity) {
        selected.value = producto

    }

    val respuesta = repository.loadApiData()

    fun obtenerValor() {
        repository.loadApiData()
    }

}