import java.util.*;
public class PeopleCircle{
    public String order(int numMales, int numFemales, int K){
	String[] answer = new String[numMales + numFemales];
	if (numMales == 0){
	    return multiply("F", numFemales);
	}

	else if (numFemales == 0){
	    return multiply("M", numMales);
	}

	else 
	    for (int i = K - 1; i < answer.length && numFemales > 0; i += K){
		answer[i] = "F";
		numFemales--;
		while (i + K > answer.length)
		    //example: i = 8 (out of 9) k = 2, should wrap around to 1
		    i = (i + K - answer.length);
	    }

	for (int i = 0; i < answer.length; i++){
	    if(answer[i] != "F")
		answer[i] = "M";
	}


	return String.join("", answer);
    }

    public String multiply(String s, int num){
	String temp = "";
	for (int i = 0; i < num; i++){
	    temp += s;
	}

	return temp;
    }

}


