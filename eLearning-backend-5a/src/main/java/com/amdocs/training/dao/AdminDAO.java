package com.amdocs.training.dao;

import java.util.List;

import com.amdocs.training.model.Admin;
import com.amdocs.training.model.User;

public interface AdminDAO {

	List<Admin> findAll();

	boolean addAdmin(Admin admin);
//
//	User getAdminById(Long id);
//
//	boolean deleteAdmin(Long id);
//
//	boolean updateAdmin(Admin admin);
}
