package com.dev.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.dev.beans.Asset;
import com.dev.beans.AssetAllocation;
import com.dev.beans.Employee;
import com.dev.beans.UserMaster;
import com.dev.exceptions.AddAssetException;
import com.dev.exceptions.AddEmployeeException;
import com.dev.exceptions.AllAssetAllocationException;
import com.dev.exceptions.LoginException;
import com.dev.exceptions.RaiseAllocationException;
import com.dev.exceptions.RemoveAssetException;
import com.dev.exceptions.UpdateAssetException;
import com.dev.repo.Database;
import com.dev.validations.Validate;

public class DAOImpl implements DAO {
	Database db = new Database();
	Validate v = new Validate();
	AddEmployeeException addemployeeexception = new AddEmployeeException();

	@Override
	public UserMaster login(Integer userid, String password) {

		if (db.map.containsKey(userid)) {
			UserMaster um = db.map.get(userid);
			if (um.getUserpassword().equals(password)) {
				return um;
			}
		} else {
			System.out.println("enter correct username and password");
		}
		throw new LoginException();
	}

	@Override
	public Asset addAsset(Asset asset) {

		if (!db.mapa.containsKey(asset.getAssetid())) {
			db.mapa.put(asset.getAssetid(), asset);
			return asset;
		} else {
			System.out.println("asset id already present");
			throw new AddAssetException();
		}
	}

	@Override
	public Asset removeAsset(Integer aid) {
		Asset a = new Asset();
		if (db.mapa.containsKey(aid)) {
			a = db.mapa.remove(aid);
			return a;
		} else {
			throw new RemoveAssetException();
		}

	}

	@Override
	public List<Asset> getAllAsset() {
		if (!db.mapa.isEmpty()) {
			List<Asset> l = new ArrayList<Asset>(db.mapa.values());
			Iterator<Asset> it = l.iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
			}

			return l;
		} else {
			System.out.println("no assets are present");
			return null;
		}
	}

	@Override
	public Employee addEmployee(Employee employee) {
		if (!db.mape.containsKey(employee.getEmpno())) {
			if (db.mapd.containsKey(employee.getDeptid())) {
				db.mape.put(employee.getEmpno(), employee);
				return employee;
			}
			System.out.println("dept is not present");
			throw addemployeeexception;
		} else {
			System.out.println("employee is already present");
			throw addemployeeexception;
		}
	}

	@Override
	public AssetAllocation raiseAllocation(AssetAllocation assetallocation) {
		if (!db.mapas.containsKey(assetallocation.getAllocationid())) {
			db.mapas.put(assetallocation.getAllocationid(), "null");
			if (!db.mapaa.containsKey(assetallocation.getAllocationid())) {
				db.mapaa.put(assetallocation.getAllocationid(), assetallocation);
				return assetallocation;
			}
		} else {
			throw new RaiseAllocationException();
		}
		throw new RaiseAllocationException();
	}

	@Override
	public List<AssetAllocation> getAllAssetAllocation() {
		if (!db.mapaa.isEmpty()) {
			List<AssetAllocation> ll = new ArrayList<AssetAllocation>(db.mapaa.values());
			Iterator<AssetAllocation> it = ll.iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
			}
			return ll;

		} else {
			System.out.println("raise list is not available");
			throw new AllAssetAllocationException();
		}
	}

	@Override
	public Boolean setStatus(Integer allocationid, String allocationstatus) {
		if (db.mapaa.containsKey(allocationid)) {
			db.mapas.put(allocationid, allocationstatus);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String viewStatus(Integer allocationid) {
		if (db.mapas.containsKey(allocationid)) {

			String s = db.mapas.get(allocationid);
			if (!s.isEmpty()) {
				return s;
			} else {
				return "status not available";
			}

		} else {
			return "Status not available";

		}
	}

	@Override
	public Asset updateAssetName(Integer aid, String assetname) {
		if (db.mapa.containsKey(aid)) {
			Asset s = db.mapa.get(aid);
			s.setAssetname(assetname);
			return s;
		} else {
			throw new UpdateAssetException();
		}
	}

	@Override
	public Asset updateAssetDes(Integer aid, String assetdes) {
		if (db.mapa.containsKey(aid)) {
			Asset s1 = db.mapa.get(aid);
			s1.setAssetdes(assetdes);
			return s1;
		} else {
			throw new UpdateAssetException();
		}
	}

	@Override
	public Asset updateAssetQuantity(Integer aid, Integer assetquan) {
		if (db.mapa.containsKey(aid)) {
			Asset s2 = db.mapa.get(aid);
			s2.setQuantity(assetquan);
			return s2;
		} else {
			throw new UpdateAssetException();
		}
	}

	@Override
	public Asset updateAssetStatus(Integer aid, String assetstatus) {
		if (db.mapa.containsKey(aid)) {
			Asset s3 = db.mapa.get(aid);
			s3.setStatus(assetstatus);
			return s3;
		} else {
			throw new UpdateAssetException();
		}
	}
}
