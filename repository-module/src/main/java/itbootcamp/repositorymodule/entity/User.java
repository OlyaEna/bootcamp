package itbootcamp.repositorymodule.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40)
    private String surname;

    @Column(length = 20)
    private String name;

    @Column(length = 40)
    private String patronymic;

    @Column(length = 50)
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}



