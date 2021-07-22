package com.vocab.api.dao;

import java.util.ArrayList;
import java.util.List;

import com.vocab.api.base.IVocab;
import com.vocab.api.dao.base.IVocabDao;
import com.vocab.api.pojo.Vocab;

public class VocabDao extends AbsDao implements IVocabDao<Vocab> {

	@Override
	public List<Vocab> getAll() {
		List<IVocab> iList = iRepository.getAllVocab();
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
	public List<Vocab> getAllByLessonID(int id) {
		List<IVocab> iList = iRepository.getAllVocabByLessonID(id);
		List<Vocab> list = new ArrayList<Vocab>();
		for(IVocab iv : iList) {
			list.add((Vocab) iv);
		}
		return list;
	}

	@Override
	public List<Vocab> getAllByTypeID(int id) {
		List<IVocab> iList = iRepository.getAllVocabByTypeID(id);
		List<Vocab> list = new ArrayList<Vocab>();
		for(IVocab iv : iList) {
			list.add((Vocab) iv);
		}
		return list;
	}
}
