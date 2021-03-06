package com.cb.bl;

import com.cb.bl.fight.Weapon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FighterArenaBL implements Serializable {
    private int id;
    private int rate;
    private int moneyLeft;
    private int honorLeft;
    private List<Weapon> weaponList;

}
