package com.org.mail.service;

import com.org.mail.exceptions.ServiceException;

public interface EmailService {

	public boolean sendMailToUser(String toEmailId, String subject, String body) throws ServiceException;

}
