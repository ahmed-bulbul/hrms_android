package com.walton.smarthrm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.walton.smarthrm.databinding.UserLayoutBinding
import com.walton.smarthrm.model.User2

class UserListAdapter(
    var userList: List<User2>
) :
    RecyclerView.Adapter<UserListAdapter.ViewHolder>() {
    private lateinit var clickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(
            user: User2
        )
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        clickListener = listener
    }

    inner class ViewHolder(val binding: UserLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = UserLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(userList[position]) {

                binding.userName.text = this.username
                binding.userTitle.text = this.userTitle
                binding.userOrganization.text = this.organization
                binding.userEmail.text = this.email
                binding.userPhone.text = this.phone


                /*binding.mainCL.setOnClickListener {
                    clickListener.onItemClick(
                        this
                    )
                }*/
            }
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}