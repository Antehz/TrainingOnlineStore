package by.hrychanok.training.shop.service.impl;

import by.hrychanok.training.shop.model.CartContent;
import by.hrychanok.training.shop.repository.CartContentRepository;
import by.hrychanok.training.shop.repository.filter.Filter;
import by.hrychanok.training.shop.service.CartService;
import by.hrychanok.training.shop.service.MultiCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Anton_Hrychanok on 2017-03-04.
 */
public class CartServiceAdapter {

    @Autowired
    private MultiCartService multiCartService;
    private final static Long DEFAULT_ID = 1L;


    public Boolean addProductToCart(Long productId, Long customerId, Integer amount) {
        return multiCartService.addProductToMultiCart(productId, customerId, DEFAULT_ID, amount);
    }

    public void clearCustomerCartContent(Long id) {
        multiCartService.clearCustomerMultiCartContent(id);
    }

}
