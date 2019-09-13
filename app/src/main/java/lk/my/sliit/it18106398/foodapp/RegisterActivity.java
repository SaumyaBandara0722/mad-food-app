package lk.my.sliit.it18106398.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    EditText editTextName, editTextUsername, editTextPhone, editTextPassword;
    Spinner spinnerUserType;
    Button btnRegister;
    DatabaseReference dbRef;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextName = findViewById(R.id.name);
        editTextUsername = findViewById(R.id.username);
        editTextPhone = findViewById(R.id.phone);
        editTextPassword = findViewById(R.id.password);

        spinnerUserType = findViewById(R.id.spinner);

        btnRegister = findViewById(R.id.btnRegister);

        user = new User();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("User");

                user.setName(editTextName.getText().toString().trim());
                user.setEmail(editTextUsername.getText().toString().trim());
                user.setPhone(editTextPhone.getText().toString().trim());
                user.setPassword(editTextPassword.getText().toString().trim());
                user.setType(spinnerUserType.getSelectedItem().toString().trim());

                dbRef.push().setValue(user);

                Toast.makeText(getApplicationContext(), "User Registered", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
