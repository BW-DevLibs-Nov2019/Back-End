package com.lambdaschool.devlibs.services;

import com.lambdaschool.devlibs.exceptions.ResourceFoundException;
import com.lambdaschool.devlibs.exceptions.ResourceNotFoundException;
import com.lambdaschool.devlibs.logging.Loggable;
import com.lambdaschool.devlibs.models.Answers;
import com.lambdaschool.devlibs.repository.AnswersRepository;
import com.lambdaschool.devlibs.repository.DevLibRepository;
import com.lambdaschool.devlibs.repository.AnswersRepository;
import com.lambdaschool.devlibs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Loggable
@Transactional
@Service(value = "answersService")

public class AnswersServiceImpl implements AnswerService {


    @Autowired
    AnswersRepository answerrepo;

    @Autowired
    DevLibRepository devlibsrepos;

    @Autowired
    UserAuditing userAuditing;


    @Override
    public List<Answers> findAll() {
        List<Answers> list = new ArrayList<>();
        answerrepo.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }


    @Override
    public Answers findAnswersById(long id) {
        return answerrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Answers id " + id + " not found!"));
    }

    @Override
    public List<String> findAnswersByDevLibId(long id) {

        List<Long> answerIds = answerrepo.findAnswersByDevLibId(id);
        List<String> answers = new ArrayList<>(answerIds.size());

        for (int i = 0; i < answerIds.size(); i++) {
            answers.add(findAnswersById(answerIds.get(i)).getAnswer());
        }

        return answers;

    }

    @Override
    public void insertDevLibAnswers(long devlibid, long answerid) {
        answerrepo.insertDevLibAnswers(devlibid, answerid);
    }


    @Transactional
    @Override
    public void delete(long id) {
        answerrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Answers id " + id + " not found!"));
        answerrepo.deleteById(id);
    }


    @Transactional
    @Override
    public Answers update(long id,
                          Answers answers) {

        if (answers.getDevLibAnswers()
                .size() > 0) {
            throw new ResourceFoundException("User Answers are not updated through Answers. See endpoint POST: users/user/{userid}/answers/{roleid}");
        }

        Answers newAnswers = findAnswersById(id); // see if id exists

        answerrepo.updateAnswers(userAuditing.getCurrentAuditor()
                        .get(),
                id,
                answers.getAnswer());
        return findAnswersById(id);
    }


    @Transactional
    @Override
    public Answers save(Answers answers) {
        Answers newAnswers = new Answers();
        newAnswers.setAnswer(answers.getAnswer());
        if (answers.getDevLibAnswers()
                .size() > 0) {
            throw new ResourceFoundException("User Answerss are not updated through Answers. See endpoint POST: users/user/{userid}/answers/{roleid}");
        }

        return answerrepo.save(answers);
    }
}


