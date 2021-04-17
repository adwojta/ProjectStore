package io2.puertolego.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import io2.puertolego.models.Comment;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer> {
    @Query(value="SELECT [dbo].[Comment].[id_com], [dbo].[Comment].[rating], [dbo].[Comment].[description], [dbo].[Comment].[id_pro], [dbo].[Client].[username]\n" +
            "FROM [dbo].[Comment] INNER JOIN [dbo].[Client] ON ([dbo].[Comment].[id_client] = [dbo].[Client].[id_client]) WHERE id_pro=?1",nativeQuery=true)
    List<Comment> getProductById(int id_pro);

}