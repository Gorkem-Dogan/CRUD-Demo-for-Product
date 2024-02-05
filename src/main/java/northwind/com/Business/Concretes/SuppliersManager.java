package northwind.com.Business.Concretes;

import northwind.com.DataAccess.SuppliersRepository;
import northwind.com.Entities.Concrete.Suppliers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuppliersManager {
    @Autowired
    SuppliersRepository suppliersRepository;
    public List<Suppliers> getAll(Suppliers supplier)
    {
       return  suppliersRepository.findAll();

    }
    public Suppliers getById(int id)
    {
        return suppliersRepository.findById(id).get();
    }
    public void createRow(Suppliers supplier)
    {
         suppliersRepository.save(supplier);
    }
    public void deleteRow(int id)
    {
         suppliersRepository.deleteById(id);
    }
    public void updateRow(Suppliers supplier)
    { Suppliers tempSupplier = getById(supplier.getSupplierId());
        tempSupplier.setSupplierName(supplier.getSupplierName());
        tempSupplier.setCountry(supplier.getCountry());
        tempSupplier.setCity(supplier.getCity());
        tempSupplier.setAddress(supplier.getAddress());
        tempSupplier.setContactName(supplier.getContactName());
        tempSupplier.setPostalcode(supplier.getPostalcode());
        tempSupplier.setPhone(supplier.getPhone());

    }
}
