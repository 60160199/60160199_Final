package com.example.reuesview


import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.layout_dialog.view.*

/**
 * A simple [Fragment] subclass.
 */
class item_selected : Fragment() {

    private var head : String = ""
    private var body : String = ""
    private var img : String = ""

    fun newInstance(head: String,body: String,img: String): item_selected {

        val fragment = item_selected()
        val bundle = Bundle()
        bundle.putString("head", head)
        bundle.putString("body", body)
        bundle.putString("img", img)
        fragment.setArguments(bundle)

        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = arguments
        if (bundle != null) {
            head = bundle.getString("head").toString()
            body = bundle.getString("body").toString()
            img = bundle.getString("img").toString()

        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_item_selected, container, false)
        val imgVi : ImageView = view.findViewById(R.id.imgV)
        val headTxt : TextView = view.findViewById(R.id.tv_name)
        val bodyTxt : TextView = view.findViewById(R.id.tv_description)

        val dialogBtn : Button = view.findViewById(R.id.dialogBtn)
        dialogBtn.setOnClickListener {
//                val builder: AlertDialog.Builder = AlertDialog.Builder(this.context)
//                builder.setMessage("รับขนมจีบซาลาเปาเพิ่มมั้ยครับ?")
//                builder.setPositiveButton("ตกลง",
//                    DialogInterface.OnClickListener { dialog, which ->
//                        Toast.makeText(context,"ขอบคุณที่กดเข้ามาดู", Toast.LENGTH_LONG).show()
//
//                    })
//                builder.setNegativeButton("ปิด",
//                    DialogInterface.OnClickListener { dialog, which ->
//                        //dialog.dismiss();
//                    })
//                builder.show()

            //Inflate the dialog with custom view
            val mDialogView = LayoutInflater.from(this.context).inflate(R.layout.layout_dialog, null)
            //AlertDialogBuilder
            val mBuilder = AlertDialog.Builder(this.context)
                .setView(mDialogView)
                .setTitle("Detail Form")
            //show img
            Glide.with(activity!!.baseContext)
                .load(img)
                .into(mDialogView.imgV);
            mDialogView.tv_name.setText(head)
            mDialogView.tv_description.setText(body)

            //show dialog
            val  mAlertDialog = mBuilder.show()
            //login button click of custom layout
            mDialogView.dialogBtnY.setOnClickListener {
                //dismiss dialog
                mAlertDialog.dismiss()

            }
            //cancel button click of custom layout
            mDialogView.dialogBtnN.setOnClickListener {
                //dismiss dialog
                mAlertDialog.dismiss()
            }
        }

        headTxt.setText(head)
        bodyTxt.setText(body)
        Glide.with(activity!!.baseContext)
            .load(img)
            .into(imgVi);
        // Inflate the layout for this fragment

        return view
    }


}
