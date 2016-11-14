import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.HashSet;
import java.util.Set;
/**
 * Write a description of class MST here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MST extends Actor
{
    private boolean isFirstNode = true;
    private Set<Node> nodeSet = new HashSet<>();
    private Set<Edge> edgeSet = new HashSet<>();
    private int minimum = 18;
    private ScoreBoard sb;
    private boolean isFinished;
    private TreasureChest tc;
    
    public MST(ScoreBoard sb, TreasureChest tc){
        this.sb = sb;
        this.tc = tc;
    }
    /**
     * Act - do whatever the MST wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
    }  
    
    
    public static void main(String[] args) {
        
        /*MST mst = new MST();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        mst.getNodeSet().add(n1);
        mst.getNodeSet().add(n2);
        mst.getNodeSet().add(n3);
        mst.getNodeSet().add(n4);
        mst.getNodeSet().add(n5);
        Edge e1 = n1.addEdgeTo(1, n2, 4);
        Edge e2 = n1.addEdgeTo(2, n3, 8);
        Edge e3 = n2.addEdgeTo(3, n3, 6);
        Edge e4 = n2.addEdgeTo(4, n4, 5);
        Edge e5 = n2.addEdgeTo(5, n5, 7);
        Edge e6 = n3.addEdgeTo(6, n4, 3);
        Edge e7 = n4.addEdgeTo(7, n5, 9);
        mst.getEdgeSet().add(e1);
        mst.getEdgeSet().add(e2);
        mst.getEdgeSet().add(e3);
        mst.getEdgeSet().add(e4);
        mst.getEdgeSet().add(e5);
        mst.getEdgeSet().add(e6);
        mst.getEdgeSet().add(e7);
        n1.pickNode(mst);
        e1.pickEdge(mst);
        e4.pickEdge(mst);
        e2.pickEdge(mst);
        e6.pickEdge(mst);
        e7.pickEdge(mst);*/
    }

    public MST getMST() {
        return this;
    }

    public void checkResult() {
        /*for (Node node : nodeSet) {
            if (node.getState().equals(State.NOT_SELECTED) || node.getState().equals(State.SUGGESTED)) {
                return;
            }
        }*/
        // result
        int result = 0;
        for (Edge edge : edgeSet) {
            if (edge.getState().equals(State.SELECTED))
                result += edge.getWeight();
        }
        int selectedNodes = 0;
        for (Node node : nodeSet) {
            if (node.getState().equals(State.SELECTED)) {
                selectedNodes++;
            }
        }
        int perc = selectedNodes * 100 / nodeSet.size();
        sb.updateScore(result, perc, selectedNodes == nodeSet.size(),true);
        if(selectedNodes == nodeSet.size()){
            isFinished = true;
        if (result == minimum) {

            // eureka
            Greenfoot.playSound("sounds/win.mp3");
            System.out.println("Eureka");
            tc.setImage("images/open_chest.png");
            //Added code to shake the open-chest image for emphasis
            tc.move(40);
            Greenfoot.delay(5);
            tc.move(-40);
        } else if(result > minimum){
            // ooops...!! not eureka..!!
            Greenfoot.playSound("sounds/sorry.mp3");
            System.out.println("You haven't connected bulbs with minimum volts");

        }
    }
    }

    public boolean isFirstNode() {
        return isFirstNode;
    }

    public void setFirstNode(boolean isFirstNode) {
        this.isFirstNode = isFirstNode;
    }

    public Set<Node> getNodeSet() {
        return nodeSet;
    }

    public void setNodeSet(Set<Node> nodeSet) {
        this.nodeSet = nodeSet;
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public Set<Edge> getEdgeSet() {
        return edgeSet;
    }

    public void setEdgeSet(Set<Edge> edgeSet) {
        this.edgeSet = edgeSet;
    }
    public boolean isIsFinished(){
        return isFinished;
    }
    
    public void setIsFinished(boolean isFinished){
        this.isFinished = isFinished;
    }







}
