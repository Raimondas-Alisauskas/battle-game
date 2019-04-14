package com.cb.bl.fight;

import com.cb.bl.FighterBL;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fight {
    private int fightId;
    private FighterBL fighter1;
    private FighterBL fighter2;
    private List<FightAction> fighter1ActionList;
    private List<FightAction> fighter2ActionList;
    private int actionsCompleted;

}
