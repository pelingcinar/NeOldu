package com.pelingulcinar.neoldu

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val url = "http://api.sonraneoldu.com/v2/tags/1/stories"

        

        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
                Response.Listener { response ->
                    val myText = response.getJSONArray("data")
                            .getJSONObject(0)
                            .getJSONArray("images")
                            .getJSONObject(0)
                            .getString("baseUrl")

                    textSummary.text = myText
                },
                Response.ErrorListener { error ->
                    Toast.makeText(this, "OPS!", Toast.LENGTH_SHORT).show()
                }
        )

        Volley.newRequestQueue(this).add(jsonObjectRequest)
        Volley.newRequestQueue(this).start()
        //run

    }
}
