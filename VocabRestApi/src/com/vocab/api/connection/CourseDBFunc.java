package com.vocab.api.connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vocab.api.base.ICourse;
import com.vocab.api.pojo.Course;

public class CourseDBFunc {
	public static boolean save(ICourse course) {
		GlobalConnection.open();
		String sql = "INSERT INTO `course` (`course_id`, " + "`course_name`, " + "`course_description`, "
				+ "`course_date_create`, " + "`course_status`)" + " VALUES (NULL, ?, ?, ?, ?);";

		PreparedStatement statement = GlobalConnection.getPreparedStatement(sql);
		try {
			statement.setString(1, course.getCourse_name());
			statement.setString(2, course.getCourse_description());
			statement.setString(3, course.getCourse_date_creat());
			statement.setInt(4, course.getCourse_status());
			return statement.executeUpdate() != 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static ICourse get(int id) {
		GlobalConnection.open();
		String sql = "SELECT * FROM `course` WHERE course_id = ?";

		PreparedStatement statement = GlobalConnection.getPreparedStatement(sql);
		try {
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Course course = new Course();
				course.setCourse_id(rs.getInt("course_id"));
				course.setCourse_name(rs.getString("course_name"));
				course.setCourse_description(rs.getString("course_description"));
				course.setCourse_date_creat(rs.getString("course_date_create"));
				course.setCourse_status(rs.getInt("course_status"));
				rs.close();
				return course;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static List<ICourse> gets(int...limitAndOffset) {
		GlobalConnection.open();
		String sql = "SELECT * FROM `course` LIMIT ? OFFSET ?";
		int limit = Integer.MAX_VALUE;
		int offset = 0;
		
		if(limitAndOffset.length == 2) {
			limit = limitAndOffset[0] < 0 ? 0 : limitAndOffset[0];
			offset = limitAndOffset[1] < 0 ? 0 : limitAndOffset[1];
		}

		try {
			PreparedStatement statement = GlobalConnection.getPreparedStatement(sql);
			statement.setInt(1, limit);
			statement.setInt(2, offset);
			ResultSet rs = statement.executeQuery();
			List<ICourse> list = new ArrayList<ICourse>();
			while (rs.next()) {
				Course course = new Course();
				course.setCourse_id(rs.getInt("course_id"));
				course.setCourse_name(rs.getString("course_name"));
				course.setCourse_description(rs.getString("course_description"));
				course.setCourse_date_creat(rs.getString("course_date_create"));
				course.setCourse_status(rs.getInt("course_status"));
				list.add(course);
			}
			rs.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static boolean update(ICourse course) {
		GlobalConnection.open();
		String sql = "UPDATE `course` " + "SET " + "`course_name` = ?," + "`course_description` = ?,"
				+ "`course_date_create` = ?," + "`course_status` = ? " + " WHERE `course_id` = ?";

		PreparedStatement statement = GlobalConnection.getPreparedStatement(sql);
		try {
			statement.setString(1, course.getCourse_name());
			statement.setString(2, course.getCourse_description());
			statement.setString(3, course.getCourse_date_creat());
			statement.setInt(4, course.getCourse_status());
			statement.setInt(5, course.getCourse_id());
			return statement.executeUpdate() != 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean delete(ICourse course) {
		GlobalConnection.open();
		String sql = "DELETE FROM `course` WHERE `course_id` = ?";

		PreparedStatement statement = GlobalConnection.getPreparedStatement(sql);
		try {
			statement.setInt(1, course.getCourse_id());
			return statement.executeUpdate() != 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static List<ICourse> getAllByStatusID(int id, int ...limitAndOffset ) {
		GlobalConnection.open();
		try {
			String sql = "SELECT * FROM `course` WHERE course_status = ? LIMIT ? OFFSET ?";

			int limit = Integer.MAX_VALUE;
			int offset = 0;
			

			if(limitAndOffset.length == 2) {
				limit = limitAndOffset[0] < 0 ? 0 : limitAndOffset[0];
				offset = limitAndOffset[1] < 0 ? 0 : limitAndOffset[1];
			}

			PreparedStatement statement = GlobalConnection.getPreparedStatement(sql);
			statement.setInt(1, id);
			statement.setInt(2, limit);
			statement.setInt(3, offset);
			ResultSet rs = statement.executeQuery();
			List<ICourse> list = new ArrayList<ICourse>();
			while (rs.next()) {
				Course course = new Course();
				course.setCourse_id(rs.getInt("course_id"));
				course.setCourse_name(rs.getString("course_name"));
				course.setCourse_description(rs.getString("course_description"));
				course.setCourse_date_creat(rs.getString("course_date_create"));
				course.setCourse_status(rs.getInt("course_status"));
				list.add(course);
			}
			rs.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
