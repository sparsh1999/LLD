models

User 
Order 
orderStatus 
trades (match between two order)

OrderController 
orderService 
place order 
modify order 
cancel order 

TradeService (Background Job)
// orderService (contains a map<symbol, map<direction,Orders>>)
// gets alive in 1s , tries to compare 
// run multiple instances of tradeService , lock on symbol 
// any operation on orderService , should wait for symbol lock
// for each order in buy side , do i have any order in sell side with equal quantity

//order should be placed and kept in a list 
// a thread can then update this in the main order list
// it should be confirmed and then put to main map