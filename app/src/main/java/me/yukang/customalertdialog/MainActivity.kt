package me.yukang.customalertdialog

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val builder = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.custom_dialog, null)
        val etNumber = dialogView.findViewById<EditText>(R.id.et_number)

        builder.setView(dialogView)
        builder.setCancelable(false)
        builder.setPositiveButton("validate", { _: DialogInterface?, _: Int -> })
        val customDialog = builder.create()
        customDialog.show()
        customDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener({
            if (etNumber.text.length > 5) customDialog.dismiss()
            else Toast.makeText(baseContext, "Number is not valid!", Toast.LENGTH_SHORT).show()
        })
    }
}
