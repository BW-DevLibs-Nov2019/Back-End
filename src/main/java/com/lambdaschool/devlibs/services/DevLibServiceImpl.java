package com.lambdaschool.devlibs.services;


import com.lambdaschool.devlibs.exceptions.ResourceNotFoundException;
import com.lambdaschool.devlibs.logging.Loggable;
import com.lambdaschool.devlibs.models.DevLib;
import com.lambdaschool.devlibs.repository.DevLibRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Loggable
@Transactional
@Service(value = "devLibService")
public class DevLibServiceImpl implements DevLibService {

    @Autowired
    private DevLibRepository devLibRepository;


    @Override
    public List<DevLib> findDevLibsByUserName(String title) {
       return devLibRepository.findAllByUser_Username(title);
    }

    @Override
    public DevLib update(DevLib devLib, long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        DevLib updatedDevLib = devLibRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("DevLibs id "+ id + " not found"));

            if (devLibRepository.findById(id).get().getUser().getUsername().equalsIgnoreCase(authentication.getName())){

                if(devLib.getDevlibtitle()!=null){
                    updatedDevLib.setDevlibtitle(devLib.getDevlibtitle());
                }

                if(devLib.getParagraph()!=null){
                    updatedDevLib.setParagraph(devLib.getParagraph());
                }

                return devLibRepository.save(updatedDevLib);

            } else {
            throw new ResourceNotFoundException("Dev-Lib does not belong to current user");
        }


    }

    @Override
    public DevLib save(DevLib devLib) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (devLib.getUser().getUsername().equalsIgnoreCase(authentication.getName())){
            return devLibRepository.save(devLib);
        }else {
            throw new ResourceNotFoundException((authentication.getName() + "User is not authorized to save"));
        }
    }

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

             if (devLibRepository.findById(id).get().getUser().getUsername().equalsIgnoreCase(authentication.getName())){
                 devLibRepository.deleteById(id);
             }else{
                 throw new ResourceNotFoundException("Delete failed only the user who created this Dev-Lib can delete this");
             }
        }else {
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
