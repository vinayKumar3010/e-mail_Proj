package com.org.mail.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.org.mail.exceptions.ControllerException;
import com.org.mail.exceptions.ServiceException;
import com.org.mail.service.EmailService;

@Controller
@RequestMapping("/")
public class EmailController extends ControllerException {

	private static Logger logger = Logger.getLogger(EmailController.class);

	public EmailController() {
		logger.info("inside getMessage()...Invoked :" + this.getClass().getSimpleName());
	}

	@Autowired
	private EmailService service;

	
	@RequestMapping("/sendMail.do")
	public ModelAndView sendMail(String emailId, String subject, String body) {

		try {
			logger.info("inside getMessage()...Invoked sendMail()");
			logger.info("Email: " + emailId);
			logger.info("Subject: " + subject);
			logger.info("Body: " + body);

			ModelAndView mv = new ModelAndView("home");
			try {
				service.sendMailToUser(emailId, subject, body);
			} catch (ServiceException e) {
				logger.error(e.getMessage(), e);
			}
			mv.addObject("key", "Mail Sent Succesfully");

			return mv;
		} catch (Exception c) {
				try {
					throw new ControllerException(c.getMessage());
				} catch (ControllerException e) {
						logger.error("Exception:"+e.getMessage(),e);
					
				}
		}
		return null;

	}
}
