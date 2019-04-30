package com.cb.services.dbService.dbServiceImpl;

import com.cb.bl.FighterBL;
import com.cb.dal.WeaponsDAL;
import com.cb.services.dbService.iDbService.ShopDBService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ShopDBServiceImpl implements ShopDBService {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) { this.template = template;
    }
    @Override
    public List<WeaponsDAL> getWeapons(int userId) {
        return template.query("SELECT * FROM weapons where Id not in (SELECT weaponId FROM fighter_weapons where fighterId in (" + userId+ "))", new BeanPropertyRowMapper<>(WeaponsDAL.class));
    }

    public void updateFighterMoneyById(int id, int money) {
        String sql =  "UPDATE fighters SET money =" +money+" WHERE  userId ="+ id;
        template.update(sql);
    }

    public void printBoughtItemsToConsole(String[] strings, int userId) {
        for(String a: strings) {
            if(a !=null) {
                System.out.println(userId + ": "+a);
                template.update("INSERT INTO fighter_weapons (fighterId, weaponId)" +
                        " VALUES (" + userId+ ", " + a + ")");
            }
        }
    }

}
