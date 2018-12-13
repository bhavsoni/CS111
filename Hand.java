package CS111;


/**
 * An object of type Hand represents a hand of cards.  The
 * cards belong to the class Card.  A hand is empty when it
 * is created, and any number of cards can be added to it.
 */

import java.util.ArrayList;

public class Hand {

   private Card[] hand;   // The cards in the hand.
   private int count; 
   
   /**
    * Create a hand that is initially empty.
    */
   public Hand() {
      hand = new Card[5];
	  count = 0;
   }
   
   /**
    * Remove all cards from the hand, leaving it empty.
    */
   public void clear() {
      for(int i=0 ; i<hand.length; i++){ hand[i] = null; }
	  count = 0;
   }
   
   /**
    * Add a card to the hand.  It is added at the end of the current hand.
    * @param c the non-null card to be added.
    * @throws NullPointerException if the parameter c is null.
    */
   public void addCard(Card c) {
      
	  for(int i=0 ; i<hand.length; i++){ 
		if (hand[i] == null){
			hand[i] = c;
			count = count + 1;
			break;
		}
	 }

	  
   }
   
   /**
    * Remove a card from the hand, if present.
    * @param c the card to be removed.  If c is null or if the card is not in 
    * the hand, then nothing is done.
    */
   public void removeCard(Card c) {

	for(int i=0 ; i<hand.length; i++){ 
		if (hand[i].equals(c)){
			hand[i] = null;
			count = count-1;
		}
	}

   }
   
   /**
    * Remove the card in a specified position from the hand.
    * @param position the position of the card that is to be removed, where
    * positions are starting from zero.
    * @throws IllegalArgumentException if the position does not exist in
    * the hand, that is if the position is less than 0 or greater than
    * or equal to the number of cards in the hand.
    */
   public void removeCard(int position) {
		if (position < 0 || position >= hand.length)
			throw new IllegalArgumentException("Position does not exist in hand: " + position);
		hand[position] = null;
		count--;
	}	


   /**
    * Returns the number of cards in the hand.
    */
   public int getCardCount() {
      return count;
   }
   
   /**
    * Gets the card in a specified position in the hand.  (Note that this card
    * is not removed from the hand!)
    * @param position the position of the card that is to be returned
    * @throws IllegalArgumentException if position does not exist in the hand
    */
   public Card getCard(int position) {
      if (position < 0 || position >= hand.length)
         throw new IllegalArgumentException("Position does not exist in hand: "
               + position);
       return hand[position];
   }
   
   /**
    * Sorts the cards in the hand so that cards of the same suit are
    * grouped together, and within a suit the cards are sorted by value.
    * Note that aces are considered to have the lowest value, 1.
    */
   public void sortBySuit() {
	  int size = count;
	  int nonnull = 0;
	  int index = 0;
	  
      Card[] newHand = new Card[5];
      while (size > 0) {
		 if (hand[nonnull] == null) { nonnull = nonnull+1; continue;}
         int pos = nonnull;  // Position of minimal card.
         Card c = hand[nonnull];  // Minimal card.
		 
         for (int i = nonnull+1; i < hand.length; i++) {
            Card c1 = hand[i];
			if (c1 != null){
				if ( c1.getSuit() < c.getSuit() ||
						(c1.getSuit() == c.getSuit() && c1.getValue() < c.getValue()) ) {
					pos = i;
					c = c1;
				}
			}
         }
         hand[pos] = null;
		 size = size - 1;
         newHand[index++] = c;
		 nonnull = 0;
      }
      hand = newHand;
   }
   
   /**
    * Sorts the cards in the hand so that cards of the same value are
    * grouped together.  Cards with the same value are sorted by suit.
    * Note that aces are considered to have the lowest value, 1.
    */
   public void sortByValue() {
	  int size = count;
	  int nonnull = 0;
	  int index = 0;
	  
      Card[] newHand = new Card[5];
      while (size > 0) {
		 if (hand[nonnull] == null) { nonnull = nonnull+1; continue;}
         int pos = nonnull;  // Position of minimal card.
         Card c = hand[nonnull];  // Minimal card.
		 
         for (int i = nonnull+1; i < hand.length; i++) {
            
			Card c1 = hand[i];
            if (c1 != null){
				if ( c1.getValue() < c.getValue() ||
						(c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit()) ) {
					pos = i;
					c = c1;
				}
			}
         }
         hand[pos] = null;
		 size = size - 1;
         newHand[index++] = c;
		 nonnull = 0;
      }
      hand = newHand;
   }
   
