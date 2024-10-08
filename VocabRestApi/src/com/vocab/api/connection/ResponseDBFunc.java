package com.vocab.api.connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vocab.api.base.IResponse;
import com.vocab.api.pojo.Response;
import com.vocab.consts.ParamsConsts;

public class ResponseDBFunc {

	public static List<IResponse> getAll(String searchStr, int...limitAndOffset) {
		GlobalConnection.open();
		try {
			String sql = "SELECT * FROM `response_define` WHERE `response_description` LIKE ? LIMIT ? OFFSET ?";
			int limit = Integer.MAX_VALUE;
			int offset = 0;

			if(limitAndOffset.length == 2) {
				limit = limitAndOffset[ParamsConsts.IDX_LIMIT] < 0 ? 0 : limitAndOffset[ParamsConsts.IDX_LIMIT];
				offset = limitAndOffset[ParamsConsts.IDX_OFFSET] < 0 ? 0 : limitAndOffset[ParamsConsts.IDX_OFFSET];
			}

			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			int i = 0;
			preparedStatement.setString(++i, "%" + searchStr + "%");
			preparedStatement.setInt(++i, limit);
			preparedStatement.setInt(++i, offset);			
			
			ResultSet rs = preparedStatement.executeQuery();
			List<IResponse> list = new ArrayList<IResponse>();
			while (rs.next()) {
				Response response = new Response();
				response.setResponse_id(rs.getInt("response_id"));
				response.setResponse_description(rs.getString("response_description"));
				list.add(response);
			}
			rs.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static IResponse get(int id) {
		GlobalConnection.open();
		try {
			String sql = "SELECT * FROM `response_define` WHERE response_id = ?";
			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Response response = new Response();
				response.setResponse_id(rs.getInt("response_id"));
				response.setResponse_description(rs.getString("response_description"));
				rs.close();
				return response;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static boolean save(IResponse response) {
		GlobalConnection.open();
		try {
			String sql = "INSERT INTO `response_define` (`response_id`, `response_description`) VALUES (NULL, ?)";
			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			preparedStatement.setString(1, response.getResponse_description());
			return preparedStatement.executeUpdate() != 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean update(IResponse response) {
		GlobalConnection.open();
		try {
			String sql = "UPDATE `response_define` " + "SET `response_description` = ? " + "WHERE `response_id` = ?";
			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			preparedStatement.setString(1, response.getResponse_description());
			preparedStatement.setInt(2, response.getResponse_id());
			return preparedStatement.executeUpdate() != 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean delete(IResponse response) {
		GlobalConnection.open();
		try {
			String sql = "DELETE FROM `response_define` WHERE `response_id` = ?";
			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			preparedStatement.setInt(1, response.getResponse_id());
			return preparedStatement.executeUpdate() != 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
