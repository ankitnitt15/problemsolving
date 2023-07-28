import java.util.*;

public class TreeAPI {
    private TreeNode root;
    private Map<Integer, TreeNode> data;
    private static int id = 0;

    public TreeAPI(){
        id = id+1;
        root = new TreeNode(id, "root");
        data =new HashMap<>();
        data.put(id, root);
        id = id + 1;
    }

    public void insert(int parentId, String label){
        TreeNode child;
        TreeNode parent;
        if(data.containsKey(parentId)){
            child = new TreeNode(id, label);
            parent = data.get(parentId);
            parent.getChild().add(child);
            data.put(id, child);
            id = id + 1;
        }
        else{
            System.out.println("Invalid parentId");
        }
    }

    public List<TreeNode> get(){
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> tree = new ArrayList<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            tree.add(temp);
            List<TreeNode> c = data.get(temp.id).getChild();
            Collections.reverse(c);
            for(TreeNode node: c){
                stack.push(node);
            }
        }
        return tree;
    }
    /*
    [
    {
        "<id>": {
            "label": "<first item>",
            "children": [
                {
                    "<id>": {
                        "label": "<another item>",
                        "children": [] // empty children
                    }
                },
                {
                    "<id>": {
                        "label": "<another item>",
                        "children": [ ...<any children>... ]
                    }
                }
            ]
        }
    }
]
     */
    class TreeResponse{
        Map<String, TreeData> map;
    }
    class TreeData{
        String label;
        Map<String, List<TreeResponse>> internal;
    }

    class TreeNode{
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        private int id;
        private String label;

        public List<TreeNode> getChild() {
            return child;
        }

        public void setChild(List<TreeNode> child) {
            this.child = child;
        }

        private List<TreeNode> child;

        public TreeNode(int id, String label){
            this.id = id;
            this.label = label;
            child = new ArrayList<>();
        }
    }

    public static void print(List<TreeNode> res){
        for(TreeNode node: res){
            System.out.println("ID= "+node.getId()+" Label= "+node.getLabel());
        }
    }

    public static void main(String[] args){
        TreeAPI api = new TreeAPI();
        api.insert(1, "A");
        api.insert(1, "B");
        api.insert(1, "C");
        api.insert(1, "D");
        api.insert(3, "E");
        api.insert(3, "F");
        api.insert(4, "G");
        api.insert(4, "H");
        List<TreeNode> res = api.get();
        print(res);
    }
}
