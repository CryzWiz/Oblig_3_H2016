# Oblig_3_H2016
This is the psudo code I started out with

Psudo code
DFS(source):
stack <- new Deque
	visited <- {} // empty 
	setstack.push(source)

	while (stack is not empty):
		current <- s.pop()
		
		if (current is not visited):
			set visited to true and add current to search order
			get currents neighbors (e.v)
			
			for every neighbor:
				if(e.v is not visited)
					Set parents to e.v to current
				
			stack.push(v)

