package com.cb.bl.fight;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FighterAction implements Serializable {
//    private int fighterActionNo;
    private List<Attack> attackList;
    private int noOfWinnings;
}
