package com.cb.services.DBService.IDBService;

import com.cb.dal.CharacterDAL;

import java.util.List;

public interface CharacterDBService {

    List<CharacterDAL> getCharacters();

}
