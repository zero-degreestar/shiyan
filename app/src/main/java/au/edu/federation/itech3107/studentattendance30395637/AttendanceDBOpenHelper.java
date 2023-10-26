package au.edu.federation.itech3107.studentattendance30395637;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AttendanceDBOpenHelper extends SQLiteOpenHelper {
    public AttendanceDBOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table attendance("
                + "_id integer primary key autoincrement,"
                + "openTime text not null,"
                + "closeTime text not null,"
                + "courseName text not null,"
                + "attendance text not null);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}