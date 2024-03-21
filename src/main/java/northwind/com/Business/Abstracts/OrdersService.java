package northwind.com.Business.Abstracts;

import northwind.com.Core.Result.DataResult;
import northwind.com.Core.Result.Result;
import northwind.com.Entities.Concrete.Orders;

import java.util.List;

public interface OrdersService {
     DataResult<List<Orders>> getAll();

    DataResult<Orders> getById(int id);
    Result createNewRow(Orders order);
    Result deleteRow (int id);
    Result update(Orders order);

}
