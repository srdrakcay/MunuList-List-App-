package com.serdar.mnlist.view.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.serdar.mnlist.R
import com.serdar.mnlist.databinding.FragmentSplashBinding
import com.serdar.mnlist.view.bottomBar.HomeActivity
import com.serdar.mnlist.view.login.SignInActivity


class SplashFragment : Fragment() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var binding:FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    binding=FragmentSplashBinding.inflate(layoutInflater)
        mAuth=FirebaseAuth.getInstance()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val user = mAuth.currentUser

         Handler().postDelayed({
     if(user !=null) {
         val intent=Intent(requireActivity(),HomeActivity::class.java)
         startActivity(intent)
     } else{
         val intent=Intent(requireActivity(),SignInActivity::class.java)
         startActivity(intent)

     }

    },3000)


    }

}