package com.cb.services.dbService.iDbService;

import com.cb.bl.FighterBL;
import com.cb.dal.CharacterDAL;

import java.sql.Blob;
import java.util.List;

public interface CharacterDBService {

    List<CharacterDAL> getCharacters();

    int getCharacterId(FighterBL fighterBL);

    String getCharacterName(int charId);

    String getImageReference(int charId);

}
