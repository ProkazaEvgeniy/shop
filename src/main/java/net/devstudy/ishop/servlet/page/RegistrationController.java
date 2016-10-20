package net.devstudy.ishop.servlet.page;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.devstudy.ishop.Constants;
import net.devstudy.ishop.entity.Account;
import net.devstudy.ishop.form.RegistrationForm;
import net.devstudy.ishop.servlet.AbstractController;
import net.devstudy.ishop.util.RoutingUtils;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@WebServlet("/registration")
public class RegistrationController extends AbstractController {
	private static final long serialVersionUID = -8146770694377066438L;
	private final static Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RoutingUtils.forwardToPage("registration.jsp", req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RegistrationForm registrationForm = createRegistrationForm(req);
		Account accountView = getRegistrastionService().findByEmail(registrationForm.getEmail());
		if(accountView == null){
			Account accountRegistation = getRegistrastionService().registration(new Account(
					registrationForm.getName(), 
					registrationForm.getEmail(), 
					"/media/avatar/" + registrationForm.getAvatarUrl()));
			LOGGER.info("Created new account : " + accountRegistation.toString());
			req.getSession().setAttribute(Constants.CURRENT_ACCOUNT, accountRegistation);
		} else {
			if (registrationForm.getEmail().equals(accountView.getEmail())) {
				req.getSession().setAttribute(Constants.CURRENT_ACCOUNT, accountView);
				LOGGER.info("I went account : " + accountView.toString());
			} else {
				Account accountRegistation = getRegistrastionService().registration(new Account(
						registrationForm.getName(), 
						registrationForm.getEmail(), "/media/avatar/" + registrationForm.getAvatarUrl()));
				LOGGER.info("Created new account : " + accountRegistation.toString());
				req.getSession().setAttribute(Constants.CURRENT_ACCOUNT, accountRegistation);
			}
		}
		RoutingUtils.redirect("/products", req, resp);
	}
}
