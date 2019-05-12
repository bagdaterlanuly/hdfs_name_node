package model.block.model;

import model.file.model.File;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "block")
public class Block {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Size(max = 45, message = "Название слишком длинное")
    @NotNull(message = "Название не может быть пустым")
    @Column(name = "name")
    private String name;

    @Size(max = 45, message = "Рвзмер слишком длинный")
    @NotNull(message = "Размер  не может быть пустым")
    @Column(name = "size")
    private String size;

    @Size(max = 45, message = "Название слишком длинное")
    @NotNull(message = "Название не может быть пустым")
    @Column(name = "address")
    private String address;


    @ManyToOne
    @JoinColumn(name = "file_id", insertable = false, updatable = false)
    private File file;


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
    public String getAddress() {
        return address;
    }

    public void setAddress(@NotNull String address) {
        this.address = address;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
