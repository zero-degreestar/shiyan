package au.edu.federation.itech3107.studentattendance30395637;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBOpenHelper extends SQLiteOpenHelper {
    public MyDBOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table student("
                + "_id integer primary key autoincrement,"
                + "stuId integer unique,"
                + "stuName text not null);");
        sqLiteDatabase.execSQL("insert into student(stuId,stuName) values(33,'Xiomse')");
        sqLiteDatabase.execSQL("insert into student(stuId,stuName) values(35,'Jbdoer')");
        sqLiteDatabase.execSQL("insert into student(stuId,stuName) values(36,'Xioscey')");
        sqLiteDatabase.execSQL("insert into student(stuId,stuName) values(37,'Alexe')");
        sqLiteDatabase.execSQL("insert into student(stuId,stuName) values(38,'Mary')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

