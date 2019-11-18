package com.lambdaschool.devlibs.repository;

import com.lambdaschool.devlibs.models.DevLib;
import com.lambdaschool.devlibs.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface DevLibRepository extends CrudRepository<DevLib, Long> {
}
