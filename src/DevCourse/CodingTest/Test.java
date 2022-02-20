package DevCourse.CodingTest;

class Card{
    int data;
    Card(int data){
        this.data = data;
    }
    void play(Card otherCard){
        if(this.data < otherCard.data){
            System.out.println("Game's up. You lose");
        }else if(this.data > otherCard.data){
            System.out.println("Game's up. You win");
        }else if(this.data == otherCard.data){
            System.out.println("Game's up. You two halve the match");
        }
    }
}
public class Test{
    public static void main(String [] args){
        Card card1 = new Card(6);
        Card card2 = new Card(1);
        card1.play(card2);
    }
}