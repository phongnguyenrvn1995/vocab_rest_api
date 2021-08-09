package com.vocab.api.connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vocab.api.base.IStatus;
import com.vocab.api.pojo.Status;
import com.vocab.consts.ParamsConsts;

public class StatusDBFunc {

	public static List<IStatus> getAll(int...limitAndOffset) {
		GlobalConnection.open();
		try {
			String sql = "SELECT * FROM `status_define` LIMIT ? OFFSET ?";
			int limit = Integer.MAX_VALUE;
			int offset = 0;

			if(limitAndOffset.length == 2) {
				limit = limitAndOffset[ParamsConsts.IDX_LIMIT] < 0 ? 0 : limitAndOffset[ParamsConsts.IDX_LIMIT];
				offset = limitAndOffset[ParamsConsts.IDX_OFFSET] < 0 ? 0 : limitAndOffset[ParamsConsts.IDX_OFFSET];
			}

			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			preparedStatement.setInt(1, limit);
			preparedStatement.setInt(2, offset);
			
			ResultSet rs = preparedStatement.executeQuery();
			List<IStatus> list = new ArrayList<IStatus>();
			while (rs.next()) {
				Status status = new Status();
				status.setStatus_id(rs.getInt("status_id"));
				status.setStatus_description((rs.getString("status_description")));
				list.add(status);
			}
			rs.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static IStatus get(int id) {
		GlobalConnection.open();
		try {
			String sql = "SELECT * FROM `status_define` WHERE status_id = ?";
			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Status status = new Status();
				status.setStatus_id(rs.getInt("status_id"));
				status.setStatus_description((rs.getString("status_description")));
				rs.close();
				return status;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static boolean save(IStatus t) {
		GlobalConnection.open();
		try {
			String sql = "INSERT INTO `status_define` (`status_id`, `status_description`) VALUES (NULL, ?)";
			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			preparedStatement.setString(1, t.getStatus_description());
			return preparedStatement.executeUpdate() != 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean update(IStatus t) {
		GlobalConnection.open();
		try {
			String sql = "UPDATE `status_define` " + "SET `status_description` = ? "
					+ "WHERE `status_define`.`status_id` = ?";
			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			preparedStatement.setString(1, t.getStatus_description());
			preparedStatement.setInt(2, t.getStatus_id());
			return preparedStatement.executeUpdate() != 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean delete(IStatus t) {
		GlobalConnection.open();
		try {
			String sql = "DELETE FROM `status_define` WHERE `status_define`.`status_id` = ?";
			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			preparedStatement.setInt(1, t.getStatus_id());
			return preparedStatement.executeUpdate() != 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
