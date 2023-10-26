package au.edu.federation.itech3107.studentattendance30395637;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CourseInfoActivity extends AppCompatActivity {

    private String calendarOpen = " ";
    private String calendarOver = " ";
    private String CourseName = " ";
    TextView tv1;
    EditText edover, ed1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_info);

        tv1 = findViewById(R.id.TvTime);
        edover = findViewById(R.id.courseOverTime);
        ed1 = findViewById(R.id.CourseName);
        Intent intent = getIntent();
        calendarOpen = intent.getStringExtra("Calendar");
        tv1.setText(calendarOpen);
    }

    public void OnClickCourse(View view) {
        CourseName = ed1.getText().toString();
        calendarOver = edover.getText().toString();
        Intent intent = new Intent(this, ChooseStudents.class);
        intent.putExtra("calendarOpen",calendarOpen);
        intent.putExtra("calendarOver",calendarOver);
        intent.putExtra("finalCourse",CourseName);
        startActivity(intent);
    }
}












