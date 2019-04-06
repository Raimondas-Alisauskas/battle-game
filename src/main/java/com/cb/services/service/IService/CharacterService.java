package com.cb.services.service.IService;

import com.cb.dal.CharacterDAL;

import java.util.List;

public interface CharacterService {

    List<CharacterDAL> getCharacters();

}
