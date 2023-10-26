package au.edu.federation.itech3107.studentattendance30395637;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class CheckCourses extends AppCompatActivity {

    public int num = 0;
    public AttendanceDBOpenHelper attendanceDBOpenHelper;
    private ListView listView;
    public SQLiteDatabase dbaReader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_courses);
        listView = findViewById(R.id.listViewC);
        attendanceDBOpenHelper = StudentsAttendance.dbAOpenHelper;
        dbaReader = attendanceDBOpenHelper.getReadableDatabase();
        showall();
    }

    private void showall() {
        Cursor result = dbaReader.query("attendance",null,null,null,null,null,null);
        SimpleCursorAdapter listViewAdapter=new SimpleCursorAdapter(getApplicationContext(),
                R.layout.list_item_courses,result,
                new String[]{"_id","openTime","closeTime","courseName","attendance"},
                new int[]{R.id.item_id,R.id.item_openTime,R.id.item_overTime,R.id.item_name,R.id.item_attendance},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        listView.setAdapter(listViewAdapter);
    }
}