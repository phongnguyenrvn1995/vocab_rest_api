package com.vocab.api.connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vocab.api.base.IVocab;
import com.vocab.api.pojo.Vocab;
import com.vocab.consts.ParamsConsts;

public class VocabDBFunc {

	public static List<IVocab> gets(int...limitAndOffset) {
		GlobalConnection.open();
		try {
			String sql = "SELECT * FROM `vocab` LIMIT ? OFFSET ?";
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
			List<IVocab> list = new ArrayList<IVocab>();
			while(rs.next()) {
				Vocab vocab = new Vocab();
				vocab.setVocab_id(rs.getInt("vocab_id"));         
				vocab.setVocab_type(rs.getInt("vocab_type"));       
				vocab.setVocab_lesson(rs.getInt("vocab_lesson"));     
				vocab.setVocab_en(rs.getString("vocab_en"));         
				vocab.setVocab_ipa(rs.getString("vocab_ipa"));     
				vocab.setVocab_vi(rs.getString("vocab_vi")); 
				vocab.setVocab_description(rs.getString("vocab_description")); 
				vocab.setVocab_sound_url(rs.getString("vocab_sound_url")); 
				list.add(vocab);
			}
			rs.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static IVocab get(int id) {
		GlobalConnection.open();
		try {
			String sql = "SELECT * FROM `vocab` WHERE vocab_id = ?";
			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Vocab vocab = new Vocab();
				vocab.setVocab_id(rs.getInt("vocab_id"));         
				vocab.setVocab_type(rs.getInt("vocab_type"));       
				vocab.setVocab_lesson(rs.getInt("vocab_lesson"));     
				vocab.setVocab_en(rs.getString("vocab_en"));         
				vocab.setVocab_ipa(rs.getString("vocab_ipa"));     
				vocab.setVocab_vi(rs.getString("vocab_vi")); 
				vocab.setVocab_description(rs.getString("vocab_description")); 
				vocab.setVocab_sound_url(rs.getString("vocab_sound_url")); 
				rs.close();
				return vocab;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static boolean save(IVocab object) {
		GlobalConnection.open();
		try {
			String sql = "INSERT INTO `vocab` (`vocab_id`, `vocab_type`, `vocab_lesson`, "
					+ "`vocab_en`, `vocab_ipa`, `vocab_vi`," + " `vocab_description`, `vocab_sound_url`) "
					+ "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			preparedStatement.setInt(1, object.getVocab_type());
			preparedStatement.setInt(2, object.getVocab_lesson());
			preparedStatement.setString(3, object.getVocab_en());
			preparedStatement.setString(4, object.getVocab_ipa());
			preparedStatement.setString(5, object.getVocab_vi());
			preparedStatement.setString(6, object.getVocab_description());
			preparedStatement.setString(7, object.getVocab_sound_url());

			return preparedStatement.executeUpdate() != 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean update(IVocab object) {
		GlobalConnection.open();
		try {
			String sql = "UPDATE `vocab` " + "SET `vocab_type` = ?, " + "`vocab_lesson` = ?, " + "`vocab_en` = ?, "
					+ "`vocab_ipa` = ?, " + "`vocab_vi` = ?, " + "`vocab_description` = ?, " + "`vocab_sound_url` = ? "
					+ "WHERE `vocab`.`vocab_id` = ?";

			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			preparedStatement.setInt(1, object.getVocab_type());
			preparedStatement.setInt(2, object.getVocab_lesson());
			preparedStatement.setString(3, object.getVocab_en());
			preparedStatement.setString(4, object.getVocab_ipa());
			preparedStatement.setString(5, object.getVocab_vi());
			preparedStatement.setString(6, object.getVocab_description());
			preparedStatement.setString(7, object.getVocab_sound_url());
			preparedStatement.setInt(8, object.getVocab_id());

			return preparedStatement.executeUpdate() != 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean delete(IVocab object) {
		GlobalConnection.open();
		try {
			String sql = "DELETE FROM `vocab` WHERE `vocab_id` = ?";

			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			preparedStatement.setInt(1, object.getVocab_id());

			return preparedStatement.executeUpdate() != 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static List<IVocab> getAllByLessonID(int id, int ...limitAndOffset) {
		GlobalConnection.open();
		try {
			String sql = "SELECT * FROM `vocab` WHERE vocab_lesson = ? LIMIT ? OFFSET ?";
			int limit = Integer.MAX_VALUE;
			int offset = 0;

			if(limitAndOffset.length == 2) {
				limit = limitAndOffset[ParamsConsts.IDX_LIMIT] < 0 ? 0 : limitAndOffset[ParamsConsts.IDX_LIMIT];
				offset = limitAndOffset[ParamsConsts.IDX_OFFSET] < 0 ? 0 : limitAndOffset[ParamsConsts.IDX_OFFSET];
			}

			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, limit);
			preparedStatement.setInt(3, offset);
			ResultSet rs = preparedStatement.executeQuery();
			List<IVocab> list = new ArrayList<IVocab>();
			while(rs.next()) {
				Vocab vocab = new Vocab();
				vocab.setVocab_id(rs.getInt("vocab_id"));         
				vocab.setVocab_type(rs.getInt("vocab_type"));       
				vocab.setVocab_lesson(rs.getInt("vocab_lesson"));     
				vocab.setVocab_en(rs.getString("vocab_en"));         
				vocab.setVocab_ipa(rs.getString("vocab_ipa"));     
				vocab.setVocab_vi(rs.getString("vocab_vi")); 
				vocab.setVocab_description(rs.getString("vocab_description")); 
				vocab.setVocab_sound_url(rs.getString("vocab_sound_url")); 
				list.add(vocab);
			}
			rs.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static List<IVocab> getAllByTypeID(int id, int ...limitAndOffset) {
		GlobalConnection.open();
		try {
			String sql = "SELECT * FROM `vocab`WHERE vocab_type = ? LIMIT ? OFFSET ?";
			int limit = Integer.MAX_VALUE;
			int offset = 0;

			if(limitAndOffset.length == 2) {
				limit = limitAndOffset[ParamsConsts.IDX_LIMIT] < 0 ? 0 : limitAndOffset[ParamsConsts.IDX_LIMIT];
				offset = limitAndOffset[ParamsConsts.IDX_OFFSET] < 0 ? 0 : limitAndOffset[ParamsConsts.IDX_OFFSET];
			}


			PreparedStatement preparedStatement = GlobalConnection.getPreparedStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, limit);
			preparedStatement.setInt(3, offset);
			ResultSet rs = preparedStatement.executeQuery();
			List<IVocab> list = new ArrayList<IVocab>();
			while(rs.next()) {
				Vocab vocab = new Vocab();
				vocab.setVocab_id(rs.getInt("vocab_id"));         
				vocab.setVocab_type(rs.getInt("vocab_type"));       
				vocab.setVocab_lesson(rs.getInt("vocab_lesson"));     
				vocab.setVocab_en(rs.getString("vocab_en"));         
				vocab.setVocab_ipa(rs.getString("vocab_ipa"));     
				vocab.setVocab_vi(rs.getString("vocab_vi")); 
				vocab.setVocab_description(rs.getString("vocab_description")); 
				vocab.setVocab_sound_url(rs.getString("vocab_sound_url")); 
				list.add(vocab);
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
