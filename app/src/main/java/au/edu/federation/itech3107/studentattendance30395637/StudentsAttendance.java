package au.edu.federation.itech3107.studentattendance30395637;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class StudentsAttendance extends AppCompatActivity {

    public MyDBOpenHelper dbOpenHelperx;
    private ListView listViewAttendance;
    public SQLiteDatabase dbReader;

    static public SQLiteDatabase dbAReader, dbAWriter;
    static public AttendanceDBOpenHelper dbAOpenHelper;
    public int count = 0;
    private String t1, t2, t3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_attendance);
        listViewAttendance = findViewById(R.id.listViewAtt);
        dbOpenHelperx = ChooseStudents.dbOpenHelper;
        dbReader = dbOpenHelperx.getReadableDatabase();
        showAll();

        Intent intent = getIntent();
        t1 = intent.getStringExtra("calendarOpen");
        t2 = intent.getStringExtra("calendarOver");
        t3 = intent.getStringExtra("finalCourse");
        Button btnFinish=findViewById(R.id.finish);
        dbAOpenHelper=new AttendanceDBOpenHelper(getApplicationContext(),"SC_Attendance.db",null,1);
        dbAWriter = dbAOpenHelper.getWritableDatabase();
        dbAReader = dbAOpenHelper.getReadableDatabase();
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues contentValues=new ContentValues();
                contentValues.put("openTime","openTime:" + t1);
                contentValues.put("closeTime","closeTime:" + t2);
                contentValues.put("courseName","Name:" + t3);
                contentValues.put("attendance","Attendance>=80%");
                dbAWriter.insert("attendance","openTime",contentValues);
                Toast.makeText(StudentsAttendance.this,"Attendance information saved",Toast.LENGTH_SHORT).show();

            }
        });
    }


    private void showAll() {
        Cursor result = dbReader.query("student",null,null,null,null,null,null);
        SimpleCursorAdapter listViewAdapter=new SimpleCursorAdapter(getApplicationContext(),
                R.layout.list_item_attendance, result,
                new String[]{"_id","stuId","stuName"},
                new int[]{R.id.item_id,R.id.itemID,R.id.itemName},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        listViewAttendance.setAdapter(listViewAdapter);
    }

    public void btback(View view) {
        Intent i = new Intent(this, TeacherControlActivity.class);
        startActivity(i);
    }
}