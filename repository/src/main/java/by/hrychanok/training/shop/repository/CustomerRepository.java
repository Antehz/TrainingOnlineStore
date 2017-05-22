package by.hrychanok.training.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import by.hrychanok.training.shop.model.Customer;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomerRepositoryCustom,
    JpaSpecificationExecutor<Customer> {

    @Query(value = "SELECT * FROM CUSTOMER c WHERE c.email like ?1", nativeQuery = true)
    Customer findByEmail(String email);

    Customer findOneByCity(Long id, String city);

}
