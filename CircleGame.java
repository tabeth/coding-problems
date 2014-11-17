import java.util.*;
public class CircleGame {
    public static void main(String args[]){
	System.out.println(cardsLeft("KKK"));
    }

    public static int cardsLeft(String deck){
	HashMap<String,Integer> values = new HashMap<String,Integer>();
	values.put("A", 1);
	values.put("2", 2);
	values.put("3", 3);
	values.put("4", 4);
	values.put("5", 5);
	values.put("6", 6);
	values.put("7", 7);
	values.put("8", 8);
	values.put("9", 9);
	values.put("T", 10);
	values.put("J", 11);
	values.put("Q", 12);
	values.put("K", 13);

	// K is removed, and pairs that add up to 13.
	// if last card remaining and first card add up to 13 they are remoed
	// keep doing it until it cannot be done.

	List<String> temp = new ArrayList<String>(Arrays.asList(deck.split("")));
	int done = 0;
	int pos = 0;

	// Remove Ks
	for (int i = 0; i < temp.size(); i++){
	    temp.remove("K");
	}

	temp.remove("K");

	while (done < 2){
	    if (pos + 1 < temp.size() && temp.size() > 0){
		if (values.get(temp.get(pos)) + 
		    values.get(temp.get(pos+1)) == 13){
		    temp.remove(pos);
		    temp.remove(pos+1);
		    done--;
		}
	    }

	    if (pos + 1 >= temp.size() && temp.size() > 0){
		if (values.get(temp.get(temp.size() -1)) + 
		    values.get(temp.get(0)) == 13){
			temp.remove(0);
			temp.remove(temp.size() -1);
			done--;
		}

		pos = 0;
		done++;
	    }

	    else
		pos++;

	    if(temp.size() <= 0)
		break;

	}
	return temp.size();
    }
}
	    
