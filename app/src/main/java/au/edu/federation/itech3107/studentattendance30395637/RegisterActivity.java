package au.edu.federation.itech3107.studentattendance30395637;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void OnClickRegisterAndLogin(View view) {
        Intent intent = new Intent(this, TeacherControlActivity.class);
        EditText registerUser = findViewById(R.id.registerUser);
        EditText registerPassword = findViewById(R.id.registerPassword);
        EditText registerEnsurePassword = findViewById(R.id.registerEnsurePassword);
        String rU = registerUser.getText().toString();
        String rP = registerPassword.getText().toString();
        String rEP = registerEnsurePassword.getText().toString();
        Log.d("rp",rP);
        Log.d("rep",rEP);

        if(!rP.equals(rEP))
            Toast.makeText(this, "Please ensure your passwords is the same, and try again!",Toast.LENGTH_SHORT).show();
        else {
            intent.putExtra("U",rU);
            startActivity(intent);
        }
    }
}