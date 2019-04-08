package com.cb.services.dbService.iDbService;

import com.cb.dal.CharacterDAL;

import java.util.List;

public interface CharacterDBService {

    List<CharacterDAL> getCharacters();

}
