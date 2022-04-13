import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * @author Michael Dereggi
 *
 *converts MorseCodeTree to englsh
 */
public class MorseCodeConverter
{
	static MorseCodeTree tree=new MorseCodeTree();
    public MorseCodeConverter()
    {
        tree=new MorseCodeTree();
    }
    /**
     * 
     * @return tree
     */
    public static String printTree()
    {
    	String output="";
    	ArrayList<String> printy=tree.toArrayList();
    	for(int i=0;i<printy.size();i++)
    	{
    		output+=printy.get(i);
    		if(i+1!=printy.size())
    		{
    			output+=" ";
    		}
    	}
    	return output;
    }
    /**
     * 
     * @param code converted to english :)
     * @return
     */
    protected static String convertToEnglish(String code) 
    {
		String words[] = code.split("/");
		String output = "";
		String letters[];
		for (int i = 0; i < words.length; i++)
		{
			words[i] = words[i].trim();
			letters = words[i].split(" ");
			for (int j = 0; j < letters.length; j++)
			{
				output+=tree.fetch(letters[j]);
			}
			output += " ";

		}

		return output.trim();
	}
    /**
     * 
     * @param codeFile
     * @return code converted to english using file
     * @throws FileNotFoundException
     */
    public static String convertToEnglish(File codeFile) throws FileNotFoundException
    {
    	if (!codeFile.exists())
			throw new FileNotFoundException("File not found");
		
		Scanner fileReader = new Scanner(codeFile);
		StringBuilder fileRead = new StringBuilder();
		
		while(fileReader.hasNextLine()) {
			fileRead.append(fileReader.nextLine()).append(" ");
		}
		
		fileReader.close();
		
		return convertToEnglish(fileRead.toString());
    }
    
}
