package com.dev.services;

import java.util.List;

import com.dev.beans.Asset;
import com.dev.beans.AssetAllocation;
import com.dev.beans.Employee;
import com.dev.beans.UserMaster;
import com.dev.dao.DAO;
import com.dev.dao.DAOImpl;

public class ServicesImpl implements Services {
	DAO d=new DAOImpl();
	@Override
	public UserMaster loginService(Integer userid, String password) {

		return d.login(userid, password);
	}
	@Override
	public Asset addAssetService(Asset asset) {
		return d.addAsset(asset);
	}
	@Override
	public Asset removeAssetService(Integer aid) {

		return d.removeAsset(aid);
	}
	@Override
	public List<Asset> getAllAssetService() {
		return d.getAllAsset();
	}
	@Override
	public Employee addEmployeeService(Employee employee) {

		return d.addEmployee(employee);
	}
	@Override
	public AssetAllocation raiseAllocationService(AssetAllocation assetallocation) {
		return d.raiseAllocation(assetallocation);
	}
	@Override
	public List<AssetAllocation> getAllAssetAllocationService() {

		return d.getAllAssetAllocation();
	}
	@Override
	public Boolean setStatusService(Integer allocationid, String assetstatus) {

		return d.setStatus(allocationid,assetstatus);
	}
	@Override
	public String viewStatusService(Integer allocationid) {
		return d.viewStatus(allocationid);
	}

	// @Override
	// public List<Asset> getAllAllocatedAssetService() {
	// // TODO Auto-generated method stub
	// return d.getAllAllocatedAsset();
	// }
	@Override
	public Asset updateAssetNameService(Integer aid, String assetname) {
		return d.updateAssetName(aid, assetname);
	}
	@Override
	public Asset updateAssetDesService(Integer aid, String assetdes) {
		return d.updateAssetDes(aid, assetdes);
	}
	@Override
	public Asset updateAssetQuantityService(Integer aid, Integer assetquan) {
		return d.updateAssetQuantity(aid, assetquan);
	}
	@Override
	public Asset updateAssetStatusService(Integer aid, String assetstatus) {
		return d.updateAssetStatus(aid, assetstatus);
	}






}
