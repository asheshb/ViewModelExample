package com.example.fragmentnavigation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viewmodelexample.R
import com.example.viewmodelexample.products

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?  = inflater.inflate(R.layout.fragment_list, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val productList = view.findViewById<RecyclerView>(R.id.product_list).apply {

            layoutManager = LinearLayoutManager(activity)

            adapter = ProductAdapter{

//                val bundle = Bundle()
//                bundle.putInt("ID", it.id)
//                findNavController().navigate(R.id.action_home_to_detail, bundle)
                findNavController().navigate(ListFragmentDirections.actionHomeToDetail(it.id))
            }
            setHasFixedSize(true)
        }
        (productList.adapter as ProductAdapter).submitList(products)
    }
}
