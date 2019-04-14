package com.cb.bl.fight;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FightActionsResult {
    private FightAction fighter1Action;
    private FightAction fighter2Action;
}
