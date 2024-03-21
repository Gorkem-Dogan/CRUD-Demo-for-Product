package northwind.com.Business.Abstracts;

import northwind.com.Core.Result.DataResult;
import northwind.com.Core.Result.Result;
import northwind.com.Entities.Concrete.Suppliers;

import java.util.List;

public interface SuppliersService {
    DataResult<List<Suppliers>> getAll(Suppliers supplier);
    DataResult getById(int id);
    Result createRow(Suppliers supplier);
    Result deleteRow(int id);
    Result updateRow(Suppliers supplier);
}
