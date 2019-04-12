package com.cb.services.mapService.mapServiceImpl;

import com.cb.dal.CharacterDAL;
import com.cb.services.dbService.iDbService.CharacterDBService;
import com.cb.services.mapService.iMapService.CharacterService;
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
