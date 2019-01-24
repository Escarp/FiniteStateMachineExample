package model;

import java.util.ArrayList;

/**
 * This is the primary class that controls a collection of states.
 * It has a starting State that starts the sequence, a current State and an
 * ending state that will end the sequence.
 * Once the machine arrives at the end State it will set its found argument to
 * true to denote it recognized the sequence.
 * @author Emilio.Scarpellino
 *
 */
public class Machine {
	private ArrayList<State> states ;
	private State currentState ;
	private State endState ;
	private State startState ;
	private boolean found ;
	
	//Getters
	public ArrayList<State> getStates() {
		return states;
	}
	public State getCurrentState() {
		return currentState;
	}
	public State getEndState() {
		return endState;
	}
	public State getStartState() {
		return startState ;
	}
	public boolean getFound() {
		return found ;
	}

	//Setters
	public void setStates( ArrayList<State> states ) {
		this.states = states;
	}
	public void setCurrentState( State currentState ) {
		this.currentState = currentState;
	}
	public void setEndState( State endState ) {
		this.endState = endState;
	}
	public void setStartState( State startState ) {
		this.startState = startState ;
	}
	public void setFound( boolean found ) {
		this.found = found ;
	}

	//Constructors
	public Machine( State startState , State end ) {
		this.startState = startState ;
		this.states = new ArrayList<>() ;
		currentState = null ;
		endState = end ;
		found = false ;
	}
	
	public Machine( State startState , State end , State... states ) {
		this( startState , end ) ;
		if( states != null ) {
			for( State state : states ) {
				this.states.add( state ) ;
			}
		}
	}
	
	//Methods
	/**
	 * Advances the machine to the next State, depending on the input it takes
	 * @param input : the input that will change the the state of the machine
	 * @return : the current state of the machine
	 */
	public String advance( String input ) {
		found = false ;
		if( currentState == null ) {
			if( input.equals( startState.getId() ) ) {
				currentState = startState ;
				return currentState.getId() ;
			}
			return null ;
		}
		else {
			currentState = currentState.getExit( input ) ;
			if( endState.equals( currentState ) ) {
				found = true ;
			}
			
			if( currentState == null ) {
				return null ;
			}
			else {
				return currentState.getId() ;
			}
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ( ( currentState == null ) ? 0 : currentState.hashCode() );
		result = prime * result
				+ ( ( endState == null ) ? 0 : endState.hashCode() );
		result = prime * result
				+ ( ( states == null ) ? 0 : states.hashCode() );
		return result;
	}
	
	@Override
	public boolean equals( Object obj ) {
		if( this == obj ) return true;
		if( obj == null ) return false;
		if( getClass() != obj.getClass() ) return false;
		Machine other = ( Machine )obj;
		if( currentState == null ) {
			if( other.currentState != null ) return false;
		}
		else if( ! currentState.equals( other.currentState ) ) return false;
		if( endState == null ) {
			if( other.endState != null ) return false;
		}
		else if( ! endState.equals( other.endState ) ) return false;
		if( states == null ) {
			if( other.states != null ) return false;
		}
		else if( ! states.equals( other.states ) ) return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append( "Machine [states=" );
		builder.append( states );
		builder.append( ", currentState=" );
		builder.append( currentState );
		builder.append( ", endState=" );
		builder.append( endState );
		builder.append( "]" );
		return builder.toString();
	}
}
