package northwind.com.Business.Abstracts;

import northwind.com.Entities.Concrete.Suppliers;

import java.util.List;

public interface SuppliersService {
    List<Suppliers> getAll(Suppliers supplier);
    Suppliers getById(int id);
    void createRow(Suppliers supplier);
    void deleteRow(int id);
    void updateRow(Suppliers supplier);
}
