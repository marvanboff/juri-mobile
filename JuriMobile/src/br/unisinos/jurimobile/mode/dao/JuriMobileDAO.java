package br.unisinos.jurimobile.mode.dao;

import java.io.IOException;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class JuriMobileDAO {

	private DataBaseHelper helper;
	private Context context;
	
	protected String QUERY_SEL = "select * from %s";

	public JuriMobileDAO(Context context) {
		helper = new DataBaseHelper(context);
	}
	
	
	public SQLiteDatabase getDataBase() {
		createDataBase(helper);
		return openDataBase(helper);
	}
	
	public SQLiteDatabase getDataBaseWrite() {
		createDataBase(helper);
		return openDataBaseWrite(helper);
	}

	private SQLiteDatabase openDataBase(DataBaseHelper dbHelper) {
		try {
			return dbHelper.openDataBase();
		} catch (SQLException sqle) {
			throw sqle;
		}
	}
	
	private SQLiteDatabase openDataBaseWrite(DataBaseHelper dbHelper) {
		try {
			return dbHelper.openDataBaseWrite();
		} catch (SQLException sqle) {
			throw sqle;
		}
	}

	private void createDataBase(DataBaseHelper myDbHelper) throws Error {
		try {
			myDbHelper.createDataBase();
		} catch (IOException ioe) {
			throw new Error("Unable to create database");
		}
	}


	public Context getContext() {
		return context;
	}
}
