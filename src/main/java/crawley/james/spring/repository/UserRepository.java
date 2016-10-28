package crawley.james.spring.repository;

import java.util.List;
import crawley.james.spring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RepositoryRestResource(collectionResourceRel = "users", path = "hrusers")
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findById(@Param("id") Long id);
    List<User> findByUsername(@Param("username") String username);

}
