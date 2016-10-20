package net.devstudy.ishop.service.impl;

import net.devstudy.framework.annotation.Autowired;
import net.devstudy.framework.annotation.Component;
import net.devstudy.framework.annotation.jdbc.Transactional;
import net.devstudy.ishop.entity.Account;
import net.devstudy.ishop.repository.RegistrastionRepository;
import net.devstudy.ishop.service.RegistrastionService;

@Transactional
@Component
public class RegistrastionServiceImpl implements RegistrastionService {

	@Autowired
	private RegistrastionRepository registrastionRepository;

	@Override
	@Transactional(readOnly = false)
	public Account registration(Account account) {
		return registrastionRepository.registration(account);
	}
	
	@Override
	public Account findByEmail(String email) {
		return registrastionRepository.findByEmail(email);
	}

}
