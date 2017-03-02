package by.hrychanok.training.shop.storefront.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import by.hrychanok.training.shop.service.CustomerService;
import by.hrychanok.training.shop.facades.dto.LoginDTO;

@Controller
@RequestMapping("/")
public class DefaultPageController
{
    @Autowired
    CustomerService customerService;

    @RequestMapping(value = { "/"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        return "home";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("msg", "Please Endter Your Login Details");
        return "login";
    }
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("loginBean") LoginDTO loginBean) {

        if (loginBean != null && loginBean.getUserName() != null & loginBean.getPassword() != null) {

            if (customerService.getCustomerByCredentials(loginBean.getUserName(), loginBean.getPassword()) != null) {
                model.addAttribute("username", loginBean.getUserName());
                return "redirect:/customerpanel";
            } else {
                model.addAttribute("error", "Invalid Details");
                return "login";
            }
        } else {
            model.addAttribute("error", "Please enter Details");
            return "login";
        }
    }
}
