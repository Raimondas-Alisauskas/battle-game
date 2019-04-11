package com.cb.services.mapService.iMapService;

import com.cb.dal.CharacterDAL;

import java.sql.Blob;
import java.util.List;

public interface CharacterService {

    List<CharacterDAL> getCharacters();


}
