package com.cb.services.tableService.iTableService;

import com.cb.dal.CharacterDAL;

import java.util.List;

public interface CharacterService {

    List<CharacterDAL> getCharacters();

}
