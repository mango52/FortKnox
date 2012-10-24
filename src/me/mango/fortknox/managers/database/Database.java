package me.mango.fortknox.managers.database;

import java.sql.ResultSet;

public interface Database {
	public void load() throws Exception;
	public ResultSet query(String query);
	public void unload();
}