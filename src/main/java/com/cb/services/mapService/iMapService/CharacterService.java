package com.cb.services.mapService.iMapService;

import com.cb.bl.FighterBL;
import com.cb.dal.CharacterDAL;

import java.util.List;

public interface CharacterService {

    List<CharacterDAL> getCharacters();

    int getCharacterId(FighterBL fighterBL);

    String getCharacterName(int charId);

    String getImageReference(int charId);

}
