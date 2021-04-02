package ru.lnv.smediabox.screen.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import ru.lnv.smediabox.R
import ru.lnv.smediabox.databinding.FragmentLoginBinding
import ru.lnv.smediabox.extensions.APP_ACTIVITY
import ru.lnv.smediabox.extensions.EMAIL
import ru.lnv.smediabox.extensions.PASSWORD
import ru.lnv.smediabox.extensions.TYPE_FIREBASE

class LoginFragment : Fragment(R.layout.fragment_login) {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var mViewModel: LoginFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onStart() {
        super.onStart()
        initializaton()
    }

    private fun initializaton(){
        mViewModel =ViewModelProvider(this).get(LoginFragmentViewModel::class.java)

        binding.loginBtnEnter.setOnClickListener {
            val inputEmail = binding.inputEmail.text.toString()
            val inputPassword = binding.inputPassword.text.toString()
            if (inputEmail.isNotEmpty() && inputPassword.isNotEmpty()){
                EMAIL = inputEmail
                PASSWORD = inputPassword
                mViewModel.initDatabase(TYPE_FIREBASE){
                    APP_ACTIVITY.mVavController.navigate(R.id.action_loginFragment_to_movieFragment)
                }
            }else{
                Toast.makeText(APP_ACTIVITY, "input email and password", Toast.LENGTH_SHORT).show()
            }

        }
    }

}