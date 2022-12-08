package com.example.springjpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatsRepository extends JpaRepository<Chats, Integer> {

    // @Query(value = "select c.id, c.room_id, c.user_id, c.message, c.created_at,m.id,m.name,m.email,m.password,m.file_name "+
    // "from chats as c "+
    // "join signup as m "+
    // "on c.user_id = m.id "+
    // "where c.user_id = :id", nativeQuery = true)
    // List<Chats> take(@Param("id") Integer id);

    // @Query("SELECT DISTINCT e FROM Chats e INNER JOIN e.signup WHERE e.userId = :id")
    // List<Chats> take(@Param("id") Integer id);

    @Query("SELECT DISTINCT e FROM Chats e INNER JOIN e.signup WHERE e.userId = :id ")
    List<Chats> find(@Param("id") Integer id);
}
