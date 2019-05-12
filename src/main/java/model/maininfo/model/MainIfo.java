package model.maininfo.model;

import model.file.model.File;
import model.user.model.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "main_info")
public class MainIfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "file_id", insertable = false, updatable = false)
    private File file;

    @NotNull
    @Column(name = "upload_date")
    private Date uploadDate;

    @NotNull
    @Column(name = "status")
    private Boolean status;

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }

    public File getFile() {
        return file;
    }


    public void setFile(File file) {
        this.file = file;
    }

    @NotNull
    public Date getUploadDate() {
        return uploadDate;
    }


    public void setUploadDate(@NotNull Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    @NotNull
    public Boolean getStatus() {
        return status;
    }


    public void setStatus(@NotNull Boolean status) {
        this.status = status;
    }
}
