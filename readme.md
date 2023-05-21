Algorithm decription:
	1. Object player 
	    PlayerName
	    Skills - offense(right); offence(left); receive; set; serve
	    taken - bool

	2. TeamList
	    5/6 Players
	    must contain: at least 2 x set; 3 x receive; 2x offence 
	3. Function of the app 
	    1. Create a dictionary with 15/18 ppl 
	    2. Make a function that takes a list of objects as an input and gives a set of 5/6 players that fulfill the conditions
		1. create a list of must have "Skills" on the team - 2 x set; 3 x receive; 2x offence
		2. create a smaller dictionary for 5/6 Players to save them in
		3. loop all the list vals 
		    1. check if player position is already covered by somebody in the internal list
		        1. loop the input dictionary on a random basis, ignoring the players that have a "taken"=True value randomly and if a Players "Skills" match the currently iterated "Skill" - add them to the internal list
		        2. break when there is enough people with skills covering the category (2 x set; 3 x receive; 2x offence)
		4. return the internal list
		
		
*compilation details will be added later*
