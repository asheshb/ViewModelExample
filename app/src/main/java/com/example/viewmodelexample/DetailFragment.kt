package com.example.viewmodelexample


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.viewmodelexample.DetailFragmentArgs
import com.example.viewmodelexample.DetailFragmentDirections
import com.example.viewmodelexample.Product
import com.example.viewmodelexample.R
import com.example.viewmodelexample.products
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.list_item.*

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var product: Product? = null

//        val id = arguments?.getInt("ID")
//        id?.let {
//            product = products.find { it.id == id }
//        }

        arguments?.let{
            val args = DetailFragmentArgs.fromBundle(it)
            product = products.find {args.id == it.id }
        }

        product?.let{
            with(it){
                product_name.text = name
                product_price.text = getString(R.string.product_price, price)
                product_description.text = shortDescription
                product_full_description.text = longDescription
                product_image.setImageResource(imageId)

                buy.setOnClickListener {
                    findNavController().navigate(DetailFragmentDirections.actionDetailToCheckout(this.id))
                }
            }
        }
    }
}
