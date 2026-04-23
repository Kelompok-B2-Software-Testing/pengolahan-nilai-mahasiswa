package utils;

import data.State;



// For defining program state 
public class StateMachine {
    
    private State StateNow = State.None;
    
    // state getter
	public State getStateNow() {
		return StateNow;
	}
	
	// state setter
	public void setStateNow(State stateNow) {
		StateNow = stateNow;
	}
}