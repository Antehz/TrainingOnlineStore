package by.hrychanok.training.shop.storefront.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.hrychanok.training.shop.model.Customer;
import by.hrychanok.training.shop.model.CustomerCredentials;
import by.hrychanok.training.shop.service.CustomerService;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationPageController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("customerForm", new CustomerCredentials());

		return "registration";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registration(@ModelAttribute("customerForm") CustomerCredentials customerForm, BindingResult bindingResult,
			Model model) {
		// userValidator.validate(customerForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registration";
		}
      customerService.registerCustomer(new Customer(), customerForm);
		//userService.save(customerForm);

	//	securityService.autologin(customerForm.getUsername(), customerForm.getPasswordConfirm());

		return "redirect:/welcome";
	}

}
