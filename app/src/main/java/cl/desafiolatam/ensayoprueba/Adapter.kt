package cl.desafiolatam.ensayoprueba

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_producto.view.*

class ProductosAdapter(private var productosdataset: MutableList<ListaProductosEntity>) :
    RecyclerView.Adapter<ProductosAdapter.ViewHolder>() {

    val productoSelected = MutableLiveData<ListaProductosEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val lista =
            LayoutInflater.from(parent.context).inflate(R.layout.item_producto, parent, false)
        return ViewHolder(lista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nombre.text = productosdataset[position].name
        holder.precio.text = productosdataset[position].price.toString()
        Picasso.get().load(productosdataset[position].image).into(holder.image)
        holder.itemView.setOnClickListener {
            Log.d("AdapterClick", "${productosdataset[position]}")
            productoSelected.value = productosdataset[position]
        }
    }

    override fun getItemCount(): Int {
        return productosdataset.size
    }

    fun updateAdapter(listaProductos: ArrayList<ListaProductosEntity>?) {
        Log.d("Adapter", "${productosdataset.size}")

        notifyDataSetChanged()

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombre: TextView = itemView.tvmodel
        val precio: TextView = itemView.tvprecio
        val image: ImageView = itemView.ivmodel
    }
}