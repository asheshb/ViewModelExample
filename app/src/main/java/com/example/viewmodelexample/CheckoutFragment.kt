package com.example.fragmentnavigation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.viewmodelexample.Product
import com.example.viewmodelexample.R
import com.example.viewmodelexample.products
import kotlinx.android.synthetic.main.fragment_checkout.*


/**
 * A simple [Fragment] subclass.
 */
class CheckoutFragment : Fragment() {
    private var quantity = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_checkout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var product: Product? = null
        arguments?.let{
            val args = CheckoutFragmentArgs.fromBundle(it)
            product = products.find {args.id == it.id }
        }

        product?.let{

            with(it){
                product_name.text = name
                product_price.text = getString(R.string.product_price, price)
                product_quantity.text = getString(R.string.product_quantity, quantity)
                order_total.text = getString(R.string.order_total, price)
                product_image.setImageResource(imageId)

                checkout.setOnClickListener {
                    findNavController().navigate(CheckoutFragmentDirections.actionCheckoutToThanks(this.id))
                }
            }
        }

        add_quantity.setOnClickListener{
            quantity++
            product_quantity.text = getString(R.string.product_quantity, quantity)
        }

        reduce_quantity.setOnClickListener{
            if(quantity > 1){
                quantity--
                product_quantity.text = getString(R.string.product_quantity, quantity)
            }
        }
    }
}
