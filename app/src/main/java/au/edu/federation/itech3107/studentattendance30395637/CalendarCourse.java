package au.edu.federation.itech3107.studentattendance30395637;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

public class CalendarCourse extends AppCompatActivity {

    TextView textViewCheckDay;
    private String CheckCalendar = " ";
    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_course);
        textViewCheckDay = findViewById(R.id.CheckDay);
        calendarView = (CalendarView) findViewById(R.id.calenderView);
        TeacherControlActivity.isCourse = true;

        //calendarView 监听事件
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange( CalendarView view, int year, int month, int dayOfMonth) {
                //显示用户选择的日期
                Toast.makeText(CalendarCourse.this,year + "year" + (month + 1) + "month" + dayOfMonth + "day",Toast.LENGTH_SHORT).show();
                CheckCalendar = year + "Y" + (month + 1) + "M" + dayOfMonth + "D";
                textViewCheckDay.setText(CheckCalendar);
            }
        });

    }

    public void BtSubmit(View view) {
        Intent intent = new Intent(this, CourseInfoActivity.class);
        intent.putExtra("Calendar",CheckCalendar);
        startActivity(intent);
    }


}