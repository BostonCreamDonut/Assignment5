import java.util.ArrayList;

/**
 * @author Michael DeReggi
 * 
 * This class creates a MorseCodeTree by building it using each morse code to letter combination and then using the lnr and converter in order to to decipher it.
 *
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String>
{
    private TreeNode<String> tree;
    public MorseCodeTree()
    {
    	tree=new TreeNode<String>("");
        buildTree();
    }
    @Override
    public void setRoot(TreeNode<String> newNode)
    {
        tree=newNode;
    }
    
    /**
     *@return root (tree node)
     */
    @Override
    public TreeNode<String> getRoot()
    {
        return tree;
    }
    /**
     *insert a code into tree
     */
    @Override
    public void insert(String code, String result)
    {
        addNode(tree,code,result);
        
    }
    @Override
    public LinkedConverterTreeInterface delete(String data) throws UnsupportedOperationException
    {
        throw new UnsupportedOperationException();
    }
    @Override
    public LinkedConverterTreeInterface update() throws UnsupportedOperationException
    {
        throw new UnsupportedOperationException();
    }
    /**
     *turns tree into arraylist using LNR traversal
     */
    @Override
    public ArrayList<String> toArrayList()
    {
        ArrayList<String> toArray=new ArrayList<>();
        LNRoutputTraversal(tree, toArray);
        return toArray;
    }
    /**
     * build tree using all morse code values of alphabet
     *
     */
    public void buildTree()
    {
    	

    	this.insert(".", "e");
    	this.insert("-", "t");
		this.insert("..", "i");
		this.insert(".-", "a");
		this.insert("-.", "n");
		this.insert("--", "m");
		this.insert("...", "s");
		this.insert("..-", "u");
		this.insert(".-.", "r");
		this.insert(".--", "w");
		this.insert("-..", "d");
		this.insert("-.-", "k");
		this.insert("--.", "g");
		this.insert("---", "o");
		this.insert("....", "h");
		this.insert("...-", "v");
		this.insert("..-.", "f");
		this.insert(".-..", "l");
		this.insert(".--.", "p");
		this.insert(".---", "j");
		this.insert("-...", "b");
		this.insert("-..-", "x");
		this.insert("-.-.", "c");
		this.insert("-.--", "y");
		this.insert("--..", "z");
		this.insert("--.-", "q");
		
    }
    @Override
    public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list)
    {
    	if(root!=null)
    	{
    		LNRoutputTraversal(root.left,list);
    		list.add(root.getData());
    		LNRoutputTraversal(root.right,list);
    	}
        
    }
    @Override
    /**
     * @param code is the code being fetched
     * @return found code
     *
     */
    public String fetch(String code)
    {
        return fetchNode(tree, code);
    }
    @Override
    /**
     * @param root is the treenode used
     * @param code is code being fetched
     * @return node needed for fetch
     *
     */
    public String fetchNode(TreeNode<String> root, String code)
    {
        String fetch="";
        if(code.length()==1)
        {
        	if(code.charAt(0)=='.')
        	{
        		return root.left.getData();
        	}
        	else if(code.charAt(0)=='-')
        	{
        		return root.right.getData();
        	}
        }
        if(code.length()>1)
        {
        	String hold=code.substring(1);
        	if(code.charAt(0)=='.')
        	{
        		fetch=fetchNode(root.left, hold);
        	}
        	else if(code.charAt(0)=='-')
        	{
        		fetch=fetchNode(root.right, hold);
        	}
        }
        return fetch;
    }
	@Override
	/**
	 * @param root, tree node being used
	 * @param code, code being added
	 * @param letter, letter being used
	 * 
	 * adds a node
	 *
	 */
	public void addNode(TreeNode<String> root, String code, String letter)
	{
		TreeNode<String> add=new TreeNode<String>(letter);
		if(code.length()==1)
		{
			if(code.charAt(0)=='.')
			{
				if(root.left==null)
				{
					root.left=add;
				}
			}
			else if(code.charAt(0)=='-')
			{
				if(root.right==null)
				{
					root.right=add;
				}
			}
		}
		if(code.length()>1)
		{
			String hold=code.substring(1);
        	if(code.charAt(0)=='.')
        	{
        		addNode(root.left, hold,letter);
        	}
        	else if(code.charAt(0)=='-')
        	{
        		addNode(root.right, hold,letter);
        	}
		}
		
	}
}
