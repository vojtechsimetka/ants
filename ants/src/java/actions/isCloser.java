/**
 * BP, anthill strategy game
 * Determines if point with first two coordinates is closer to last two coordinates point then the second point
 *
 * @author  xsimet00 Vojtech Simetka
 * @date    2013/01/05
 * @version 1
 * @file    actions.getRandomDirection.java
 */
package actions;

import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.NumberTerm;
import jason.asSyntax.Term;

/**
 * Determines if point with first two coordinates is closer to last two coordinates point then the second point 
 * @author Vojtech Simetka
 *
 */
public class isCloser extends DefaultInternalAction
{
	@Override
	public Object execute(TransitionSystem ts, Unifier un, Term[] terms)
	{	
		int ax = (int)((NumberTerm) terms[0]).solve();
		int ay = (int)((NumberTerm) terms[1]).solve();
		int x = (int)((NumberTerm) terms[2]).solve();
		int y = (int)((NumberTerm) terms[3]).solve();
		int homeX = (int)((NumberTerm) terms[4]).solve();
		int homeY = (int)((NumberTerm) terms[5]).solve();
		
		int first_case = (homeX - ax) * (homeX - ax) + (homeY - ay) * (homeY - ay);
		int second_case = (homeX - x) * (homeX - x) + (homeY - y) * (homeY - y);
		
		if (first_case > second_case)
			return true;
		
		return false;
	}
}
