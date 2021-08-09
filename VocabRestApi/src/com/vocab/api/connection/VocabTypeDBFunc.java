package com.vocab.api.connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vocab.api.base.IVocabType;
import com.vocab.api.pojo.VocabType;
import com.vocab.consts.ParamsConsts;

public class VocabTypeDBFunc {

	public static List<IVocabType> gets(String searchStr, int ...limitAndOffset) {
		GlobalConnection.open();
		try {
			String sql = "SELECT * FROM `vocab_type` WHERE `vocab_type_name` LIKE ? LIMIT ? OFFSET ?";
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
			List<IVocabType> list = new ArrayList<IVocabType>();
			while (rs.next()) {
				VocabType vocabType = new VocabType();
				vocabType.setVocab_type_id(rs.getInt("vocab_type_id"));
				vocabType.setVocab_type_name(rs.getString("vocab_type_name"));
				list.add(vocabType);
			}
			rs.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static IVocabType get(int id) {
		GlobalConnection.open();
		try {
			String sql = "SELECT * FROM `vocab_type` WHERE vocab_type_id = ?";
			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				VocabType vocabType = new VocabType();
				vocabType.setVocab_type_id(rs.getInt("vocab_type_id"));
				vocabType.setVocab_type_name(rs.getString("vocab_type_name"));
				rs.close();
				return vocabType;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static boolean save(IVocabType object) {
		GlobalConnection.open();
		try {
			String sql = "INSERT INTO `vocab_type` (`vocab_type_id`, `vocab_type_name`) VALUES (NULL, ?)";
			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			preparedStatement.setString(1, object.getVocab_type_name());
			return preparedStatement.executeUpdate() != 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean update(IVocabType object) {
		GlobalConnection.open();
		try {
			String sql = "UPDATE `vocab_type` " + "SET `vocab_type_name` = ? " + "WHERE `vocab_type_id` = ?";
			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			preparedStatement.setString(1, object.getVocab_type_name());
			preparedStatement.setInt(2, object.getVocab_type_id());
			return preparedStatement.executeUpdate() != 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean delete(IVocabType object) {
		GlobalConnection.open();
		try {
			String sql = "DELETE FROM `vocab_type` WHERE `vocab_type_id` = ?";
			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			preparedStatement.setInt(1, object.getVocab_type_id());
			return preparedStatement.executeUpdate() != 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
