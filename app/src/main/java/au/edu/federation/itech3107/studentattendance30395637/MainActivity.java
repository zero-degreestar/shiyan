package au.edu.federation.itech3107.studentattendance30395637;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClickLogin(View view) {
        Intent intent = new Intent(this, TeacherControlActivity.class);
        EditText User = findViewById(R.id.user);
        EditText Password = findViewById(R.id.password);
        String U = User.getText().toString();
        String P = Password.getText().toString();
        intent.putExtra("U",U);
        startActivity(intent);
    }

    public void OnClickRegisterAndLogin(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}