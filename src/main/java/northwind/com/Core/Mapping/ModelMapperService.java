package northwind.com.Core.Mapping;
import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    ModelMapper forResponce();
    ModelMapper forRequest();
}

