package com.lambdaschool.devlibs.repository;

import com.lambdaschool.devlibs.models.DevLib;
import com.lambdaschool.devlibs.models.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DevLibRepository extends CrudRepository<DevLib, Long> {


   List<DevLib> findAllByUser_Username(String username);
}
