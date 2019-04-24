package com.cb.bl.fight;

import com.cb.constants.AttackType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attack implements Serializable {
    private int targetId;
    private Weapon weapon;
    private AttackType attackType;
    private Boolean isWinned;
}

