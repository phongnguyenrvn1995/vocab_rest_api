package com.vocab.api.connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vocab.api.base.ILesson;
import com.vocab.api.pojo.Lesson;

public class LessonDBFunc {

	public static List<ILesson> gets(int ... limitAndOffset) {
		GlobalConnection.open();
		try {
			String sql = "SELECT * FROM `lesson` LIMIT ? OFFSET ?";
			int limit = Integer.MAX_VALUE;
			int offset = 0;
			if(limitAndOffset.length == 2) {
				limit = limitAndOffset[0];
				offset = limitAndOffset[1];
			}
			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			preparedStatement.setInt(1, limit);
			preparedStatement.setInt(2, offset);
			
			ResultSet rs = preparedStatement.executeQuery();
			List<ILesson> list = new ArrayList<ILesson>();
			while (rs.next()) {
				Lesson lesson = new Lesson();
				lesson.setLesson_id(rs.getInt("lesson_id"));
				lesson.setLesson_course(rs.getInt("lesson_course"));
				lesson.setLesson_name(rs.getString("lesson_name"));
				lesson.setLesson_status(rs.getInt("lesson_status"));
				list.add(lesson);
			}
			rs.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static ILesson get(int id) {
		GlobalConnection.open();
		try {
			String sql = "SELECT * FROM `lesson` WHERE lesson_id = ?";
			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Lesson lesson = new Lesson();
				lesson.setLesson_id(rs.getInt("lesson_id"));
				lesson.setLesson_course(rs.getInt("lesson_course"));
				lesson.setLesson_name(rs.getString("lesson_name"));
				lesson.setLesson_status(rs.getInt("lesson_status"));
				rs.close();
				return lesson;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static boolean save(ILesson object) {
		GlobalConnection.open();
		try {
			String sql = "INSERT INTO `lesson` (`lesson_id`, `lesson_course`, `lesson_name`, `lesson_status`) "
					+ "VALUES (NULL, ?, ?, ?)";
			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			preparedStatement.setInt(1, object.getLesson_course());
			preparedStatement.setString(2, object.getLesson_name());
			preparedStatement.setInt(3, object.getLesson_status());

			return preparedStatement.executeUpdate() != 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public static boolean update(ILesson object) {
		GlobalConnection.open();
		try {
			String sql = "UPDATE `lesson` SET " + "`lesson_course` = ?, `lesson_name` = ?, `lesson_status` = ? "
					+ "WHERE `lesson_id` = ?";
			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			preparedStatement.setInt(1, object.getLesson_course());
			preparedStatement.setString(2, object.getLesson_name());
			preparedStatement.setInt(3, object.getLesson_status());
			preparedStatement.setInt(4, object.getLesson_id());

			return preparedStatement.executeUpdate() != 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public static boolean delete(ILesson object) {
		GlobalConnection.open();
		try {
			String sql = "DELETE FROM `lesson` WHERE `lesson_id` = ?";
			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			preparedStatement.setInt(1, object.getLesson_id());
			return preparedStatement.executeUpdate() != 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static List<ILesson> getAllByCourseID(int id, int... limitAndOffset) {
		GlobalConnection.open();
		try {
			String sql = "SELECT * FROM `lesson` WHERE lesson_course = ? LIMIT ? OFFSET ?";
			int limit = Integer.MAX_VALUE;
			int offset = 0;
			if(limitAndOffset.length == 2) {
				limit = limitAndOffset[0];
				offset = limitAndOffset[1];
			}
			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, limit);
			preparedStatement.setInt(3, offset);
			ResultSet rs = preparedStatement.executeQuery();
			List<ILesson> list = new ArrayList<ILesson>();
			while (rs.next()) {
				Lesson lesson = new Lesson();
				lesson.setLesson_id(rs.getInt("lesson_id"));
				lesson.setLesson_course(rs.getInt("lesson_course"));
				lesson.setLesson_name(rs.getString("lesson_name"));
				lesson.setLesson_status(rs.getInt("lesson_status"));
				list.add(lesson);
			}
			rs.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static List<ILesson> getAllByStatusID(int id, int... limitAndOffset) {
		GlobalConnection.open();
		try {
			String sql = "SELECT * FROM `lesson` WHERE lesson_status = ? LIMIT ? OFFSET ?";
			int limit = Integer.MAX_VALUE;
			int offset = 0;
			if(limitAndOffset.length == 2) {
				limit = limitAndOffset[0];
				offset = limitAndOffset[1];
			}
			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, limit);
			preparedStatement.setInt(3, offset);
			
			ResultSet rs = preparedStatement.executeQuery();
			List<ILesson> list = new ArrayList<ILesson>();
			while (rs.next()) {
				Lesson lesson = new Lesson();
				lesson.setLesson_id(rs.getInt("lesson_id"));
				lesson.setLesson_course(rs.getInt("lesson_course"));
				lesson.setLesson_name(rs.getString("lesson_name"));
				lesson.setLesson_status(rs.getInt("lesson_status"));
				list.add(lesson);
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
