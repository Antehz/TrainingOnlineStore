package by.hrychanok.training.shop.service;

import by.hrychanok.training.shop.service.impl.CartServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Anton_Hrychanok on 2017-03-04.
 */
public class MultiCartServiceImpl implements MultiCartService {

    private static Logger LOGGER = LoggerFactory.getLogger(CartServiceImpl.class);

    @Override
    public void clearCustomerMultiCartContent(Long id) {
        System.out.println("imlementation...");
    }

    @Override
    public Boolean addProductToMultiCart(Long productId, Long customerId, Long cartId, Integer amount) {
        return null;
    }
}
