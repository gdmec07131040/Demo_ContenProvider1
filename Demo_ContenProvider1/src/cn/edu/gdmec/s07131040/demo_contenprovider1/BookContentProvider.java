package cn.edu.gdmec.s07131040.demo_contenprovider1;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class BookContentProvider extends ContentProvider {
	private static UriMatcher matcher;
	private static final String TBLNAME="booktbl";
	private MySQLiteOpenHelper helper;
	
	
	
	static {
		matcher=new UriMatcher(UriMatcher.NO_MATCH);
		matcher.addURI("com.kaikeba.providers.book", "book", 1);//多值查询
		matcher.addURI("com.kaikeba.providers.book", "book/#", 2);//多值查询
		
		
		
	}
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		SQLiteDatabase db=helper.getWritableDatabase();
		long rowId=db.insert(TBLNAME, null, values);
		Uri retUri=ContentUris.withAppendedId( uri, rowId);
		
		return retUri;
	}

	@Override
	public boolean onCreate() {
		helper=new MySQLiteOpenHelper(getContext(), null, null, 1);
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		SQLiteDatabase db=helper.getReadableDatabase();
		Cursor c = null;
		
		switch (matcher.match(uri)) {
		case 1://多值查询
			db.query(TBLNAME, null, null, null, null, null, null);//返回整表数据
			
			
			break;
		case 2://单值查询
		default:
			break;
		}
		
		return c;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

}
