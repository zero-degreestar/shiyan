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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class ChooseStudents extends AppCompatActivity {

    static public SQLiteDatabase dbReader,dbWriter;
    static public MyDBOpenHelper dbOpenHelper;
    private EditText studentIdEdit, nameEdit;
    static public ListView listView;
    private TextView tv;
    private String t1,t2,t3;
    public int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_students);

        nameEdit=findViewById(R.id.etStudentName);
        studentIdEdit=findViewById(R.id.etStudentID);
        listView=findViewById(R.id.listView);

        tv = findViewById(R.id.chooseStudentsTitle);
        Button btnDataAdd=findViewById(R.id.btnAdd);
        Button btnOpenClass=findViewById(R.id.btnOpenClass);

        dbOpenHelper=new MyDBOpenHelper(getApplicationContext(),"SC_Database.db",null,1);
        dbReader=dbOpenHelper.getReadableDatabase();
        dbWriter=dbOpenHelper.getWritableDatabase();
        Intent intent = getIntent();
        t1 = intent.getStringExtra("calendarOpen");
        t2 = intent.getStringExtra("calendarOver");
        t3 = intent.getStringExtra("finalCourse");
        tv.setText("Open Time: " + t1 + "\n" + "Over Time: "+ t2 + "\n" +"Course Name:"+ t3);
        showAll();


        btnDataAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues contentValues=new ContentValues();
                contentValues.put("stuId", Integer.parseInt(studentIdEdit.getText().toString()));
                contentValues.put("stuName",nameEdit.getText().toString());
                dbWriter.insert("student","stuId",contentValues);
                showAll();
                Log.d("eee",String.valueOf(count));

            }
        });

    }

   public void showAll() {
        Cursor result = dbReader.query("student",null,null,null,null,null,null);
        SimpleCursorAdapter listViewAdapter=new SimpleCursorAdapter(getApplicationContext(),
                R.layout.list_item, result,
                new String[]{"_id","stuId","stuName"},
                new int[]{R.id.item_id,R.id.itemID,R.id.itemName},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        listView.setAdapter(listViewAdapter);
    }


    public void btnOpenClass(View view) {
        Intent intent = new Intent(this, StudentsAttendance.class);
        intent.putExtra("calendarOpen",t1);
        intent.putExtra("calendarOver",t2);
        intent.putExtra("finalCourse",t3);
        startActivity(intent);
    }
}