   public void printHand(){
	   
	   for(int i=0; i<hand.length; i++){
		   if (hand[i] != null){
			   System.out.println(hand[i]);
		   }
	   }
	   System.out.println();
   }
   

   /******************************** Implement your methods here ****************************************/
   
 //Returns the number of pairs this hand contains
   public int numPairs(){
	   int pair =0;
	   sortByValue();
		if( (hand[0].getValue()==hand[1].getValue() && hand[2].getValue()==hand[3].getValue())
				|| (hand[0].getValue()==hand[1].getValue() && hand[3].getValue()==hand[4].getValue())
				|| (hand[1].getValue()==hand[2].getValue() && hand[3].getValue()==hand[4].getValue()) ){
			
			pair = 2;
			
		} else if( hand[0].getValue()==hand[1].getValue()
				|| hand[1].getValue()==hand[2].getValue()
				|| hand[2].getValue()==hand[3].getValue()
				|| hand[3].getValue()==hand[4].getValue() ){
			
			pair = 1;
		}
		return pair; 
   }

   
   
   //Returns true if this hand has 3 cards that are of the same value
   public boolean hasTriplet(){
	   sortByValue();
	   for(int i = 0; i<hand.length-2; i++){
		   if( !(hand[i].getValue() == hand[i+1].getValue() && hand[i].getValue() == hand[i+2].getValue()) ){
			   return false;
		   }
	   }
	   return true; 
   }
    
   
   
   //Returns true if this hand has all cards that are of the same suit
   public boolean hasFlush(){
	   for(int i = 1; i<hand.length; i++){
		   if(hand[0].getSuit() != hand[i].getSuit()){
			   return false;
		   }
	   }
	   return true;
   }
   
   
   //Returns true if this hand has 5 consecutive cards of any suit
   public boolean hasStraight(){
	   for(int i =0; i<hand.length; i++){
			if( !(hand[0].getValue()+i == hand[i].getValue()) ){
				return false;
			}
		}
		return true;
   }
   
   
   
   //Returns true if this hand has a triplet and a pair of different values
   public boolean hasFullHouse(){
	   sortByValue();
	   if( !(hasTriplet() == true && numPairs()==2) ){
		   return false;
	   }
	   return true;
   }
    
   //Returns true if this hand has 4 cards that are of the same value
   public boolean hasFourOfAKind(){
	   sortByValue();
	   for(int i=0; i<hand.length-3; i++){
		   if(hand[i].getValue() == hand[i+1].getValue() && hand[i].getValue() == hand[i+2].getValue() && hand[i].getValue() == hand[i+3].getValue() ){
			   return true;
		   }
	   }
	   return false;
   }
	   

    
   //Returns the card with the highest value in the hand. When there is
   //more than one highest value card, you may return any one of them
   public Card highestValue(){
	   int temp = -1;
	      int position = 0;
	      for (int i = 0; i<hand.length; i++) {
	          if(hand[i].getValue() == 1) {
	              position = i;
	              break;
	              
	          } else if(hand[i].getValue() > temp) {
	                  position = i;
	                  temp = hand[i].getValue();
	          }
	      }
	      return hand[position];
   }
    
