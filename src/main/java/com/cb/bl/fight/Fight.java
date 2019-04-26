package com.cb.bl.fight;

import com.cb.bl.FighterArenaBL;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fight implements Serializable {
    private int fightId;
    private FighterArenaBL fighter1;
    private FighterArenaBL fighter2;
    private List<FighterAction> fighter1ActionList;
    private List<FighterAction> fighter2ActionList;
    private int actionsCompleted;
    private int idHasNoHonorLeft;
}
