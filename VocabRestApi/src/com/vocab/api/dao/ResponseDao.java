package com.vocab.api.dao;

import java.util.ArrayList;
import java.util.List;

import com.vocab.api.base.IResponse;
import com.vocab.api.dao.base.IResponseDao;
import com.vocab.api.pojo.Response;

public class ResponseDao extends BaseDao implements IResponseDao<Response>{

	@Override
	public List<Response> getAll() {
		List<IResponse> iList = iRepository.getResponseAll();
		List<Response> list = new ArrayList<Response>();
		for(IResponse ir : iList) {
			list.add((Response) ir);
		}
		return list;
	}	
	
	@Override
	public List<Response> getAll(int limit, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response get(int id) {
		return (Response) iRepository.getResponse(id);
	}

	@Override
	public boolean save(Response response) {
		return iRepository.saveResponse(response);
	}

	@Override
	public boolean update(Response response) {
		return iRepository.updateResponse(response);
	}

	@Override
	public boolean delete(Response response) {
		return iRepository.deleteResponse(response);
	}
}
