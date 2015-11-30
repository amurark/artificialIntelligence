edge(bird, ako, creature).
edge(human, ako, creature).
edge(man, ako, human).
edge(turkey, ako, bird).
edge(albert, isa, man).
edge(louis, isa, man).
edge(frank, isa, turkey).

rel(SourceNode, RelationshipType, DestinationNode):-    edge(SourceNode, RelationshipType, DestinationNode).
rel(SourceNode, isa, DestinationNode):-
    		rel(SourceNode, isa, TempNode),
     rel(TempNode, ako, DestinationNode),!.
        
rel(SourceNode, RelationshipType, DestinationNode):-
    		edge(SourceNode, ako, TempNode),
rel(TempNode, RelationshipType, DestinationNode).

property(human, legs, two).
property(bird, fly, yes).
property(louis, legs, one).
property(turkey, fly, no).

feature(Node, Property, Value):- property(Node, Property, Value).
       
feature(Node, Property, Value):-
     (property(Node, Property, _) ->
      (property(Node, Property, Value) ->  
         true
      ;   false)
     ; rel(Node, RelationshipType, Node1),
      (property(Node1, Property, _) -> !, 
        (property(Node1, Property, Value) ->  
           true
       ;   false))).


