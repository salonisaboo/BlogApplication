package com.example.BlogApp.models;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Authority {

    @Id
    private Long id;

    private String name;

    @Override
    public String toString() {
        return "Authority [id=" + id + ", name=" + name + "]";
    }


}
