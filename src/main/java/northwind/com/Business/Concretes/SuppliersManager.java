package northwind.com.Business.Concretes;

import northwind.com.Business.Abstracts.SuppliersService;
import northwind.com.DataAccess.SuppliersRepository;
import northwind.com.Entities.Concrete.Suppliers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuppliersManager implements SuppliersService {
    @Autowired
    SuppliersRepository suppliersRepository;
    @Override
    public List<Suppliers> getAll(Suppliers supplier)
    {
       return  suppliersRepository.findAll();

    }
    @Override
    public Suppliers getById(int id)
    {
        return suppliersRepository.findById(id).get();
    }
    @Override
    public void createRow(Suppliers supplier)
    {
         suppliersRepository.save(supplier);
    }
    @Override
    public void deleteRow(int id)
    {
         suppliersRepository.deleteById(id);
    }
    @Override
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
