package com.smartvirtus.viot.ui.activities

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.smartvirtus.viot.MainActivity
import com.smartvirtus.viot.R
import com.smartvirtus.viot.domain.models.Room
import com.smartvirtus.viot.framework.InMemoryLocationPersistenceSource
import kotlinx.coroutines.NonCancellable.start


class RegisterRoomActivity : AppCompatActivity() {
    lateinit var roomNameBox: EditText;

    lateinit var numberPeopleBox: EditText;

    lateinit var numberArBox: EditText;

    lateinit var roomSizeBox: EditText;

    var isAllFieldsChecked = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_room)

        roomNameBox = findViewById<EditText>(R.id.name_box)

        numberPeopleBox = findViewById<EditText>(R.id.n_people_box)

        numberArBox = findViewById<EditText>(R.id.n_ar_box)

        roomSizeBox = findViewById<EditText>(R.id.room_size_box)

        var registerButton = findViewById<Button>(R.id.cadastro_de_sala_button)
        registerButton.setOnClickListener {

            isAllFieldsChecked = CheckAllFields()
            if (isAllFieldsChecked) {
                confirmRegisterRoom();
            }
        }

    }

    private fun CheckAllFields(): Boolean {
        if (roomNameBox.length() == 0) {
            roomNameBox.error = "This field is required"
            return false
        }
        if (numberPeopleBox.length() == 0) {
            numberPeopleBox.error = "This field is required"
            return false
        }
        if (numberArBox.length() == 0) {
            numberArBox.error = "This field is required"
            return false
        } else if (roomSizeBox.length() == 0) {
            roomSizeBox.error = "This field is required"
            return false
        }

        // after all validation return true.
        return true
    }

    private fun saveRoom() {
        val roomPersistence = InMemoryLocationPersistenceSource
        val room = Room(roomNameBox.text.toString(),
            numberPeopleBox.text.toString(),
            roomSizeBox.text.toString(),
            numberArBox.text.toString())

        roomPersistence.saveNewRoom(room)

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun confirmRegisterRoom() {
        val builder = AlertDialog.Builder(this, R.style.MyDialogTheme)
        builder.setTitle("Confirmar Cadastro")
        builder.setCancelable(false)
        builder.setPositiveButton(R.string.sim, DialogInterface.OnClickListener { dialog, id -> saveRoom()})
        builder.setNegativeButton(R.string.cancelar, DialogInterface.OnClickListener { dialog, id -> dialog.cancel()})

        builder.show()
    }
}