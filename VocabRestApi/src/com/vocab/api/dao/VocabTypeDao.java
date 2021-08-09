package com.vocab.api.dao;

import java.util.ArrayList;
import java.util.List;

import com.vocab.api.base.IVocabType;
import com.vocab.api.dao.base.IVocabTypeDao;
import com.vocab.api.pojo.VocabType;

public class VocabTypeDao extends BaseDao implements IVocabTypeDao<VocabType> {

	@Override
	public List<VocabType> getAll(String searchStr) {
		List<IVocabType> iList = iRepository.getAllVocabType(searchStr);
		List<VocabType> list = new ArrayList<VocabType>();
		for (IVocabType iv : iList) {
			list.add((VocabType) iv);
		}
		return list;
	}

	@Override
	public List<VocabType> getAll(String searchStr, int limit, int offset) {
		List<IVocabType> iList = iRepository.getAllVocabType(searchStr, limit, offset);
		List<VocabType> list = new ArrayList<VocabType>();
		for (IVocabType iv : iList) {
			list.add((VocabType) iv);
		}
		return list;
	}

	@Override
	public VocabType get(int id) {
		return (VocabType) iRepository.getVocabType(id);
	}

	@Override
	public boolean save(VocabType vocabType) {
		return iRepository.saveVocabType(vocabType);
	}

	@Override
	public boolean update(VocabType vocabType) {
		return iRepository.updateVocabType(vocabType);
	}

	@Override
	public boolean delete(VocabType vocabType) {
		return iRepository.deleteVocabType(vocabType);
	}
	
	public static void main(String []a) {
		System.out.println("ok");
	}
}
