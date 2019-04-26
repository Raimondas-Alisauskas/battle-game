package com.cb.bl.fight;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FightActionsResult {
    private FighterAction fighter1Action;
    private FighterAction fighter2Action;
}
