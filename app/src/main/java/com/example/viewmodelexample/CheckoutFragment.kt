package com.example.viewmodelexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_checkout.*


/**
 * A simple [Fragment] subclass.
 */
class CheckoutFragment : Fragment() {
    private lateinit var viewModel: CheckoutViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_checkout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val id = CheckoutFragmentArgs.fromBundle(requireArguments()).id

        val viewModelFactory = CheckoutViewModelFactory(id, 1)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(CheckoutViewModel::class.java)

        setData(viewModel.product)

        add_quantity.setOnClickListener{
            viewModel.addQty(1)
            product_quantity.text = getString(R.string.product_quantity, viewModel.qty)
        }

        reduce_quantity.setOnClickListener{
            viewModel.reduceQty(1)
            product_quantity.text = getString(R.string.product_quantity, viewModel.qty)
        }

    }

    private fun setData(product: Product?){
        product?.run{
            product_name.text = name
            product_price.text = getString(R.string.product_price, price)
            product_quantity.text = getString(R.string.product_quantity, viewModel.qty)
            order_total.text = getString(R.string.order_total, price)
            product_image.setImageResource(imageId)

            checkout.setOnClickListener {
                findNavController().navigate(CheckoutFragmentDirections.actionCheckoutToThanks(this.id))
            }
        }
    }
}
