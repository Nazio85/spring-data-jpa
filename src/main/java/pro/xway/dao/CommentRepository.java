package pro.xway.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.xway.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
