
package com.doppelganger9.mastermind;

import lombok.Builder;

@Builder(toBuilder = true)
record Turn(String userInput, int nbCorrect, int nbMisplaced, int turn) {
    static final Integer MAX_NB_TURNS = 10;

    String toBoardLineOutput() {
      String cturn = this.turn>=9 ? "" + (this.turn+1) : " " + (this.turn+1);
		  return "|" + this.userInput + "| " + this.nbCorrect + " | " + this.nbMisplaced + " |" + cturn + "/" + MAX_NB_TURNS + " |\n";
	}
}
