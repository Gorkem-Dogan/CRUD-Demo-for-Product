package northwind.com.DataAccess;

import northwind.com.Entities.Concrete.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SuppliersRepository extends JpaRepository<Suppliers,Integer> {

}
