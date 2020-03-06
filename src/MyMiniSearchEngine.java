import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class MyMiniSearchEngine {
    // default solution. OK to change.
    // do not change the signature of index()
    private Map<String, List<List<Integer>>> indexes = new HashMap<>();

    // disable default constructor
    private MyMiniSearchEngine() {
    }

    public MyMiniSearchEngine(List<String> documents) {
        index(documents);
    }

    // each item in the List is considered a document.
    // assume documents only contain alphabetical words separated by white spaces.
    private void index(List<String> texts) {
        for(int i=0;i<texts.size();i++) {
    	String[] words=texts.get(i).split(" ");
    		for(int j=0;j<words.length;j++) {
    			if(!indexes.containsKey(words[j])){
    				List<List<Integer>> list = new ArrayList<List<Integer>>();
    				List<Integer> inlist= new ArrayList<>();
    				inlist.add(i);
    				list.add(inlist);
    				indexes.put(words[j], list);
    			}
    			else if(indexes.containsKey(words[j])){
    				List<Integer> inlist= new ArrayList<>();
    				inlist.add(i);
    				List<List<Integer>> list = new ArrayList<List<Integer>>();
    				list=indexes.get(words[j]);
    				list.add(inlist);
    				indexes.replace(words[j], list);
    			}
    		}
    	}
 }
        
        
                
    	
    

    // search(key) return all the document ids where the given key phrase appears.
    // key phrase can have one or two words in English alphabetic characters.
    // return an empty list if search() finds no match in all documents.
    public List<Integer> search(String keyPhrase) {
        List<Integer> docId= new ArrayList<>();
        for(int i=0;i<indexes.get(keyPhrase).size();i++)
        {
        	for(int j=0;j<indexes.get(keyPhrase).get(i).size();j++)
        	{docId.add(indexes.get(keyPhrase).get(i).get(j));
        	}
        }
       
        return docId; // place holder
    }
}
