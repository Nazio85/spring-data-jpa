package pro.xway.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.xway.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
