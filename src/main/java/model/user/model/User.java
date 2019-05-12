package model.user.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(name = "User.findUserByLogin",
                query = "SELECT u FROM User u WHERE u.login=:login")
}
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Size(max = 45, message = "Название слишком длинное")
    @NotNull(message = "Логин не может быть пустым")
    @Column(name = "login")
    private String login;

    @Size(max = 45, message = "Пароль слишком длинный")
    @NotNull
    @Column(name = "password")
    private String password;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotNull
    public String getLogin() {
        return login;
    }

    public void setLogin(@NotNull String login) {
        this.login = login;
    }

    @NotNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }
}
