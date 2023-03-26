package itbootcamp.servicemodule.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import itbootcamp.repositorymodule.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonPropertyOrder({ "fullName", "email", "role" })
public class UserDto {
    @JsonIgnore
    private Long id;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String surname;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String name;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String patronymic;
    private String email;
    private RoleDto role;


    @JsonProperty(value = "fullName", access = JsonProperty.Access.READ_ONLY)
    public String getFullName() {
        return (surname + " " + name + " " + patronymic );
    }


}
