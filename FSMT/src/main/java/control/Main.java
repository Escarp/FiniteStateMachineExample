package control;

import model.Machine;
import model.State;

public class Main {
	public static void main( String[] args ) {
		//Initialize some States first
		State A = new State( "A" ) ;
		State B = new State( "B" ) ;
		State C = new State( "C" ) ;
		
		//Set their exits (and defaults)
		A.setExit( "A" , A ) ;
		A.setExit( "B" , B ) ;
		
		B.setExit( "C" , C ) ;
		B.setExit( "A" , A ) ;
		
		C.setExit( "A" , A ) ;
		
		//Create the Machine specifying a start and an end
		Machine machine = new Machine( A , C ) ;
		
		//Get some string (or any input that the Machine can handle)
		//(possibly already divided)
		String input = "C-B-A-A-B-C-A-B-A-C-A-B-C-D-F-A-B-S-A-C-B" ;
		
		for( String in : input.split( "-" ) ) {
			//Advance the machine
			String out = machine.advance( in ) ;
			
			System.out.print( "in : " + in ) ;
			System.out.println( " , out : " + out ) ;
			
			//Check if the machine has found a sequence
			if( machine.getFound() ) {
				System.out.println( "Sequence found!" ) ;
			}
		}
	}
}
