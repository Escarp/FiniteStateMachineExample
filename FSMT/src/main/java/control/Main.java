package control;

import model.Machine;
import model.State;

public class Main {
	public static void main( String[] args ) {
		State A = new State( "A" ) ;
		State B = new State( "B" ) ;
		State C = new State( "C" ) ;
		
		A.setExit( "A" , A ) ;
		A.setExit( "B" , B ) ;
		
		B.setExit( "C" , C ) ;
		B.setExit( "A" , A ) ;
		
		C.setExit( "A" , A ) ;
		
		Machine machine = new Machine( A , C , A , B , C ) ;
		
		String input = "C-B-A-A-B-C-A-B-A-C-A-B-C-D-F-A-B-S-A-C-B" ;
		
		for( String in : input.split( "-" ) ) {
			String out = machine.advance( in ) ;
			
			System.out.print( "in : " + in ) ;
			System.out.println( " , out : " + out ) ;
			
			if( machine.getFound() ) {
				System.out.println( "Sequence found!" ) ;
			}
		}
	}
}
