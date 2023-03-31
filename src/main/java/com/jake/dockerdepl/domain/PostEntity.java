package com.jake.dockerdepl.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Table(name = "\"post\"")
@Entity
public class PostEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Setter private String title;
    @Setter private String body;

    public static PostEntity of(String title, String body) {
        PostEntity entity = new PostEntity();
        entity.setTitle(title);
        entity.setBody(body);
        return entity;
    }
}
