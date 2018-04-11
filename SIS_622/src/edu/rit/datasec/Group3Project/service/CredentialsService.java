package edu.rit.datasec.Group3Project.service;

import org.mindrot.jbcrypt.BCrypt;

import edu.rit.datasec.Group3Project.bo.Role;
import edu.rit.datasec.Group3Project.dao.CredentialsDAO;

public class CredentialsService {
	private static CredentialsService credService;

	private CredentialsService() {

	}

	public static CredentialsService getInstance() {
		if (credService == null) {
			credService = new CredentialsService();
		}
		return credService;
	}

	public Role checkLogin(String user, String password) {
		String hash = CredentialsDAO.getInstance().getPasswordHash(user);
		if (BCrypt.checkpw(password, hash))
			return CredentialsDAO.getInstance().getRole(user);
		else
			throw new RuntimeException("Invalid login credentials");

	}


}
