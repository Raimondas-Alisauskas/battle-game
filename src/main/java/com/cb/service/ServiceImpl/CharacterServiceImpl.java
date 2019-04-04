package com.cb.service.ServiceImpl;

import com.cb.beans.CharacterBean;
import com.cb.dao.IDao.CharacterDao;
import com.cb.service.IService.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CharacterServiceImpl implements CharacterService {

    @Autowired
    CharacterDao characterDao;

    @Override
    public List<CharacterBean> getCharacters() {

        return characterDao.getCharacters();

    }
}
