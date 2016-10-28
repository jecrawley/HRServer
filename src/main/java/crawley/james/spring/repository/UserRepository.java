package crawley.james.spring.repository;

import java.util.List;
import crawley.james.spring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

//@Transactional
@RepositoryRestResource(collectionResourceRel = "users", path = "hrdatabase")
public interface UserRepository extends JpaRepository<User, Long> {

//    List<JournalEntry> findByCreatedAfter(@Param("after") @DateTimeFormat(iso = ISO.DATE) Date date);
//    List<JournalEntry> findByCreatedBetween(@Param("after") @DateTimeFormat(iso = ISO.DATE) Date after,@Param("before") @DateTimeFormat(iso = ISO.DATE) Date before);
//    List<JournalEntry> findBySummaryContaining(@Param("word") String word);

    //@CrossOrigin
    List<User> findById(@Param("id") Long id);
    List<User> findByUsername(@Param("username") String username);

}
