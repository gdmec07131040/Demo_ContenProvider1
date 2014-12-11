package cn.edu.gdmec.s07131040.demo_contenprovider1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
	public static final String DBNAME="book.db";
	public static final String TBLNAME="booktbl";
	
	public MySQLiteOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, DBNAME, null, 1);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql="CREATE TABLE "+TBLNAME+"(_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT NOT NULL,price FLOAT NOT NULL,publisher TEXT NOT NULL)";
		
		db.execSQL(sql);
		ContentValues values=new ContentValues();
		values.put("name", "Andriod����");
		values.put("price", 50);
		values.put("publisher", "���������");
		
		db.insert(TBLNAME, null, values);
		values.clear();
		values.put("name", "JAVA����");
		values.put("price", 40);
		values.put("publisher", "���������");
		
		db.insert(TBLNAME, null, values);
		
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
