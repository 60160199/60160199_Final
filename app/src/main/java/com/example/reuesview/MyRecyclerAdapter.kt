package com.example.reuesview

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.json.JSONArray


class MyRecyclerAdapter (fragmentActivity: FragmentActivity, val dataSource: JSONArray) : RecyclerView.Adapter<MyRecyclerAdapter.Holder>() {

    private val thisContext: Context = fragmentActivity.baseContext
    private val thisActivity = fragmentActivity

//    private val thiscontext : Context = context
//    private val fragment: FragmentManager = fm

    class Holder(view : View) : RecyclerView.ViewHolder(view) {

        private val View = view;

        lateinit var layout : LinearLayout
        lateinit var titleTextView: TextView
        lateinit var detailTextView: TextView
        lateinit var image: ImageView

        fun Holder(){

            layout = View.findViewById<View>(R.id.recyview_layout) as LinearLayout
            titleTextView = View.findViewById<View>(R.id.tv_name) as TextView
            detailTextView = View.findViewById<View>(R.id.tv_description) as TextView
            image = View.findViewById<View>(R.id.imgV) as ImageView

        }


    }

    override fun onCreateViewHolder(parent : ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.recy_layout, parent, false))
    }


    override fun getItemCount(): Int {
        return dataSource.length()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.Holder()

        holder.titleTextView.setText( dataSource.getJSONObject(position).getString("login").toString() )
        holder.detailTextView.setText( dataSource.getJSONObject(position).getString("node_id").toString() )

        Glide.with(thisContext)
            .load(dataSource.getJSONObject(position).getString("avatar_url").toString())
            .into(holder.image)



   holder.layout.setOnClickListener{

       // สร้าง Dialog
       val builder: AlertDialog.Builder = AlertDialog.Builder(thisActivity)
       // กำหนดข้ิอความให้ Dialog
       builder.setMessage(
           "แสดงข้อมูลของคุณ ${holder.titleTextView.text}"
       )

       // กำหนดปุ่มยืนยัน
       builder.setPositiveButton("ตกลง") { _, _ ->
           Toast.makeText(thisContext, holder.detailTextView.text, Toast.LENGTH_SHORT).show()
       }

       // กำหนดปุ่มยกเลิก
       builder.setNegativeButton("ยกเลิก") { _, _ ->
           Toast.makeText(thisContext, "ขอบคุณครับ", Toast.LENGTH_SHORT).show()
       }

       // แสดง Dialog
       builder.show()
       // Toast.makeText(thisContext,holder.text1.text.toString(),Toast.LENGTH_SHORT).show()
//
//          Toast.makeText(thiscontext,holder.titleTextView.text.toString(),Toast.LENGTH_SHORT).show()
//
//          val head:String = dataSource.getJSONObject(position).getString("login").toString()
//          val body:String = dataSource.getJSONObject(position).getString("node_id").toString()
//          val img:String = dataSource.getJSONObject(position).getString("avatar_url").toString()
//
//          val item_selected = item_selected().newInstance(head,body,img)
//          val transaction : FragmentTransaction = fragment.beginTransaction()
//          transaction.replace(R.id.layout, item_selected,"item_selected")
//          transaction.addToBackStack("item_selected")
//          transaction.commit()
//           Toast.makeText(thiscontext,holder.titleTextView.text.toString(),Toast.LENGTH_SHORT).show()
      }

    }







}
