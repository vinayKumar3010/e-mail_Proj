package com.org.mail.util;

import com.org.mail.exceptions.UtilException;

public interface EmailUtil {
	public boolean sendMail(String toEmailId, String body, String subject) throws UtilException;

}
