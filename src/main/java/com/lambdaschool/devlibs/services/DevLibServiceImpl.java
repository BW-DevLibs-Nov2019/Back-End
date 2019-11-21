package com.lambdaschool.devlibs.services;


import com.lambdaschool.devlibs.exceptions.ResourceNotFoundException;
import com.lambdaschool.devlibs.logging.Loggable;
import com.lambdaschool.devlibs.models.Answers;
import com.lambdaschool.devlibs.models.DevLib;
import com.lambdaschool.devlibs.models.User;
import com.lambdaschool.devlibs.repository.AnswersRepository;
import com.lambdaschool.devlibs.repository.DevLibRepository;
import com.lambdaschool.devlibs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Loggable
@Transactional
@Service(value = "devLibService")
public class DevLibServiceImpl implements DevLibService {

    @Autowired
    private DevLibRepository devLibRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AnswersRepository answersRepository;


    @Override
    public List<DevLib> findDevLibsByUserName(String title) {
        return devLibRepository.findAllByUser_Username(title);
    }

    @Override
    public DevLib update(DevLib devLib, long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();


        DevLib updatedDevLib = devLibRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("DevLibs id " + id + " not found"));

        if (devLibRepository.findById(id).get().getUser().getUsername().equalsIgnoreCase(authentication.getName())) {

            if (devLib.getDevlibtitle() != null) {
                updatedDevLib.setDevlibtitle(devLib.getDevlibtitle());
            }

            if (devLib.getStory() != null) {
                updatedDevLib.setStory(devLib.getStory());
            }

            if (devLib.getParagraph() != null) {
                updatedDevLib.setParagraph(devLib.getParagraph());
            }

            return devLibRepository.save(updatedDevLib);

        } else {
            throw new ResourceNotFoundException("Dev-Lib does not belong to current user");
        }


    }

    @Override
    public DevLib save(@NotNull DevLib devLib, User user) {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();

        User authenticatedUser = userRepository.findByUsername(authentication.getName());

        DevLib newDevLib = new DevLib();
        authenticatedUser.getDevlibs().add(newDevLib);
        newDevLib.setUser(authenticatedUser);

        newDevLib.setDevlibtitle(devLib.getDevlibtitle());
        newDevLib.setParagraph(devLib.getParagraph());
        newDevLib.setStory(devLib.getStory());


        //authenticatedUser = userRepository.save(authenticatedUser);

        newDevLib = devLibRepository.save(newDevLib);
        for (int i = 0; i < devLib.getAnswerstrings().size(); i++) {
            Answers answers = answersRepository.save(new Answers(devLib.getAnswerstrings().get(i)));
            answersRepository.insertDevLibAnswers(newDevLib.getDevlibid(), answers.getAnswerid());
        }

        return devLibRepository.findById(newDevLib.getDevlibid()).orElseThrow();
    }
   /* @Override
    public DevLib save(DevLib devLib) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (devLib.getUser().getUsername().equalsIgnoreCase(authentication.getName())){
            return devLibRepository.save(devLib);
        }else {
            throw new ResourceNotFoundException((authentication.getName() + "User is not authorized to save"));
        }
    }*/

    @Override
    public List<DevLib> listAllDevLibs() {
        List<DevLib> devLibs = new ArrayList<>();
        devLibRepository.findAll().iterator().forEachRemaining(devLibs::add);
        return devLibs;
    }

    @Override
    public void deleteDevLibById(Long id) {
        if (devLibRepository.findById(id).isPresent()) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if (devLibRepository.findById(id).get().getUser().getUsername().equalsIgnoreCase(authentication.getName())) {
                devLibRepository.deleteById(id);
            } else {
                throw new ResourceNotFoundException("Delete failed only the user who created this Dev-Lib can delete this");
            }
        } else {
            throw new ResourceNotFoundException("Dev-Lib id " + id + " not found");
        }
    }


  /*  @Override
    public DevLib save(DevLib devLib) {
        return null;
    }*/

   /* @Override
    public DevLib update(String name, DevLib devLib) {

    }*/
}
