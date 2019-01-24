package model;

import java.util.HashMap;

/**
 * Class that defines a state of the machine;
 * you can set it's entry String and any exits.
 * The state defaults to null as it's default exit but you can define it with
 * setDefultSet()
 * @see setDefaultState()
 * @author Emilio.Scarpellino
 *
 */
public class State {
	private HashMap<String , State> exits ;
	private String id ;
	private State defaultState ;

	//Getters
	public HashMap<String , State> getExits() {
		return exits;
	}
	public String getId() {
		return id ;
	}
	public State getDefaultState() {
		return defaultState ;
	}

	//Setters
	public void setExits( HashMap<String , State> exits ) {
		this.exits = exits;
	}
	public void setId( String id ) {
		this.id = id ;
	}
	public void setDefaultState( State defaultState ) {
		this.defaultState = defaultState ;
	}
	
	//Constructors
	public State( String id ) {
		this.id = id ;
		exits = new HashMap<>() ;
		defaultState = null ;
	}
	
	//Methods
	/**
	 * Use this to set or update a new State to the exit conditions of this
	 * State
	 * @param input : the String that defines the exit condition
	 * @param state : the State binded to the exit condition
	 */
	public void setExit( String input , State state ) {
		if( !exits.containsKey( input ) ) {
			exits.put( input , state ) ;
		}
	}
	
	/**
	 * Use this to remove a State binded to the selected String
	 * @param input : the String that defines the state to remove
	 */
	public void removeExit( String input ) {
		if( exits.containsKey( input ) ) {
			exits.remove( input ) ;
		}
	}
	
	/**
	 * Returns a State binded to the selected String
	 * @param input : the String that a particular state is binded to
	 * @return : the State binded to the selected String
	 */
	public State getExit( String input ) {
		if( exits.containsKey( input ) ) {
			return exits.get( input ) ;
		}
		return defaultState ;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( exits == null ) ? 0 : exits.hashCode() );
		result = prime * result + ( ( id == null ) ? 0 : id.hashCode() );
		return result;
	}
	
	@Override
	public boolean equals( Object obj ) {
		if( this == obj ) return true;
		if( obj == null ) return false;
		if( getClass() != obj.getClass() ) return false;
		State other = ( State )obj;
		if( exits == null ) {
			if( other.exits != null ) return false;
		}
		else if( ! exits.equals( other.exits ) ) return false;
		if( id == null ) {
			if( other.id != null ) return false;
		}
		else if( ! id.equals( other.id ) ) return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append( "State [exits=" );
		builder.append( exits.keySet() );
		builder.append( ", id=" );
		builder.append( id );
		builder.append( "]" );
		return builder.toString();
	}
}
