package com.lambdaschool.devlibs.services;


import com.lambdaschool.devlibs.logging.Loggable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Loggable
@Transactional
@Service(value = "devLibService")
public class DevLibServiceImpl implements DevLibService {


}
