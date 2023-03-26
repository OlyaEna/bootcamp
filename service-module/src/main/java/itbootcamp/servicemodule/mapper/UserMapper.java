package itbootcamp.servicemodule.mapper;

import itbootcamp.repositorymodule.entity.User;
import itbootcamp.servicemodule.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
@Data
public class UserMapper {
    private ModelMapper modelMapper;

    public User toEntity(UserDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, User.class);
    }

    public UserDto toDto(User entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, UserDto.class);
    }

    public List<UserDto> listToDto(List<User> entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, new TypeToken<List<UserDto>>() {
        }.getType());
    }


}
