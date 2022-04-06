package net.litchi.springsecurity.pojo;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "`account`")
public class Account implements Serializable {
    @Id
    @Column(name = "`id`")
    private Integer id;

    @Column(name = "`username`")
    private String username;

    @Column(name = "`money`")
    private Double money;

    private static final long serialVersionUID = 1L;
}