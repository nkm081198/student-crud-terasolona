package vn.cwa.application.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class TestClass2 {

	public static Connection getConnection() {

		try {
//			String databaseURL = "jdbc:postgresql://172.16.210.179/cms_back";
//			String user = "postgres";
//			String password = "nissancms@";
			
			String databaseURL = "jdbc:postgresql://localhost:5432/manh_db";
            String user = "postgres";
            String password = "admin";

			return DriverManager.getConnection(databaseURL, user, password);
		} catch (SQLException e) {
			System.out.println("Connection failure.");
			System.out.println(e.getMessage());
		}
		return null;

	}

	public static void main(String[] args) {
		generateModel("campaign");
//		generateXML("campaign");
	}

	public static void generateModel(String tableName) {
		try {
			Connection connection = getConnection();
			String sql = new StringBuilder().append("select * from ").append(tableName).toString();
			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();
			ResultSetMetaData meta = rs.getMetaData();

			String label = null;
			String columnTypeName = null;
			String type = null;
			Map<String, String> typenames = new HashMap<String, String>();
			for (int i = 0; i < meta.getColumnCount(); i++) {
				label = meta.getColumnLabel(i + 1);
				columnTypeName = meta.getColumnTypeName(i + 1);
				typenames.put(columnTypeName, columnTypeName);

				if (columnTypeName.equals("date") || columnTypeName.equals("timestamp")) {
					type = "Date";
				} else if (columnTypeName.equals("int2")) {
					type = "Short";
				} else if (columnTypeName.equals("int4")) {
					type = "Integer";
				} else if (columnTypeName.equals("varchar")) {
					type = "String";
				} else if (columnTypeName.equals("int8")){
					type = "Long";
				}else {
					type = "xxxxxxxxxx";
				}

				System.out.println("private " + type + " " + getPropertiesType(label.toLowerCase()) + ";\n");
			}
			
			System.out.println(typenames);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	public static void generateXML(String tableName) {
		try {
			Connection connection = getConnection();
			String sql = new StringBuilder().append("select * from ").append(tableName).toString();
			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();
			ResultSetMetaData meta = rs.getMetaData();

			String label = null;
			StringBuilder rsx = null;
			for (int i = 0; i < meta.getColumnCount(); i++) {
				rsx = new StringBuilder();
				label = meta.getColumnLabel(i + 1);
				rsx.append("<result column=\"").append(label).append("\" property=\"")
						.append(getPropertiesType(label.toLowerCase())).append("\" />");
				System.out.println(rsx);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	private static String getPropertiesType(String input) {
		char[] xxx = input.toCharArray();
		for (int i = 0; i < xxx.length; i++) {
			if (xxx[i] == '_') {
				xxx[i + 1] = Character.toUpperCase(xxx[i + 1]);
			}
		}
		return String.valueOf(xxx).replace("_", "");
	}

}