   //Returns the highest valued Card of any pair or triplet found, null if
   // none. When values are equal, you may return either
   public Card highestDuplicate(){
	   int temp = -5;
	   int position =0; 
	   if(numPairs() == 0){
		   return null;
	   } else if(numPairs() >= 1){
		   for (int i=0;i<hand.length;i++) {
			   for (int j=i+1; j< hand.length;j++) {
				   if (hand[i].getValue() == hand[j].getValue()){
					   if(hand[i].getValue()==1) {
						   position = i;
						   break;
					   }
					   break;
				   } else if ((hand[i].getValue() == hand[j].getValue()) && hand[i].getValue()>temp){
					   position = i;
					   temp = hand[i].getValue();
				   }
			   }
		   }
	   }
	   return hand[position];
   }
   
   
   //Returns -1 if the instance hand loses to the parameter hand, 0 if 
   //the hands are equal, and +1 if the instance hand wins over the 
   //parameter hand. Hint: you might want to use some of the methods //above
   public int compareTo(Hand h){
	   int win = 0; 
	   
	   //straight and flush --> straight flush

	   if( (this.hasStraight() == true && this.hasFlush() == true) && !(h.hasStraight() == true && h.hasFlush() == true) ){
		   win = 1; 
		   
	   } else if ( !(this.hasStraight() == true && this.hasFlush() == true) && (h.hasStraight() == true && h.hasFlush() == true) ){
		   win = -1;
		   
	   }else if( (this.hasStraight() == true && this.hasFlush() == true) && (h.hasStraight() == true && h.hasFlush() == true) ){
		   if( this.highestValue().getValue() == h.highestValue().getValue() ){
			   win = 0;
		   } else if( this.highestValue().getValue() > h.highestValue().getValue() ){
			   win = 1;
		   } else {
			   win = -1;
		   }
	   }
	   
	   //Four of a kind
	   else if( this.hasFourOfAKind() == true && h.hasFourOfAKind() == false ){
		   win = 1;
	   } else if( this.hasFourOfAKind() == false && h.hasFourOfAKind() == true ){
		   win = -1;
	   } else if( this.hasFourOfAKind() == true && h.hasFourOfAKind() == true ){
		   
		   int first = this.highestDuplicate().getValue();
		   if (first == 1){
			   first = 14;
		   }
		   
		   int second = h.highestDuplicate().getValue();
		   if (second == 1){
			   second = 14;
		   }
		   
		   if(first > second){
			   win = 1;
		   }else if (first< second){
			   win = -1;
		   } else if ( first == second ){
			   int compare1 = 0;
			   int compare2 = 0;
			   
			   for(int i = 0; i<hand.length; i++){
				   if( !(this.hand[i].getValue() == this.highestDuplicate().getValue())){
					   compare1 = this.hand[i].getValue();
				   }
			   }
			   for(int i = 0; i<hand.length; i++){
				   if( !(h.hand[i].getValue() == h.highestDuplicate().getValue())){
					   compare2 = h.hand[i].getValue();
				   }
			   }
			   
			   if(compare1 == 1){
				   compare1 =14;
			   }
			   if(compare2 == 1){
				   compare2 = 14;
			   }
			   
			   if(compare1 > compare2){
				   win = 1;
			   }else if ( compare1<compare2){
				   win = -1;
			   } else if ( compare1 == compare2 ){
				   win =0;
			   }
		   }
	   }
	   
	   
	   
	   // Full House 
	   else if( this.hasFullHouse() == true && h.hasFullHouse()==false ){
		   win = 1;
	   } else if( this.hasFullHouse() == false && h.hasFullHouse()== true ){
		   win = -1;
	   } else if( this.hasFullHouse() == true && h.hasFullHouse()== true ){
		   int triple1 = 0;
		   int triple2 = 0;
		   int double1 = 0;
		   int double2 = 0;
		   
		   for(int i = 0; i<hand.length-2; i++){
			   if(this.hand[i].getValue() == this.hand[i+1].getValue() && this.hand[i].getValue() == this.hand[i+2].getValue() ){
				   triple1 = this.hand[i].getValue();
			   }
		   }
		   
		   for(int i = 0; i<hand.length-2; i++){
			   if(h.hand[i].getValue() == h.hand[i+1].getValue() && h.hand[i].getValue() == h.hand[i+2].getValue() ){
				   triple2 = h.hand[i].getValue();
			   }
		   }
		   
		   int count = 0;
		   for(int i = 0; i<hand.length; i++){
			   for(int j = i+1; j<hand.length; j++){
				   if(this.hand[i].getValue() == this.hand[j].getValue() && this.hand[i].getValue() != triple1){
					   count++;
					   if (count ==2){
						   double1 = this.hand[i].getValue();
					   }
				   }
			   }
		   }
		   for(int i = 0; i<hand.length; i++){
			   for(int j = i+1; j<hand.length; j++){
				   if(h.hand[i].getValue() == h.hand[j].getValue() && h.hand[i].getValue() != triple2){
					   count++;
					   if (count ==2){
						   double2 = h.hand[i].getValue();
					   }
				   }
			   }
		   }
		   
		   if(triple1 > triple2){
			   win = 1;
		   }else if(triple1 < triple2){
			   win = -1;
		   }else if(triple1 == triple2){
			   if(double1 > double2){
				   win = 1;
			   }else if(double1 < double2){
				   win = -1;
			   }else if (double1 == double2){
				   win = 0;
			   }
		   }
	   }
	   
	   
	   //Flush
	   
	   else if( this.hasFlush() == true && h.hasFlush()==false ){
		   win = 1;
	   } else if( this.hasFlush() == false && h.hasFlush()==true ){
		   win = -1;
	   }
	   
	   
	   //Straight
	   else if ( this.hasStraight() == true && h.hasStraight() == false ){
		   win = 1;
	   } else if ( this.hasStraight()== false && h.hasStraight() == true ){
		   win = -1;
	   } else if ( this.hasStraight()== true && h.hasStraight() == true ){
		   if( this.highestValue().getValue() > h.highestValue().getValue() ){
			   win = 1;
		   } else if ( this.highestValue().getValue() < h.highestValue().getValue() ){
			   win = -1;
		   } else if ( this.highestValue().getValue() == h.highestValue().getValue() ){
			   win = 0;
		   }
	   }
	   
	   
	   //Three Of A Kind
	   else if ( this.hasTriplet() == true && h.hasTriplet() == false ){
		   win = 1;
	   }else if ( this.hasTriplet() == false && h.hasTriplet() == true ){
		   win = -1;
	   } else if ( this.hasTriplet() == true && h.hasTriplet() == true ){
		   int triple1 = 0;
		   int triple2 = 0;
		   
		   for(int i = 0; i<hand.length-2; i++){
			   if(this.hand[i].getValue() == this.hand[i+1].getValue() && this.hand[i].getValue() == this.hand[i+2].getValue() ){
				   triple1 = this.hand[i].getValue();
			   }
		   }
		   
		   for(int i = 0; i<hand.length-2; i++){
			   if(h.hand[i].getValue() == h.hand[i+1].getValue() && h.hand[i].getValue() == h.hand[i+2].getValue() ){
				   triple2 = h.hand[i].getValue();
			   }
		   }
		   
		   if ( triple1 > triple2){
			   win = 1;
		   }else if ( triple1 < triple2 ){
			   win = -1;
		   } else if ( triple1 == triple2 ){
			   for(int i = 0; i<hand.length; i++){
				   if(this.hand[i].getValue() == triple1){
					   this.removeCard(i);
				   }
			   }
			   for(int i = 0; i<hand.length; i++){
				   if(h.hand[i].getValue() == triple2){
					   h.removeCard(i);
				   }
			   }
			   this.sortByValue();
			   h.sortByValue();
			   if(this.highestValue().getValue() > h.highestValue().getValue()){
				   win = 1;
			   }else if(this.highestValue().getValue() < h.highestValue().getValue()){
				   win = -1;
			   }else if(this.highestValue().getValue() == h.highestValue().getValue()){
				   if(this.hand[this.hand.length-1].getValue() > h.hand[h.hand.length-1].getValue()){
					   win = 1;
				   }else if ( this.hand[this.hand.length-1].getValue() < h.hand[h.hand.length-1].getValue() ){
					   win = -1;
				   } else if ( this.hand[this.hand.length-1].getValue() == h.hand[h.hand.length-1].getValue() ){
					   win = 0;
				   }
			   }
		   }
		   
	   }
	   
	   
	   //2 Pair
	   else if ( this.numPairs() == 2 && this.hasFourOfAKind() == false && h.numPairs() != 2){
		   win = 1; 
	   } else if ( this.numPairs()!=2 && h.numPairs()==2 && h.hasFourOfAKind() == false){
		   win = -1;
	   } else if ( this.numPairs()==2 && h.numPairs()==2 && this.hasFourOfAKind() == false && h.hasFourOfAKind() == false ){
		   this.sortByValue();
		   h.sortByValue();
		   int oneP1 = 0;
		   int oneP2 = 0;
		   int twoP1 = 0;
		   int twoP2 = 0;
		   
		   for(int i = 0; i<hand.length; i++){
			   for(int j = i+1; j<hand.length; j++){
				   if(this.hand[i].getValue() == this.hand[j].getValue() && this.hand[i].getValue() == this.highestDuplicate().getValue()){
					   oneP1 = this.hand[i].getValue();
				   }
			   }
		   }
		   if(oneP1 == 1){
			   oneP1 =14;
		   }
		   for(int i = 0; i<hand.length; i++){
			   for(int j = i+1; j<hand.length; j++){
				   if(this.hand[i].getValue() == this.hand[j].getValue() && this.hand[i].getValue() != oneP1){
					   oneP2 = this.hand[i].getValue();
				   }
			   }
		   }
		   for(int i = 0; i<hand.length; i++){
			   for(int j = i+1; j<hand.length; j++){
				   if(h.hand[i].getValue() == h.hand[j].getValue() && h.hand[i].getValue() == h.highestDuplicate().getValue()){
					   twoP1 = h.hand[i].getValue();
				   }
			   }
		   }
		   if(twoP1 == 1){
			   twoP1 = 14;
		   }
		   for(int i = 0; i<hand.length; i++){
			   for(int j = i+1; j<hand.length; j++){
				   if(h.hand[i].getValue() == h.hand[j].getValue() && h.hand[i].getValue() != twoP1){
					   twoP2 = h.hand[i].getValue();
				   }
			   }
		   }
		   
		   if(oneP1 > twoP1){
			   win = 1;
		   }else if (oneP1 < twoP1){
			   win = -1;
		   }else if(oneP1 == twoP1){
			   if(oneP2 > twoP2){
				   win = 1;
			   }else if (oneP2 < twoP2){
				   win = -1;
			   }else if (oneP2 == twoP2){
				   int compare1 = 0;
				   int compare2 = 0;
				   
				   for(int i = 0; i<hand.length; i++){
					   if( !(this.hand[i].getValue() == this.highestDuplicate().getValue())){
						   compare1 = this.hand[i].getValue();
					   }
				   }
				   if(compare1 == 1){
					   compare1 =14;
				   }
				   for(int i = 0; i<hand.length; i++){
					   if( !(h.hand[i].getValue() == h.highestDuplicate().getValue())){
						   compare2 = h.hand[i].getValue();
					   }
				   }
				   if(compare2 == 1){
					   compare2 = 14;
				   }
				   
				   if(compare1 > compare2){
					   win = 1;
				   }else if (compare1<compare2){
					   win = -1;
				   } else if ( compare1 == compare2 ){
					   win =0;
				   }
			   }
		   }
	   }
	   
	   
	   
	   //1 Pair
	   else if ( this.numPairs() == 1 && this.hasTriplet() == false && h.numPairs()==0){
		   win = 1;
	   } else if ( this.numPairs() == 0 && h.numPairs() == 1 && h.hasTriplet() == false ){
		   win = -1;
	   }
		   
	   return win;
   }
   
   
   /***************************test*******************/
   
   public static void main(String [] args){
	  Hand h = new Hand();
	  h.addCard(new Card(10,Card.HEARTS));
	  h.addCard(new Card(Card.JACK,Card.HEARTS));
	  h.addCard(new Card(Card.KING,Card.HEARTS));
	  h.addCard(new Card(Card.QUEEN,Card.HEARTS));
	  h.addCard(new Card(Card.ACE,Card.HEARTS));
	  
	  Hand h2 = new Hand();
	  h2.addCard(new Card(9,Card.SPADES));
	  h2.addCard(new Card(10,Card.DIAMONDS));
	  h2.addCard(new Card(3,Card.HEARTS));
	  h2.addCard(new Card(5,Card.CLUBS));
	  h2.addCard(new Card(10,Card.SPADES));
	  
	  System.out.println(h.compareTo(h2));
	  //System.out.println(h2.hasFourOfAKind());
	  
   }
   
}
