package com.example.springjpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "chats")
@Data
public class Chats implements Serializable {

    //方法１
    // @Dataを使わない
    // toStringメソッドをオーバーライドしないこと

    //方法２
    // @Dataを使う
    // toStringメソッドをオーバーライドしないこと
    // Joinする側(子要素)に、ToString.Excludeを追加する

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String message;

    @Column(name = "room_id")
    private Integer roomId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "created_at")
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private SignUp signup;

}