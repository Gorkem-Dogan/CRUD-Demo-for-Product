package northwind.com.Core.Mapping;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
public class ModelMapperServiceImpl implements ModelMapperService {

    private ModelMapper modelMapper;

    public ModelMapperServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ModelMapper forResponce() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        return this.modelMapper;
    }

    @Override
    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);
        return this.modelMapper;
    }

}
