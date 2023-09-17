Design a Chess game 

1. There is a board
2. Mutiple positions on the board, can have a peice or not 
better to represent as a SPOT entity, and have a matrix in board class for easier access
3. player can make move (move is a class to track history , source and destination, peice killed, peice moved, player)
4. peice itlsef is a entity exposing canMove emthod 
5. gameLopp can have board, currentPlayer, list of layers, list of moves
6. in a turn player can specify source and target position 
7. check if player is correct, if peice can move, and if target peice is of opposite color
8. if yes kill other peice, update current peice location
9. add move to list 
10. finally update the latest player to play 


