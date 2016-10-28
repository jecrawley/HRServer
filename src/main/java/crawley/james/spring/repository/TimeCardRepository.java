package crawley.james.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import crawley.james.spring.domain.TimeCard;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RepositoryRestResource(collectionResourceRel = "timecards", path = "hrtimecards")
public interface TimeCardRepository extends JpaRepository<TimeCard, Long> {

    List<TimeCard> findByUsername(@Param("username") String username);

}
