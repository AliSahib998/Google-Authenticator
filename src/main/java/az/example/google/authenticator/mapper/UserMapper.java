package az.example.google.authenticator.mapper;


import az.example.google.authenticator.dao.entity.User;
import az.example.google.authenticator.model.RegistrationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class UserMapper {

    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(target = "firstName", source = "request.firstName"),
            @Mapping(target = "lastName", source = "request.lastName"),
            @Mapping(target = "email", source = "request.email"),
            @Mapping(target = "password", source = "request.password"),
            @Mapping(target = "2fa", source = "request.using2FA")
    })
    public abstract User mapUserEntity(RegistrationDto request);

}
