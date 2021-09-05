package com.vocab.api.dao;

import java.util.ArrayList;
import java.util.List;

import com.vocab.api.base.IVocab;
import com.vocab.api.dao.base.IVocabDao;
import com.vocab.api.pojo.Vocab;

public class VocabDao extends BaseDao implements IVocabDao<Vocab> {

	@Override
	public int getAllCount(String searchStr) {
		return iRepository.getAllVocabCount(searchStr);
	}

	@Override
	public List<Vocab> getAll(String searchStr) {
		List<IVocab> iList = iRepository.getAllVocab(searchStr);
		List<Vocab> list = new ArrayList<Vocab>();
		for(IVocab iv : iList) {
			list.add((Vocab) iv);
		}
		return list;
	}

	@Override
	public Vocab get(int id) {
		return (Vocab) iRepository.getVocab(id);
	}

	@Override
	public List<Vocab> getAll(String searchStr, int limit, int offset) {
		List<IVocab> iList = iRepository.getAllVocab(searchStr, limit, offset);
		List<Vocab> list = new ArrayList<Vocab>();
		for(IVocab iv : iList) {
			list.add((Vocab) iv);
		}
		return list;
	}

	@Override
	public boolean save(Vocab vocab) {
		return iRepository.saveVocab(vocab);
	}

	@Override
	public boolean update(Vocab vocab) {
		return iRepository.updateVocab(vocab);
	}

	@Override
	public boolean delete(Vocab vocab) {
		return iRepository.deleteVocab(vocab);
	}

	@Override
	public int getAllByLessonIDCount(String searchStr, int id) {
		return iRepository.getAllVocabByLessonIDCount(searchStr, id);
	}

	@Override
	public List<Vocab> getAllByLessonID(String searchStr, int id) {
		List<IVocab> iList = iRepository.getAllVocabByLessonID(searchStr, id);
		List<Vocab> list = new ArrayList<Vocab>();
		for(IVocab iv : iList) {
			list.add((Vocab) iv);
		}
		return list;
	}
	
	@Override
	public List<Vocab> getAllByLessonID(String searchStr, int id, int limit, int offset) {
		List<IVocab> iList = iRepository.getAllVocabByLessonID(searchStr, id, limit, offset);
		List<Vocab> list = new ArrayList<Vocab>();
		for(IVocab iv : iList) {
			list.add((Vocab) iv);
		}
		return list;
	}

	@Override
	public int getAllByTypeIDCount(String searchStr, int id) {
		return iRepository.getAllVocabByTypeIDCount(searchStr, id);
	}

	@Override
	public List<Vocab> getAllByTypeID(String searchStr, int id) {
		List<IVocab> iList = iRepository.getAllVocabByTypeID(searchStr, id);
		List<Vocab> list = new ArrayList<Vocab>();
		for(IVocab iv : iList) {
			list.add((Vocab) iv);
		}
		return list;
	}

	@Override
	public List<Vocab> getAllByTypeID(String searchStr, int id, int limit, int offset) {
		List<IVocab> iList = iRepository.getAllVocabByTypeID(searchStr, id, limit, offset);
		List<Vocab> list = new ArrayList<Vocab>();
		for(IVocab iv : iList) {
			list.add((Vocab) iv);
		}
		return list;
	}

	@Override
	public int getWithFilterCount(String searchStr, int typeId, int lessonId) {
		return iRepository.getVocabFilterCount(searchStr, typeId, lessonId);
	}

	@Override
	public List<Vocab> getWithFilter(String searchStr, int typeId, int lessonId) {
		List<IVocab> iList = iRepository.getVocabFilter(searchStr, typeId, lessonId);
		List<Vocab> list = new ArrayList<Vocab>();
		for(IVocab iv : iList) {
			list.add((Vocab) iv);
		}
		return list;
	}

	@Override
	public List<Vocab> getWithFilter(String searchStr, int typeId, int lessonId, int limit, int offset) {
		List<IVocab> iList = iRepository.getVocabFilter(searchStr, typeId, lessonId, limit, offset);
		List<Vocab> list = new ArrayList<Vocab>();
		for(IVocab iv : iList) {
			list.add((Vocab) iv);
		}
		return list;
	}
}
