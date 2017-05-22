package by.hrychanok.training.shop.service;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import by.hrychanok.training.shop.model.CartContent;
import by.hrychanok.training.shop.model.Customer;
import by.hrychanok.training.shop.model.CustomerCredentials;
import by.hrychanok.training.shop.model.Gender;
import by.hrychanok.training.shop.model.Order;
import by.hrychanok.training.shop.model.UserRole;
import by.hrychanok.training.shop.repository.filter.Comparison;
import by.hrychanok.training.shop.repository.filter.Condition;
import by.hrychanok.training.shop.repository.filter.CustomerFilter;
import by.hrychanok.training.shop.repository.filter.Filter;
import by.hrychanok.training.shop.service.configuration.TestDataBaseConfig;
import junit.framework.Assert;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class CustomerServiceTest {

    @Resource
    private CustomerService customerService;
    Customer customer;
    List<Customer> customerList = new ArrayList();;
    int count = 5;

    @Before
    public void createCustomer() {
        customerService.deleteAll();

        int i = 777;
        for (i = 0; i < count; i++) {
            Customer cTest = new Customer();
            CustomerCredentials cCredentials = new CustomerCredentials();
            cCredentials.setLogin(String.format("%stestUser", i));
            cCredentials.setPassword("testPassword");
            cCredentials.setRole(UserRole.customer);
            cTest.setFirstName(i + "testFirstName");
            cTest.setLastName("testLastName");
            cTest.setEmail(String.format("%stestEmail@ya.ru", i));
            Random x = new Random();
            int s = x.nextInt(6);
            cTest.setAddress("Gorkogo " + s);
            cTest.setCity("Hrodno");
            cTest.setCountry("Belarus " + s);
            cTest.setDateBirth(new Date(12 - 12 - 2000));
            cTest.setCreated(new Date());
            cTest.setGender(Gender.UNKNOWN);
            cTest.setZipCode("230020");
            customer = customerService.registerCustomer(cTest, cCredentials);
            customerList.add(customer);
        }
    }

    @Test
    public void getCustomer() {
        Random random = new Random();
        int randomIndex = random.nextInt(count);
        customer = customerList.get(randomIndex);
        Long initialId = customer.getId();
        customer = (customerService.findOne(initialId));
        org.junit.Assert.assertNotNull(customer);
    }

    @Test
    public void найтиКлиентаПоГороду() {
        Random random = new Random();
        int randomIndex = random.nextInt(count);
        customer = customerList.get(randomIndex);
        Long initialId = customer.getId();
        customer = (customerService.findByCity(initialId, "Hrodno"));
        org.junit.Assert.assertNotNull(customer);
    }

    @Test
	public void  checkEmalIsAvailable() {
		Random random = new Random();
		int randomIndex = random.nextInt(count);
		customer = customerList.get(randomIndex);
		Long initialId = customer.getId();
	    boolean isAvalaible = customerService.emailIsAvailable(initialId+ "testEmail@ya.ru");
		org.junit.Assert.assertFalse(isAvalaible);
	}

    @Test
    public void updateCustomer() {
        String firstNameUpd = "testUserUpdateName";
        String loginUpd = "testLoginUPDATE";
        Random random = new Random();
        int randomIndex = random.nextInt(10);
        customer = customerList.get(randomIndex);
        customer.getCustomerCredentials().setLogin(loginUpd);
        customer.setFirstName(firstNameUpd);
        customerService.saveAndFlush(customer);
        Assert.assertEquals(firstNameUpd, customerService.findOne(customer.getId()).getFirstName());
        Assert.assertEquals(loginUpd, customerService.findOne(customer.getId())
            .getCustomerCredentials().getLogin());
    }

    @Test
    public void getCustomerByCredentials() {
        CustomerCredentials getCustomer =
            customerService.getCustomerByCredentials("3testUser", "testPassword");
        Assert.assertNotNull(getCustomer);
    }

    @Test
    public void deleteCustomer() {
        Random random = new Random();
        int randomIndex = random.nextInt(10);
        customer = customerList.get(randomIndex);
        customerService.delete(customer.getId());
        Assert.assertNull(customerService.findOne(customer.getId()));
    }

    @Test
    public void findAll() {
        List<Customer> list = customerService.findAll();
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void findAllSort() {
        Sort sort = new Sort(Sort.Direction.ASC, "firstName");
        List<Customer> list = customerService.findAll();
        for (Customer customer : list) {
            System.out.println(customer);
        }
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void count() {
        Long count1 = customerService.count();
        Long count2 = (long) customerList.size();
        System.out.println("count1 = " + count1 + " ,count2 = " + count2);
        Assert.assertEquals(count1, count2);
    }

    @Test
    public void findWithFilter() {

        CustomerFilter cFilter = new CustomerFilter();
        List<Customer> list = customerService.find(cFilter);
        Assert.assertEquals(count, list.size());
        int limit = 3;
        cFilter.setLimit(limit);
        int offset = 0;
        cFilter.setOffset(offset);
        list = customerService.find(cFilter);
        Assert.assertEquals(limit, list.size());
        cFilter.setLimit(null);
        cFilter.setOffset(null);
        cFilter.setSortOrder(true);
        list = customerService.find(cFilter);
        Assert.assertEquals(count, list.size());
    }

}
