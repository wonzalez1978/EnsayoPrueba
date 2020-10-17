package cl.desafiolatam.ensayoprueba

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_producto.view.*

class ProductosAdapter(private val productosdataset: MutableList<ListaProductosEntity>) :
    RecyclerView.Adapter<ProductosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val lista =
            LayoutInflater.from(parent.context).inflate(R.layout.item_producto, parent, false)
        return ViewHolder(lista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nombre.text = productosdataset[position].name
        holder.precio.text = productosdataset[position].price.toString()
        Picasso.get().load(productosdataset[position].image).into(holder.image)
    }

    override fun getItemCount(): Int {
        return productosdataset.size
    }

    fun updateAdapter(listaProductos: ArrayList<ListaProductosEntity>) {
        productosdataset.clear()
        productosdataset.addAll(listaProductos)
        notifyDataSetChanged()

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombre: TextView = itemView.tvmodel
        val precio: TextView = itemView.tvprecio
        val image: ImageView = itemView.ivmodel
    }
}