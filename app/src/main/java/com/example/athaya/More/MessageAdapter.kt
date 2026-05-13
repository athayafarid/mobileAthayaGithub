package com.example.athaya.More

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bumptech.glide.Glide
import com.example.athaya.Message.MessageModel
import com.example.athaya.databinding.ItemMessageBinding

class MessageAdapter(private val context: Context, private val messages: List<MessageModel>) : BaseAdapter() {

    override fun getCount(): Int = messages.size

    override fun getItem(position: Int): Any = messages[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding: ItemMessageBinding
        val view: View

        if (convertView == null) {
            binding = ItemMessageBinding.inflate(LayoutInflater.from(context), parent, false)
            view = binding.root
            view.tag = binding
        } else {
            binding = convertView.tag as ItemMessageBinding
            view = convertView
        }

        val message = messages[position]
        binding.textSender.text = message.senderName
        binding.textMessage.text = message.messageText

        Glide.with(context)
            .load(message.avatarUrl)
            .into(binding.avatarImg)

        return view
    }
}
