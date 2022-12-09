package com.example.springjpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "signup")
@Data
public class SignUp implements Serializable {

    //方法１
    // @Dataを使わない
    // toStringメソッドをオーバーライドしないこと

    //方法２
    // @Dataを使う
    // toStringメソッドをオーバーライドしないこと
    // Joinする側(子要素)に、ToString.Excludeを追加する
    // @JsonIgnoreを追加する

    // 参考
    // https://blogenist.jp/2020/12/17/11185/#ToStringExclude
    // https://stackoverflow.com/questions/67526700/com-fasterxml-jackson-databind-ser-std-collectionserializer-serializecollection


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "file_name")
    private String fileName;

    @OneToMany(mappedBy = "signup", cascade = CascadeType.ALL)
    @ToString.Exclude // @Dataを利用した場合、ハッシュコードエラーを回避するために必要
    @JsonIgnore // jackson.databindのエラーを回避するために必要
    private List<Chats> chats;

}
