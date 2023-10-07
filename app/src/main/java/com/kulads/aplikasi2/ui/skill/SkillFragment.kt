package com.kulads.aplikasi2.ui.skill

import android.app.DownloadManager.Query
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kulads.aplikasi2.R
import java.util.Locale
import java.util.Queue

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private lateinit var recyclerView: RecyclerView
private lateinit var searchView: SearchView
private var mutableList = ArrayList<LanguageData>()
private lateinit var adapter: LeagueAdapter



/**
 * A simple [Fragment] subclass.
 * Use the [SkillFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SkillFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        recyclerView = findViewById(R.id.recyle_view)
        searchView = findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        addDataToList()
        adapter = LeagueAdapter(mutableList)
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                filterList(newText)
                return true
            }

        })
    }
    private fun filterList(query : String?){

        if(query != null){
            val  filterlist = ArrayList<LanguageData>()
            for (i in mutableList){
                if (i.title.lowercase(Locale.ROOT).contains(query)){
                    filterlist.add(i)
                }
            }

            if(filterlist.isEmpty()){
                Toast.makeText(this, "No Data found" , Toast.LENGTH_SHORT).show()
            }else{
                adapter.setFilteredList(filterlist)
            }
        }
    }

    private fun addDataToList(){
        mutableList.add(LanguageData("HTML" , R.drawable.html))
        mutableList.add(LanguageData("CSS" , R.drawable.css))
        mutableList.add(LanguageData("JavaScript" , R.drawable.javascript))
        mutableList.add(LanguageData("Java" , R.drawable.java))
        mutableList.add(LanguageData("MySQL" , R.drawable.mysql))
        mutableList.add(LanguageData("Kotlin" , R.drawable.kotlin))
        mutableList.add(LanguageData("PHP" , R.drawable.php))
        mutableList.add(LanguageData("Bootstrap" , R.drawable.bootstrap))
        mutableList.add(LanguageData("PhotoShop" , R.drawable.photoshop))
        mutableList.add(LanguageData("Figma" , R.drawable.figma))
    }
    private fun setContentView(activityMain: Int) {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skill, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SkillFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SkillFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}