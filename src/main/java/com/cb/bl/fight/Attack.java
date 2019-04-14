package com.cb.bl.fight;

import com.cb.constants.AttackType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attack {
    private int targetId;
    private Weapon weapon;
    private AttackType attackType;
    private Boolean isWinned;
}

