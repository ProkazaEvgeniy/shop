package net.devstudy.ishop.service;

import net.devstudy.ishop.entity.Account;

public interface RegistrastionService {

	Account registration(Account account);
	
	Account findByEmail(String email);
}
