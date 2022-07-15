package com.serdar.mnlist.view.bottomBar

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.serdar.mnlist.R
import com.serdar.mnlist.databinding.FragmentProfileBinding
import com.serdar.mnlist.view.login.SignInActivity

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    binding=FragmentProfileBinding.inflate(layoutInflater)
        mAuth=FirebaseAuth.getInstance()
        val currentUser=mAuth.currentUser
        binding.idText.text=currentUser?.uid
        binding.nameT.text=currentUser?.displayName
        binding.mailText.text=currentUser?.email

        Glide
            .with(this)
            .load(currentUser?.photoUrl)
            .into(binding.imageView);

        binding.sigoutGoogle.setOnClickListener {
            mAuth.signOut()
            val intent= Intent(requireActivity(),SignInActivity::class.java)
            startActivity(intent)

        }

        return binding.root
    }

}
