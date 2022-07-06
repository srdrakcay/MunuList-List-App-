package com.serdar.mnlist.view.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.serdar.mnlist.R
import com.serdar.mnlist.databinding.ActivitySignInBinding
import com.serdar.mnlist.view.bottomBar.HomeActivity

class SignInActivity : AppCompatActivity() {

    companion object{
        private const val RC_SIGN_IN=120
    }
    private lateinit var binding: ActivitySignInBinding
    private lateinit var mAuth: FirebaseAuth
    private lateinit var googleSignInClient:GoogleSignInClient
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivitySignInBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val gso =GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient= GoogleSignIn.getClient(this,gso)

        mAuth=FirebaseAuth.getInstance()
        binding.signinGoogle.setOnClickListener {
            signIn()
        }
    }
    private fun signIn(){
        val signInIntent=googleSignInClient.signInIntent
        startActivityForResult(signInIntent,RC_SIGN_IN)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

       if(requestCode== RC_SIGN_IN){
           val task =GoogleSignIn.getSignedInAccountFromIntent(data)
           val exception=task.exception
           if (task.isSuccessful){
               try {
                   val acccount=task.getResult(ApiException::class.java)
                   Log.d("SignInActivity","firebaseAuthWithGoogle:" + acccount.id)

                   firebaseAuthWithGoogle(acccount.idToken!!)


               }catch (e:ApiException){
                   Log.w("SignInActivity","Google Sign in Failed ",e)
               }
           }else{
               Log.w("SignInActivity",exception.toString() )
           }
       }
            }

    private fun firebaseAuthWithGoogle(idToken:String) {
        val credential=GoogleAuthProvider.getCredential(idToken, null)
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener (this){task ->
                if (task.isSuccessful){
                    Log.d("SignInActivity","signInWithCredentical::success")
                    val intent=Intent(this,HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    Log.w("SignInActivity","signInWithCredentical::failure",task.exception )

                }
            }
    }




}