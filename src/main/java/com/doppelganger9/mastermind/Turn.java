
package com.doppelganger9.mastermind;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Turn {
    public static final Integer MAX_NB_TURNS = 10;

    private @Getter @Setter String userInput;
    private @Getter @Setter Integer nbCorrect;
    private @Getter @Setter Integer nbMisplaced;
    private @Getter @Setter Integer turn;

    public String toBoardLineOutput() {
      String cturn = this.turn>=9 ? "" + (this.turn+1) : " " + (this.turn+1);
		  return "|" + this.userInput + "| " + this.nbCorrect + " | " + this.nbMisplaced + " |" + cturn + "/" + MAX_NB_TURNS + " |\n";
	}
}
