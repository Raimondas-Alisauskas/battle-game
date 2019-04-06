package com.cb.services.service.ServiceImpl;

import com.cb.dal.CharacterDAL;
import com.cb.services.DBService.IDBService.CharacterDBService;
import com.cb.services.service.IService.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    CharacterDBService characterDBService;

    @Override
    public List<CharacterDAL> getCharacters() {

        return characterDBService.getCharacters();

    }
}
