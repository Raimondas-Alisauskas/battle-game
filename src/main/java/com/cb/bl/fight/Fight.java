package com.cb.bl.fight;

import com.cb.bl.FighterArenaBL;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fight {
    private int fightId;
    private FighterArenaBL fighter1;
    private FighterArenaBL fighter2;
    private List<FightAction> fighter1ActionList;
    private List<FightAction> fighter2ActionList;
    private int actionsCompleted;

}
