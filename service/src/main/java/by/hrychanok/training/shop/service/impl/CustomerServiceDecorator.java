package by.hrychanok.training.shop.service.impl;

import by.hrychanok.training.shop.model.Customer;
import by.hrychanok.training.shop.model.CustomerCredentials;
import by.hrychanok.training.shop.repository.CustomerCredentialsRepository;
import by.hrychanok.training.shop.repository.CustomerRepository;
import by.hrychanok.training.shop.repository.filter.Comparison;
import by.hrychanok.training.shop.repository.filter.Condition;
import by.hrychanok.training.shop.repository.filter.Filter;
import by.hrychanok.training.shop.service.CustomerService;
import by.hrychanok.training.shop.service.exeption.ServiceException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Anton_Hrychanok on 2017-03-04.
 */
@Service
@Transactional
public class CustomerServiceDecorator extends BasicServiceDecorator<Customer, CustomerRepository, Long> implements CustomerService {

    @Autowired
    CustomerCredentialsRepository customerCredentialsRepository;
    @Autowired
    MailService mail;
    @InitLogger
    Logger logger;

    @Autowired
    public CustomerServiceDecorator(CustomerRepository repository) {
        super(repository);
    }

    @Override
    public CustomerCredentials getCustomerByCredentials(String login, String password) {
        Customer customer = null;
        logger.debug("Get customer by credentials  login:{}, password: {}", login, password);
        return customerCredentialsRepository.findByLoginAndPassword(login, password);
    }

    @Override
    public Customer registerCustomer(Customer customer, CustomerCredentials customerCredentials) {
        boolean exist = checkExistUser(customerCredentials.getLogin());
        if (!exist) {
            customer.setCustomerCredentials(customerCredentials);
            customer = repository.save(customer);
            if (customer != null) {
                logger.info("Customer succesfully registred : {}", customer);
                //mail.sendRegistrationNotificationMail(customer);
            }
        } else {
            throw new ServiceException(String.format("Customer with login: %s, or EMail: %s already exist!",
                    customerCredentials.getLogin(), customer.getEmail()));
        }
        return customer;
    }

    @Override
    public List<Customer> find(Filter filter) {
        List<Customer> listFiltered = repository.findAll(filter);
        if (listFiltered.isEmpty()) {
            logger.debug("Not found any matches ");
        }
        return listFiltered;
    }

    private Boolean checkExistUser(String login) {
        Filter cFilter = new Filter();
        cFilter.addCondition(new Condition.Builder().setComparison(Comparison.eq).setField("login")
                .setValue(login).build());
        List<CustomerCredentials> list = customerCredentialsRepository.findAll(cFilter);
        return !list.isEmpty();
    }

    @Override
    public Long count(Filter filter) {
        return repository.count(filter);
    }

    @Override
    public Collection<? extends String> resolveRoles(Long id) {
        CustomerCredentials customerCredentials = customerCredentialsRepository.findOne(id);
        return Collections.singletonList(customerCredentials.getRole().name());
    }

    @Override
    public Boolean loginIsAvailable(String login) {
        if (customerCredentialsRepository.findByLogin(login) != null) {
            return false;
        } else {
            return true;

        }
    }

    @Override
    public Boolean emailIsAvailable(String email) {
        if (repository.findByEmail(email) != null) {
            return false;
        }
        return true;

    }

    @Override
    public List<Customer> findAll(Filter filter, Pageable page) {
        if (filter.existCondition()) {
            return repository.findAll(filter, page).getContent();
        }
        return repository.findAll(page).getContent();

    }
}
