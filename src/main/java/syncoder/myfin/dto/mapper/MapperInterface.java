package syncoder.myfin.dto.mapper;

@FunctionalInterface
public interface MapperInterface<T, R> {
    R toDto(T t);

    default T toEntity(R r){
        throw new UnsupportedOperationException("Conversion is not implemented");
    }
}
