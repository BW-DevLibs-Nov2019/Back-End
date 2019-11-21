package com.lambdaschool.devlibs.services;

import com.lambdaschool.devlibs.models.DevLib;
import com.lambdaschool.devlibs.models.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public interface DevLibService  {


   List<DevLib> findDevLibsByUserName(String username);
   DevLib update(DevLib devLib, long id);

   DevLib save(DevLib devLib, User user);

   List<DevLib>listAllDevLibs();

   void deleteDevLibById(Long id);




   // DevLib save(DevLib devLib);

   // DevLib update(String title, DevLib devLib);

}
