package Izard_Text_Analyzer;
import java.io.*;
import java.util.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Dawn Izard
 * Date: January 31, 2020
 * Update: March 7, 2020 Added GUI
 * Program Name: Izard_Text_Analyzer
 * Purpose: Analyzes all words in a file and returns the
 * 			each unique word and how many times it is used
 * 			in a file.
 */



public class Izard_Text_Analyzer extends Application {

	
		Button btn_click;
		VBox layout;
		TextArea text;

	   public static void main(String[] args)  throws IOException {
		launch(args);
	   }

	   /**
	    * Creates a GUI interface
	    * @param stage name of GUI stage
	    * @throws Exception error if no words found
	    */
	   
		@Override
		public void start(Stage stage) throws Exception {
			btn_click = new Button("Analyze Text");
			layout = new VBox(10);
			text = new TextArea();
			text.setPrefRowCount(20);
			layout.setAlignment(Pos.CENTER);
			layout.getChildren().addAll(text,btn_click);
			
			stage.setTitle("Izard Text Analyzer");
			Scene scene = new Scene(layout,300,400);
			stage.setScene(scene);
			stage.show();

			//On button click execute Text Analyzer code
			btn_click.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
						
				String results = processFile("macbeth-1.txt");
				//Displays compiled string to interface
			       text.setText(results);
			      

				}
			});
		}

    
	/**
	 * Sorts Hashmap entries by creating a list of words,
         * sorting the word count in descending order
         * and then creating another HashMap with the sorted
         * words    
	 * @param wordcounts Word count
	 * @return sorted sorted list
	 */
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> wordcounts) 
    { 
 
        List<Map.Entry<String, Integer> > wordlist = 
               new LinkedList<Map.Entry<String, Integer> >(wordcounts.entrySet()); 
  
        
        Collections.sort(wordlist, new Comparator<Map.Entry<String, Integer> >() { 
            public int compare(Map.Entry<String, Integer> count1,  
                               Map.Entry<String, Integer> count2) 
            { 
                return (count2.getValue()).compareTo(count1.getValue()); 
            } 
        }); 
          
        HashMap<String, Integer> tempmap = new LinkedHashMap<String, Integer>(); 
        for (Map.Entry<String, Integer> sorted : wordlist) { 
            tempmap.put(sorted.getKey(), sorted.getValue()); 
        } 
        return tempmap; 
    }

   /**
    * Reads a file and creates a hashmap of words and occurrences 
    * @param readFile name of file to read
    * 
    * @return string of compiled words
    */
    public String processFile(String readFile) {
    	
		File file = new File(readFile); //text file to analyze
		 BufferedReader rf = null;
		try {
			rf = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} 

       String line;
       HashMap<String, Integer> wordcounts = new HashMap<String, Integer>();
       
       //breaks out words and inserts them into hashmap
       
			try {
				while ((line = rf.readLine()) != null) {
					//strips out punctuation and lower cases all words
				    String[] words = line.toLowerCase().split("[\\s.;,?:!()<\"]+"); 
				    for (String word : words) {
				        word = word.trim();
				        if (word.length() > 0) {
				            if (wordcounts.containsKey(word)) {
				                wordcounts.put(word, wordcounts.get(word) + 1);
				            } else {
				                wordcounts.put(word, 1);
				            }
				        }
				    }
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		
       //compiles string of words and their occurrences
	   String compileString = "";
       Map<String, Integer> counts1 = sortByValue(wordcounts);
       for (Map.Entry<String, Integer> entry : counts1.entrySet()) {
       	compileString = compileString + entry.getKey() + " : " + entry.getValue() + "\n"; 		        	
       }
    	
       return compileString;
    }

}


