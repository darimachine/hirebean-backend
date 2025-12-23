package bg.uni.sofia.fmi.spring.hirebean.repository;

import bg.uni.sofia.fmi.spring.hirebean.model.entity.User;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends SoftDeleteRepository<User, Long> {

  Optional<User> findByEmailAndDeletedAtIsNull(String email);

  Boolean existsByEmailAndDeletedAtIsNull(String email);
}
