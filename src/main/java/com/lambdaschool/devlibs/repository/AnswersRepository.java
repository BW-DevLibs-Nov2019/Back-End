package com.lambdaschool.devlibs.repository;

import com.lambdaschool.devlibs.models.Answers;
import com.lambdaschool.devlibs.models.DevLibAnswers;
import com.lambdaschool.devlibs.view.JustTheCount;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AnswersRepository extends CrudRepository<Answers, Long> {

    @Query(value = "SELECT COUNT(*) as count FROM devlibanswers WHERE devlibid = :devlibid AND answerid = :answerid",
            nativeQuery = true)
    JustTheCount checkDevLibAnswersCombo(long devlibid,
                                     long answerid);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM devlibanswers WHERE devlibid = :devlibid AND answerid = :answerid", nativeQuery = true)
    void deleteDevLibAnswers(long devlibid,
                         long answerid);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO devlibanswers(devlibid, answerid) VALUES (:devlibid, :answerid)", nativeQuery = true)
    void insertDevLibAnswers(long devlibid,
                             long answerid);


    @Transactional
    @Modifying
    // user Answers instead of answers in order to use Hibernate SQL
    @Query(value = "UPDATE answers SET name = :name, last_modified_by = :answer, last_modified_date = CURRENT_TIMESTAMP WHERE answerid = :answerid",
            nativeQuery = true)
    void updateAnswers(String answer,
                        long answerid,
                        String name);

    @Transactional
    @Modifying
    @Query(value = "SELECT answerid FROM devlibanswers WHERE devlibid = :devlibid", nativeQuery = true)
    List<Long> findAnswersByDevLibId(long devlibid);
}
