package northwind.com.Business.Concretes;

import northwind.com.Business.Abstracts.SuppliersService;
import northwind.com.Core.Result.DataResult;
import northwind.com.Core.Result.Result;
import northwind.com.Core.Result.SuccessDataResult;
import northwind.com.Core.Result.SuccessResult;
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
    public DataResult<List<Suppliers>> getAll(Suppliers supplier)
    {
        List<Suppliers> all = suppliersRepository.findAll();
        return new DataResult<>(true,"list is showing now successfully",all);

    }
    @Override
    public DataResult<Suppliers> getById(int id)
    {

                Suppliers supplier = suppliersRepository.findById(id).get();
                return new DataResult<>(true,"object has been listed successfully",supplier);
    }
    @Override
    public Result createRow(Suppliers supplier)
    {

        suppliersRepository.save(supplier);
        return new SuccessResult(true,"has been created successfully");

    }
    @Override
    public Result deleteRow(int id)
    {
        suppliersRepository.deleteById(id);
        return new SuccessResult(true,"has been deleted succesfully");
    }
    @Override
    public Result updateRow(Suppliers supplier)
    { Suppliers tempSupplier = getById(supplier.getSupplierId()).getData();
        tempSupplier.setSupplierName(supplier.getSupplierName());
        tempSupplier.setCountry(supplier.getCountry());
        tempSupplier.setCity(supplier.getCity());
        tempSupplier.setAddress(supplier.getAddress());
        tempSupplier.setContactName(supplier.getContactName());
        tempSupplier.setPostalcode(supplier.getPostalcode());
        tempSupplier.setPhone(supplier.getPhone());
        return new SuccessDataResult<>(true, "has been updated successfully",tempSupplier);

    }
}
