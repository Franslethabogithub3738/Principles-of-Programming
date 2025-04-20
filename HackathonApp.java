import java.util.Random;

public class HackathonApp{
	public static void main(String[] args){
		
		String[] universities = {"TUT","NMU","UP","UL","WSU","VUT","UJ"};
		int[] judgeScores = {75,65,60,55,60,70,77};
		int[] onlineScores = new int[judgeScores.length];
		int[] totalScores = new int[universities.length];
		
		Random randomizer = new Random();
		for(int i = 0; i < onlineScores.length; i++)
			onlineScores[i] = randomizer.nextInt(100 - 5 + 1) + 5;
		
		for(int i = 0; i < totalScores.length; i++)
			totalScores[i] = judgeScores[i] + onlineScores[i];
		
		int winner = 0;
		
		for(int i = 0; i < universities.length; i++){
			if(totalScores[i] > totalScores[winner])
				winner = i;
		}
		
		System.out.println("\nUniversities\t\tJudjes Scores\t\tOnline Scores\t\tTotal Scores");
		for(int i = 0; i < universities.length; i++)
			System.out.println(universities[i]+"\t\t\t"+judgeScores[i]+"\t\t\t"+onlineScores[i]+"\t\t\t"+totalScores[i]);
			
		System.out.println("The hackathon winners is "+universities[winner]+"\tTotal Score "+totalScores[winner]);
	}
}