package com.example.viewmodelexample


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.viewmodelexample.CheckoutFragmentArgs
import com.example.viewmodelexample.Product
import com.example.viewmodelexample.R
import com.example.viewmodelexample.products
import kotlinx.android.synthetic.main.fragment_thanks.*

/**
 * A simple [Fragment] subclass.
 */
class ThanksFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thanks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var product: Product? = null
        arguments?.let{
            val args = CheckoutFragmentArgs.fromBundle(it)
            product = products.find {args.id == it.id }
        }

        product?.let{

            with(it){
                thanks.text = getString(R.string.thank_you_message, this.name)
                continue_shopping.setOnClickListener {
                    findNavController().navigate(R.id.action_thanks_to_home)
                }
            }
        }
    }

}
