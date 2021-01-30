package com.example.toscdf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Layout
import android.view.ContextMenu
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.first_page.*
import kotlinx.android.synthetic.main.fish.*
import kotlinx.android.synthetic.main.register_page.*
import com.example.toscdf.database as toscdfDatabase

class MainActivity : AppCompatActivity() {

    lateinit var handler: com.example.toscdf.database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        handler = com.example.toscdf.database(context = this)
        setContentView(R.layout.first_page)
        var username = findViewById(R.id.username) as EditText
        var password = findViewById(R.id.password) as EditText
        var login = findViewById(R.id.login) as Button
        var newregister = findViewById(R.id.newregister) as Button

        login.setOnClickListener()
        {
            Toast.makeText(this, "login sucessful", Toast.LENGTH_SHORT).show()
            if (handler.userpresent(email.text.toString(), password.text.toString())) {
                Toast.makeText(this, "login sucessful", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "incorrect username or password", Toast.LENGTH_SHORT).show()
            }
        }

        newregister.setOnClickListener()
        {
            setContentView(R.layout.register_page)
            var email = findViewById(R.id.email) as EditText
            var password = findViewById(R.id.password) as EditText
            var confirm_password = findViewById(R.id.confirm_password) as EditText
            var number = findViewById(R.id.number) as EditText
            var role = findViewById(R.id.role) as Button
            var register = findViewById(R.id.register) as Button
            var role_s: String = "null"

            role.setOnClickListener() {
                setContentView(R.layout.fish)
                var fisherman = findViewById(R.id.fisherman) as Button
                fisherman.setOnClickListener() {
                    role_s = "fisherman"
                }
                var first_processor = findViewById(R.id.first_processor) as Button
                first_processor.setOnClickListener() {
                    role_s = "first processor"
                }
                var processor = findViewById(R.id.processor) as Button
                processor.setOnClickListener() {
                    role_s = "processor"
                }
                var distributor = findViewById(R.id.distributor) as Button
                distributor.setOnClickListener() {
                    role_s = "distributor"
                }
                var retailer = findViewById(R.id.retailer) as Button
                retailer.setOnClickListener() {
                    role_s = "retailer"
                }
                var customer = findViewById(R.id.customer) as Button
                customer.setOnClickListener() {
                    role_s = "customer"
                }

            }
            register.setOnClickListener() {
                handler.dataentry(
                    email.text.toString(),
                    password.text.toString(),
                    confirm_password.text.toString(),
                    number.text.toString(),
                    role_s.indices.toString()
                )

            }

        }
    }
}