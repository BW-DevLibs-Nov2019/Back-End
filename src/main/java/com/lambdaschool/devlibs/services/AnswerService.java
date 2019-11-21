package com.lambdaschool.devlibs.services;

import com.lambdaschool.devlibs.models.Answers;
import com.lambdaschool.devlibs.models.Role;

import java.util.List;

public interface AnswerService {

    List<Answers> findAll();

    Answers findAnswersById(long id);

    List<String> findAnswersByDevLibId(long id);

    void insertDevLibAnswers(long devlibid, long answerid);

    void delete(long id);

    Answers save(Answers answers);

    Answers update(long id,
                Answers answers);
}
