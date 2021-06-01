package io2.puertolego.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io2.puertolego.models.Comment;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer> {
	@Query(value="select (case when exists (select id_client, authKey from dbo.Client where id_client = ?1 and authKey = ?2 )then 'true' else 'false' end) as authorized",nativeQuery=true)
	boolean requestAuthorization(int id_client,String authKey);
	
    @Query(value="SELECT [dbo].[Comment].[id_com], [dbo].[Comment].[rating], [dbo].[Comment].[description], [dbo].[Comment].[id_pro], [dbo].[Client].[username] FROM [dbo].[Comment] INNER JOIN [dbo].[Client] ON ([dbo].[Comment].[id_client] = [dbo].[Client].[id_client]) WHERE id_pro=?1",nativeQuery=true)
    List<Comment> getCommentsProductById(int id_pro);
    
    @Transactional
	@Modifying
    @Query(value="insert into dbo.comment (id_pro,id_client,description,rating) values (?1,?2,?3,?4)",nativeQuery=true)
    void addComment(int id_pro, int id_client, String description, int rating);
}