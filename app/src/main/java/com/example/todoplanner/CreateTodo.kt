package com.example.todoplanner


import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_create_todo.*
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 */
class CreateTodo : Fragment(), View.OnClickListener {

    private var navController: NavController? = null

    lateinit var todoViewModel: TodoViewModel

    val TAG = "Craete Todo"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_create_todo, container, false)
        todoViewModel = activity?.run {
            ViewModelProviders.of(this)[TodoViewModel::class.java]
        }?: throw Exception("Invalid Activity")

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.btn_add_todo).setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.btn_add_todo -> {
                if(!TextUtils.isEmpty(edit_title.text.toString())) {
                    val todo = ToDo(edit_title.text.toString(),
                                    edit_description.text.toString(),
                                    edit_date.text.toString())
                    todoViewModel.insert(todo)
                    navController!!.navigate(R.id.action_createTodo_to_mainFragment)
                }else{
                    Toast.makeText(activity, "Invalid ToDo", Toast.LENGTH_LONG).show()
                }
            }
        }
    }


}
