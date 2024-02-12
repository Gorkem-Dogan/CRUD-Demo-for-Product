package northwind.com.DataAccess;

import northwind.com.Entities.Concrete.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer> {
}
