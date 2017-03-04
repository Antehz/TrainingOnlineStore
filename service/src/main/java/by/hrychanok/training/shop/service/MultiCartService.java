package by.hrychanok.training.shop.service;

/**
 * Created by Anton_Hrychanok on 2017-03-04.
 */
public interface MultiCartService {

    void clearCustomerMultiCartContent(Long id);

    Boolean addProductToMultiCart(Long productId, Long customerId, Long cartId, Integer amount);
}
