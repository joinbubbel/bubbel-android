package com.example.bubbel.view.app

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bubbel.R
import com.example.bubbel.databinding.ClubItemBinding
import com.example.bubbel.databinding.HomeScreenBinding
import com.example.bubbel.model.Club
import com.example.bubbel.model.HomeViewModel
import com.example.bubbel.model.HomeViewModelFactory
import com.example.bubbel.repository.ClubRepository
import com.example.bubbel.viewmodel.app.ClubViewModel
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.InputStream

class HomeView: Fragment() {
    private lateinit var binding: HomeScreenBinding
    lateinit var viewModel: HomeViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val repository = ClubRepository()
        binding = HomeScreenBinding.inflate(inflater, container, false)
        val viewModelFactory = HomeViewModelFactory(repository, requireActivity().application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)

        val recyclerView: RecyclerView = binding.clubRecycleView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ClubAdapter(clubList = viewModel.loadData())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}


class ClubAdapter(private val clubList: List<Club>): RecyclerView.Adapter<ClubAdapter.ViewHolder>(){
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image:ImageView = itemView.findViewById(R.id.club_image)
        val title:TextView = itemView.findViewById(R.id.title)
        val verified:ImageView = itemView.findViewById(R.id.is_verified)
        val memberCount:TextView = itemView.findViewById(R.id.membersOnline)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.club_item, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val club = clubList[position]
        holder.memberCount.text = club.membersOnline.toString()
        holder.title.text = club.title
        holder.image.setImageResource(R.drawable.club_test)
        if (club.isVerified) {
            holder.verified.visibility = View.VISIBLE
        } else {
            holder.verified.visibility = View.INVISIBLE
        }
    }


    override fun getItemCount() = clubList.size
}