package model.File.model;


import model.User.model.User;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "file")
public class File {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Size(max = 45, message = "Название слишком длинное")
    @NotNull(message = "Название не может быть пустым")
    @Column(name = "name")
    private String name;

    @Size(max = 45, message = "Размер слишком длинный")
    @NotNull(message = "Размер не может быть пустым")
    @Column(name = "size")
    private String size;

    @NotNull
    @Column(name = "num_of_block")
    private Integer numOfBlock;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    @NotNull
    public String getSize() {
        return size;
    }

    public void setSize(@NotNull String size) {
        this.size = size;
    }

    @NotNull
    public Integer getNumOfBlock() {
        return numOfBlock;
    }

    public void setNumOfBlock(@NotNull Integer numOfBlock) {
        this.numOfBlock = numOfBlock;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
