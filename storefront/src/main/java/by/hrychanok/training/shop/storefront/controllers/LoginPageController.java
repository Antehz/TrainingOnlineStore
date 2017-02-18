package by.hrychanok.training.shop.storefront.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import by.hrychanok.training.shop.service.CustomerService;
import by.hrychanok.training.shop.storefront.controllers.dto.LoginBean;

@Controller
@RequestMapping("/login")
public class LoginPageController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute("msg", "Please Endter Your Login Details");
        System.out.printf("sds");
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("loginBean") LoginBean loginBean) {
        if (loginBean != null && loginBean.getUserName() != null & loginBean.getPassword() != null) {

            if (customerService.getCustomerByCredentials(loginBean.getUserName(), loginBean.getPassword()) != null) {
                model.addAttribute("msg", loginBean.getUserName());
                return "success";
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
