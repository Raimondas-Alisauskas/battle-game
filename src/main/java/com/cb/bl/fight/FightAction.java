package com.cb.bl.fight;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FightAction {
    private int fightActionNo;
    private List<Attack> attackList;
    private int noOfWinnings;
}
