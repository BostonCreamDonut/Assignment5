/**
 * @author Michael DeReggi
 * 
 * This class provides a TreeNode for MorseCodeTree to work with
 *
 */
public class TreeNode<T>
{
	//attributes
	//I left left and right public for an easier way to work with them in MorseCodeTree, but made sure to keep data protected
    private T data;
    public TreeNode<T> left;
    public TreeNode<T> right;
    public TreeNode(T dataNode)
    {
        data=dataNode;
        left=null;
        right=null;
    }
    public TreeNode(TreeNode<T> Node)
    {
        data=Node.data;
        left=Node.left;
        right=Node.right;
    }
    
    /**
     * @return data variable
     */
    public T getData()
    {
        return data;
    }

}
