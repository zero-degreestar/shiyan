package au.edu.federation.itech3107.studentattendance30395637;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TeacherControlActivity extends AppCompatActivity {

    Button bt1,bt2,bt3;
    public static boolean isCourse = false;
    public String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_control);

        TextView tvWelcomeU = findViewById(R.id.WelcomeU);

        Intent intent = getIntent();
        userName = intent.getStringExtra("U");
        tvWelcomeU.setText("Welcome Teacher: " + userName);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);

    }


    public void bt1(View view) {
        Intent intent = new Intent(this, CalendarCourse.class);
        startActivity(intent);
    }

    public void bt2(View view) {
        if(!isCourse) {
            Intent intent = new Intent(this, Iscourse_zero.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, CheckCourses.class);
            startActivity(intent);
        }

    }


}

















