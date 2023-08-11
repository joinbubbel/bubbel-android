package com.example.bubbel.view.app

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.bubbel.R
import com.example.bubbel.databinding.HomeScreenBinding
import com.example.bubbel.model.Club
import com.example.bubbel.model.HomeViewModel
import com.example.bubbel.viewmodel.app.ClubViewModel
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.InputStream

class HomeView: Fragment() {
    private lateinit var binding:HomeScreenBinding
    private  lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        val clubsAdapter = ClubsAdapter(context = requireContext(), dataSource = ArrayList())

        viewModel.clubs.observe(viewLifecycleOwner, Observer { club ->
            clubsAdapter.dataSource = club as ArrayList<Club>
            clubsAdapter.notifyDataSetChanged()
        })

        binding.recyclerView.adapter = clubsAdapter
    }
}


class ClubsAdapter(private val context: Context, var dataSource: ArrayList<Club>) :
    RecyclerView.Adapter<ClubsAdapter.ClubViewHolder>() {

    class ClubViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageTextView: TextView = itemView.findViewById(R.id.image)
        val titleTextView: TextView = itemView.findViewById(R.id.title)
        val isVerfiedTextView: TextView = itemView.findViewById(R.id.isVerified)
        val membersOnlineTextView: TextView = itemView.findViewById(R.id.membersOnline)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.club_item, parent, false)
        return ClubViewHolder(view)
    }

    override fun getItemCount(): Int = dataSource.size

    override fun onBindViewHolder(holder: ClubViewHolder, position: Int) {
        val club = dataSource[position]
        holder.imageTextView.text = club.image
        holder.titleTextView.text = club.title
        holder.isVerfiedTextView.text = club.isVerified.toString()
        holder.membersOnlineTextView.text = club.membersOnline
    }
}
