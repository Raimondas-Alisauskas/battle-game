package com.cb.services.service.viewService;

import com.cb.dal.CharacterDAL;
import com.cb.services.DBService.IDBService.CharacterDBService;
import com.cb.services.service.IService.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CharacterServiceImpl implements CharacterService {

    @Autowired
    CharacterDBService characterDBService;

    @Override
    public List<CharacterDAL> getCharacters() {

        return characterDBService.getCharacters();

    }
}
