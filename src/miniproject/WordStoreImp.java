package miniproject;

public class WordStoreImp implements WordStore {

	private static BinaryTree binaryTree;
	
	public class BinaryTree {
		
		private Node root;
		
		public Node getRoot() {
			return root;
		}

		public void setRoot(Node root) {
			this.root = root;
		}


		 class Node {
			private String data;
                        private Node leftChild;
                        private Node rightChild;
                        
			public String getData() {
				return data;
			}
			public void setData(String data) {
				this.data = data;
			}
			public Node getLeftChild() {
				return leftChild;
			}
			public void setLeftChild(Node leftChild) {
				this.leftChild = leftChild;
			}
			public Node getRightChild() {
				return rightChild;
			}
			public void setRightChild(Node rightChild) {
				this.rightChild = rightChild;
			}
			
		}
		
		public boolean insert(String insertingVal,Node node){
			if(root == null){
				root = new Node();
				root.setData(insertingVal);
				return true;
			}else{
				Node tempNode = node;
				
				if(tempNode.getData().hashCode()==insertingVal.hashCode()){
					return false;
				}else if(tempNode.getData().hashCode()>(insertingVal.hashCode())){
					if(tempNode.getLeftChild() == null){
						tempNode.leftChild = new Node();
						tempNode.leftChild.setData(insertingVal);
						return true;
					}else{
						return insert(insertingVal,tempNode.leftChild);
					}
				}else if(tempNode.getData().hashCode()<(insertingVal.hashCode())){
					if(tempNode.getRightChild() == null){
						tempNode.rightChild = new Node();
						tempNode.rightChild.setData(insertingVal);
						return true;
					}else{
						return insert(insertingVal,tempNode.rightChild);
					}
				}
				
				
				
			}
			
			return false;
		}
		
		public int size(Node node){
			
			if(node == null){
				return 0;
			}else if(node.leftChild == null && node.rightChild == null){
				if( node != null && !node.getData().equals(""))
					return 1;
				else if(node.getData().equals(null))
					return 0;
			}else if(node.leftChild != null && node.rightChild != null){
				return size(node.leftChild)+size(node.rightChild)+1; 
			}else if(node.leftChild != null){
				return size(node.leftChild)+1;
			}else if(node.rightChild != null){
				return size(node.rightChild)+1;
				
			}
			return 0;
		}
		
		
		public boolean  remove(String removeWord,Node node) {
			
			
			if(root == null){  
				return false;
			}
			if(node.getData().hashCode()>removeWord.hashCode()){
				if(node.leftChild != null){
					return remove(removeWord, node.leftChild);
				}
				else{
					return false;
				}
			}else if(node.getData().hashCode()<removeWord.hashCode()){
				if(node.rightChild != null){
					return remove(removeWord, node.rightChild);
				} else {
					return false;
				}
			}
			else{
				if(node.getData().hashCode() == removeWord.hashCode()){
					
					
				if(node.leftChild==null && node.rightChild==null){
				
					node.setData("");
					return true;
				}else if(node.leftChild!=null && node.rightChild!=null){
					
				
					String min =findMinimum(node.leftChild, removeWord);
					node.setData(min);
					remove(min, node.leftChild);	
				}	
				
			}
				return false;
			}
		}
		
		public String findMinimum(Node node,String value) {
			if(node.leftChild == null){
				return value;
			}else{
				 return findMinimum(node.leftChild, value);
			}
		}
		
	}
	
	public WordStoreImp() {
		binaryTree = new BinaryTree();
	}
	
	public WordStoreImp(int n){
		binaryTree = new BinaryTree();
	}
	
	@Override
	public void add(String word) {
		binaryTree.insert(word, binaryTree.getRoot());
		
	}

	@Override
	public int count(String word) {
		return binaryTree.size(binaryTree.getRoot());
	}

	@Override
	public void remove(String word) {
		binaryTree.remove(word, binaryTree.getRoot());
	}

	public static void main(String[] args) {
		WordStoreImp wStoreImp3 = new WordStoreImp();
		
		wStoreImp3.add("melo");
		wStoreImp3.add("melojan");
		wStoreImp3.add("mk");
	
		System.out.println(wStoreImp3.count("")+"   ");
		wStoreImp3.remove("mk");
		wStoreImp3.remove("melojan");
		System.out.println(wStoreImp3.count("")+"   ");
	
		
		
	}
}