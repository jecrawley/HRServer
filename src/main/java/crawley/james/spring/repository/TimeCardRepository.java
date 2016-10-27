package crawley.james.spring.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import crawley.james.spring.domain.TimeCard;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

@Transactional
@RepositoryRestResource(collectionResourceRel = "timecards", path = "hrdatabase")
@CrossOrigin(origins = "http://localhost:9000")
public interface TimeCardRepository extends JpaRepository<TimeCard, Long> {

//    List<JournalEntry> findByCreatedAfter(@Param("after") @DateTimeFormat(iso = ISO.DATE) Date date);
//    List<JournalEntry> findByCreatedBetween(@Param("after") @DateTimeFormat(iso = ISO.DATE) Date after,@Param("before") @DateTimeFormat(iso = ISO.DATE) Date before);
//    List<JournalEntry> findByTitleContaining(@Param("word") String word);
//    List<JournalEntry> findBySummaryContaining(@Param("word") String word);
}
