package ma.enset.digitalbanking.repositories;

import ma.enset.app.digitalbanking.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByNameContains(String keyword);
    @Query("SELECT c FROM Customer c WHERE c.name LIKE %:k%")
    List<Customer> searchByName(@Param("k") String keyword);
}
