package cl.desafiolatam.ensayoprueba

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class ViewModel (application: Application) : AndroidViewModel(application) {
val getAll : LiveData<List<ListaProductosEntity>> = repository
}