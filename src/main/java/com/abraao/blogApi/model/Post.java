package com.abraao.blogApi.model;

import com.abraao.blogApi.dto.PostDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="Post")
@Table(name="Post")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Post {

    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id",nullable = false)
    private User user;
}
