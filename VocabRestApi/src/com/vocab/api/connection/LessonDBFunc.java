package com.vocab.api.connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vocab.api.base.ILesson;
import com.vocab.api.pojo.Lesson;
import com.vocab.consts.ParamsConsts;

public class LessonDBFunc {
	public static int getFilterCount(String searchStr, int courseID, int statusID) {
		if(courseID == ParamsConsts.COURSE_NOT_DEF && statusID == ParamsConsts.STATUS_NOT_DEF) {
			return getsCount(searchStr);
		}
		if(courseID == ParamsConsts.COURSE_NOT_DEF) {
			return getAllByStatusIDCount(searchStr, statusID);
		}
		if(statusID == ParamsConsts.STATUS_NOT_DEF) {
			return getAllByCourseIDCount(searchStr, courseID);
		}
		
		GlobalConnection.open();
		try {
			String sql = "SELECT COUNT(`lesson_id`) FROM `lesson` "
					+ "WHERE lesson_course = ? "
					+ "AND  lesson_status = ? "
					+ "AND `lesson_name` LIKE ? ";

			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			int i = 0;
			preparedStatement.setInt(++i, courseID);
			preparedStatement.setInt(++i, statusID);
			preparedStatement.setString(++i, "%" + searchStr + "%");
			ResultSet rs = preparedStatement.executeQuery();
			int count = 0;
			while (rs.next()) {
				count = rs.getInt(1);
			}
			rs.close();
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public static List<ILesson> getFilter(String searchStr, int courseID, int statusID, int ... limitAndOffset) {
		if(courseID == ParamsConsts.COURSE_NOT_DEF && statusID == ParamsConsts.STATUS_NOT_DEF) {
			return gets(searchStr, limitAndOffset);			
		}
		if(courseID == ParamsConsts.COURSE_NOT_DEF) {
			return getAllByStatusID(searchStr, statusID, limitAndOffset);
		}
		if(statusID == ParamsConsts.STATUS_NOT_DEF) {
			return getAllByCourseID(searchStr, courseID, limitAndOffset);
		}
		
		GlobalConnection.open();
		try {
			String sql = "SELECT * FROM `lesson` "
					+ "WHERE lesson_course = ? "
					+ "AND  lesson_status = ? "
					+ "AND `lesson_name` LIKE ? "
					+ "LIMIT ? OFFSET ?";
			int limit = Integer.MAX_VALUE;
			int offset = 0;

			if(limitAndOffset.length == 2) {
				limit = limitAndOffset[ParamsConsts.IDX_LIMIT] < 0 ? 0 : limitAndOffset[ParamsConsts.IDX_LIMIT];
				offset = limitAndOffset[ParamsConsts.IDX_OFFSET] < 0 ? 0 : limitAndOffset[ParamsConsts.IDX_OFFSET];
			}

			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			int i = 0;
			preparedStatement.setInt(++i, courseID);
			preparedStatement.setInt(++i, statusID);
			preparedStatement.setString(++i, "%" + searchStr + "%");
			preparedStatement.setInt(++i, limit);
			preparedStatement.setInt(++i, offset);
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
	
	public static int getsCount(String searchStr) {
		GlobalConnection.open();
		try {
			String sql = "SELECT COUNT(`lesson_id`) FROM `lesson` WHERE `lesson_name` LIKE ?";
			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			int i = 0;
			preparedStatement.setString(++i, "%" +searchStr +"%");
			
			ResultSet rs = preparedStatement.executeQuery();
			int count = 0;
			while (rs.next()) {
				count = rs.getInt(1);
			}
			rs.close();
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public static List<ILesson> gets(String searchStr, int ... limitAndOffset) {
		GlobalConnection.open();
		try {
			String sql = "SELECT * FROM `lesson` WHERE `lesson_name` LIKE ? LIMIT ? OFFSET ?";
			int limit = Integer.MAX_VALUE;
			int offset = 0;
			if(limitAndOffset.length == 2) {
				limit = limitAndOffset[ParamsConsts.IDX_LIMIT] < 0 ? 0 : limitAndOffset[ParamsConsts.IDX_LIMIT];
				offset = limitAndOffset[ParamsConsts.IDX_OFFSET] < 0 ? 0 : limitAndOffset[ParamsConsts.IDX_OFFSET];
			}
			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			int i = 0;
			preparedStatement.setString(++i, "%" +searchStr +"%");
			preparedStatement.setInt(++i, limit);
			preparedStatement.setInt(++i, offset);
			
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

	public static int getAllByCourseIDCount(String searchStr, int id) {
		GlobalConnection.open();
		try {
			String sql = "SELECT COUNT(`lesson_id`) FROM `lesson` "
					+ "WHERE lesson_course = ? AND `lesson_name` LIKE ?";
			
			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			int i = 0;
			preparedStatement.setInt(++i, id);
			preparedStatement.setString(++i, "%" + searchStr + "%");
			ResultSet rs = preparedStatement.executeQuery();

			int count = 0;
			while (rs.next()) {
				count = rs.getInt(1);
			}
			rs.close();
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public static List<ILesson> getAllByCourseID(String searchStr, int id, int... limitAndOffset) {
		GlobalConnection.open();
		try {
			String sql = "SELECT * FROM `lesson` "
					+ "WHERE lesson_course = ? AND `lesson_name` LIKE ? "
					+ "LIMIT ? OFFSET ?";
			int limit = Integer.MAX_VALUE;
			int offset = 0;

			if(limitAndOffset.length == 2) {
				limit = limitAndOffset[ParamsConsts.IDX_LIMIT] < 0 ? 0 : limitAndOffset[ParamsConsts.IDX_LIMIT];
				offset = limitAndOffset[ParamsConsts.IDX_OFFSET] < 0 ? 0 : limitAndOffset[ParamsConsts.IDX_OFFSET];
			}

			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			int i = 0;
			preparedStatement.setInt(++i, id);
			preparedStatement.setString(++i, "%" + searchStr + "%");
			preparedStatement.setInt(++i, limit);
			preparedStatement.setInt(++i, offset);
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

	public static int getAllByStatusIDCount(String searchStr, int id) {
		GlobalConnection.open();
		try {
			String sql = "SELECT COUNT(`lesson_id`) FROM `lesson` "
					+ "WHERE lesson_status = ? AND `lesson_name` LIKE ?";
			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			int i = 0;
			preparedStatement.setInt(++i, id);
			preparedStatement.setString(++i, "%" + searchStr + "%");
			
			ResultSet rs = preparedStatement.executeQuery();

			int count = 0;
			while (rs.next()) {
				count = rs.getInt(1);
			}
			rs.close();
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public static List<ILesson> getAllByStatusID(String searchStr, int id, int... limitAndOffset) {
		GlobalConnection.open();
		try {
			String sql = "SELECT * FROM `lesson` "
					+ "WHERE lesson_status = ? AND `lesson_name` LIKE ? "
					+ "LIMIT ? OFFSET ?";
			int limit = Integer.MAX_VALUE;
			int offset = 0;

			if(limitAndOffset.length == 2) {
				limit = limitAndOffset[ParamsConsts.IDX_LIMIT] < 0 ? 0 : limitAndOffset[ParamsConsts.IDX_LIMIT];
				offset = limitAndOffset[ParamsConsts.IDX_OFFSET] < 0 ? 0 : limitAndOffset[ParamsConsts.IDX_OFFSET];
			}

			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			int i = 0;
			preparedStatement.setInt(++i, id);
			preparedStatement.setString(++i, "%" + searchStr + "%");
			preparedStatement.setInt(++i, limit);
			preparedStatement.setInt(++i, offset);
			
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
