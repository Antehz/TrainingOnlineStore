package by.hrychanok.training.shop.storefront.controllers;

import by.hrychanok.training.shop.facades.CustomerFacade;
import by.hrychanok.training.shop.facades.dto.CustomerDTO;
import by.hrychanok.training.shop.storefront.validator.CustomerCrDTOValidation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping(value = "/registration")
public class RegistrationPageController
{

	@Autowired
	private CustomerFacade customerFacade;

	@Autowired
	private CustomerCrDTOValidation customerDTOValidation;

	@RequestMapping(method = RequestMethod.GET)
	public String registration(Model model)
	{
		model.addAttribute("customerRegForm", new CustomerDTO());
		return "registration";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registration(@ModelAttribute("customerRegForm") CustomerDTO customerRegForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes)
	{

		customerDTOValidation.validate(customerRegForm, bindingResult);

		if (bindingResult.hasErrors())
		{
			return "registration";
		}
		customerFacade.registerCustomer(customerRegForm);
		redirectAttributes.addFlashAttribute("username", customerRegForm.getFirstName());
		return "redirect:/customerpanel";
	}

}
