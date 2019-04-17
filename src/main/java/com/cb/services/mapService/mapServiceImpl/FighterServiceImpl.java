package com.cb.services.mapService.mapServiceImpl;

import com.cb.bl.FighterBL;
import com.cb.dal.FighterDAL;
import com.cb.dto.DefaultDTO;
import com.cb.services.dbService.iDbService.FighterDBService;
import com.cb.services.mapService.iMapService.CharacterService;
import com.cb.services.mapService.iMapService.FighterService;
import com.cb.services.mapService.iMapService.PartyService;
import com.cb.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FighterServiceImpl implements FighterService {

    @Autowired
    FighterDBService fighterDBService;

    @Autowired
    CharacterService characterService;

    @Autowired
    PartyService partyService;

    @Autowired
    DefaultDTO defaultDTO;

    public DefaultDTO insertFighter(FighterBL fighterBL) {

        fighterBL.setMoney(1000);
        fighterBL.setRating(1000);

        if (fighterDBService.insertFighter(fighterBL) == 1) {

            defaultDTO.setSuccess(true);

        } else {
            defaultDTO.setSuccess(false);
            defaultDTO.setMessage("General error: can't insert fighter");
        }

        return defaultDTO;

    }

    public int getFighterCountByUserId(int userId) {

        return fighterDBService.getFighterCountByUserId(userId);

    }

    public DefaultDTO getFighterByUserId(int userId) {

        try {
            FighterDAL fighterDAL = fighterDBService.getFighterByUserId(userId);
            FighterBL fighterBL = ObjectMapperUtils.map(fighterDAL, FighterBL.class);
            String characterName = characterService.getCharacterName(fighterDAL.getCharacterId());
            String partyName = partyService.getPartyName(fighterDAL.getPartyId());
            String imageReference = characterService.getImageReference(fighterDAL.getCharacterId());
            fighterBL.setMember(characterName);
            fighterBL.setParty(partyName);
            fighterBL.setImage(imageReference);
            defaultDTO.setSuccess(true);
            defaultDTO.setData(fighterBL);
        } catch (Exception e) {
            defaultDTO.setSuccess(false);
            defaultDTO.setMessage("General error: " + e.getMessage());
        }
        return defaultDTO;
    }

}

