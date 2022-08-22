package com.ibrahim.ticketservice.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @CreatedDate
    @Column(name = "crated")
    private Date created;

    @Column(name = "updated")
    private Date updated;

}
