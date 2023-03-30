package com.jake.dockerdepl.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PostEntity {
    @Id
    @GeneratedValue
    private Long id;
}
