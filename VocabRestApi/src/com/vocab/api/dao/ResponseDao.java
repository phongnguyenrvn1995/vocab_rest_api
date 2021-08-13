package com.vocab.api.dao;

import java.util.ArrayList;
import java.util.List;

import com.vocab.api.base.IResponse;
import com.vocab.api.dao.base.IResponseDao;
import com.vocab.api.pojo.Response;

public class ResponseDao extends BaseDao implements IResponseDao<Response>{

	@Override
	public int getAllCount(String searchStr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Response> getAll(String searchStr) {
		List<IResponse> iList = iRepository.getResponseAll(searchStr);
		List<Response> list = new ArrayList<Response>();
		for(IResponse ir : iList) {
			list.add((Response) ir);
		}
		return list;
	}	
	
	@Override
	public List<Response> getAll(String searchStr, int limit, int offset) {
		List<IResponse> iList = iRepository.getResponseAll(searchStr, limit, offset);
		List<Response> list = new ArrayList<Response>();
		for(IResponse ir : iList) {
			list.add((Response) ir);
		}
		return list;
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
