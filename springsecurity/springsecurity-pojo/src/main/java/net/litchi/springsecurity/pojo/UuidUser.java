package net.litchi.springsecurity.pojo;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "`uuid_user`")
public class UuidUser implements Serializable {
    @Id
    @Column(name = "`id`")
    private String id;

    @Column(name = "`mark`")
    private String mark;

    private static final long serialVersionUID = 1L;
}