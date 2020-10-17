package cl.desafiolatam.ensayoprueba

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_producto.*
import java.lang.reflect.Array
import java.lang.reflect.Array.newInstance
import javax.xml.datatype.DatatypeFactory.newInstance

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ProductoFragment : Fragment() {

    private lateinit var productosAdapter: ProductosAdapter
    val productosViewModel: ViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_producto, container, false)

        productosAdapter = ProductosAdapter(mutableListOf<ListaProductosEntity>())
        productosViewModel.obtenerValor()
        productosViewModel.getAll.observe(viewLifecycleOwner, Observer {
            Log.d("ProductoFragment", "++++++++++++++++++++++++++++++++++++++++")
            productosAdapter.updateAdapter(it as ArrayList<ListaProductosEntity>)
        })
        productosAdapter.productoSelected.observe(viewLifecycleOwner, Observer {
            productosViewModel.select(it)
           // requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container_fragment, Fragment_Producto_Details,"detalle").addToBackStack(" ").commit()
        })



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = recyclerListaProductos
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = productosAdapter
    }
}