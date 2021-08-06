package com.vocab.api.dao;

import java.util.ArrayList;
import java.util.List;

import com.vocab.api.base.IStatus;
import com.vocab.api.dao.base.IStatusDao;
import com.vocab.api.pojo.Status;

public class StatusDao extends BaseDao implements IStatusDao<Status>{

	@Override
	public List<Status> getAll() {
		List<IStatus> iList = iRepository.getAllStatus();
		List<Status> list = new ArrayList<Status>();
		for(IStatus is : iList) {
			list.add((Status) is);
		}
		return list;
	}

	@Override
	public List<Status> getAll(int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status get(int id) {
		return (Status) iRepository.getStatus(id);
	}

	@Override
	public boolean save(Status status) {
		return iRepository.saveStatus(status);
	}

	@Override
	public boolean update(Status status) {
		return iRepository.updateStatus(status);
	}

	@Override
	public boolean delete(Status status) {
		return iRepository.deleteStatus(status);
	}

	public static void main(String[] ar) {
		System.out.println("OK");
		Status status = new Status();
		status.setStatus_id(1);
		status.setStatus_description("PHONG");
		StatusDao dao = new StatusDao();
		
		
//		System.out.println(dao.save(status));
//		System.out.println(dao.get(1).getStatus_description());
//		List<Status> list = dao.getAll();
//		for(Status i : list)
//			System.out.println(i.getStatus_id());
		System.out.println(dao.delete(status));
	}
}
