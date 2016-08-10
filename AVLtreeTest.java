/*
Authors: Tanay Agarwal
Class: Data Structures
Assignment: 4
*/

import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Collection;
import java.util.LinkedList;
import java.lang.Iterable;


public class AVLtreeTest {

    public void testEmptyAVLtree(AVLtree<Integer> x) {  
        AVLtree<Integer> em = x;
        assertTrue(em.isEmpty());
        assertTrue(em.size()==0);
        assertTrue(em.root()==null);
        assertTrue(em.contains(5)==false);
        assertTrue(em.remove(6)==false);
        assertTrue(em.toString()=="[]");
    }
    
    @Test
    public void testAddSizeContainsRootTostring() {
        AVLtree<Integer> tree = new AVLtree<Integer>();
        assertFalse(tree.add(null));
        testEmptyAVLtree(tree);
        
        assertTrue(tree.add(5));
        assertTrue(tree.size()==1);
        assertTrue(tree.contains(5));
        assertTrue(tree.root()==5);
        assertEquals(tree.toString(), "[5]");
        assertEquals(tree.preOrder().toString(), "[5]");
        assertEquals(tree.postOrder().toString(), "[5]");
        
        assertTrue(tree.add(6));
        assertTrue(tree.size()==2);
        assertTrue(tree.contains(6));
        assertTrue(tree.root()==5);
        assertEquals(tree.toString(), "[5, 6]");
        assertEquals(tree.preOrder().toString(), "[5, 6]");
        assertEquals(tree.postOrder().toString(), "[6, 5]");
        
        assertTrue(tree.add(10));
        assertTrue(tree.size()==3);
        assertTrue(tree.contains(10));
        assertTrue(tree.root()==6);
        assertEquals(tree.toString(), "[5, 6, 10]");
        assertEquals(tree.preOrder().toString(), "[6, 5, 10]");
        assertEquals(tree.postOrder().toString(), "[5, 10, 6]");
        
        assertTrue(tree.add(0));
        assertTrue(tree.size()==4);
        assertTrue(tree.contains(0));
        assertTrue(tree.root()==6);
        assertEquals(tree.toString(), "[0, 5, 6, 10]");
        assertEquals(tree.preOrder().toString(), "[6, 5, 0, 10]");
        assertEquals(tree.postOrder().toString(), "[0, 5, 10, 6]");
        
        assertTrue(tree.add(99));
        assertTrue(tree.size()==5);
        assertTrue(tree.contains(99));
        assertTrue(tree.root()==6);
        assertEquals(tree.toString(), "[0, 5, 6, 10, 99]");
        assertEquals(tree.preOrder().toString(), "[6, 5, 0, 10, 99]");
        assertEquals(tree.postOrder().toString(), "[0, 5, 99, 10, 6]");
        
        assertTrue(tree.add(5));
        assertTrue(tree.size()==6);
        assertTrue(tree.contains(5));
        assertTrue(tree.root()==6);
        assertEquals(tree.toString(), "[0, 5, 5, 6, 10, 99]");
        assertEquals(tree.preOrder().toString(), "[6, 5, 0, 5, 10, 99]");
        assertEquals(tree.postOrder().toString(), "[0, 5, 5, 99, 10, 6]");
        
        assertTrue(tree.add(7));
        assertTrue(tree.size()==7);
        assertTrue(tree.contains(7));
        assertTrue(tree.root()==6);
        assertEquals(tree.toString(), "[0, 5, 5, 6, 7, 10, 99]");
        assertEquals(tree.preOrder().toString(), "[6, 5, 0, 5, 10, 7, 99]");
        assertEquals(tree.postOrder().toString(), "[0, 5, 5, 7, 99, 10, 6]");
        
        assertTrue(tree.add(-1));
        assertTrue(tree.size()==8);
        assertTrue(tree.contains(-1));
        assertTrue(tree.root()==6);
        assertEquals(tree.toString(), "[-1, 0, 5, 5, 6, 7, 10, 99]");
        assertEquals(tree.preOrder().toString(), "[6, 5, 0, -1, 5, 10, 7, 99]");
        assertEquals(tree.postOrder().toString(), "[-1, 0, 5, 5, 7, 99, 10, 6]");
    }
    
    @Test
    public void testRemoveSizeContainsRootTostring() {
        AVLtree<Integer> tree = new AVLtree<Integer>();
        for (int i = 0; i < 11; i++) {
            tree.add(i);
        }
        assertTrue(tree.root()==3); //balancing is correct
        assertEquals(tree.preOrder().toString(), "[3, 1, 0, 2, 7, 5, 4, 6, 9, 8, 10]");
        assertEquals(tree.postOrder().toString(), "[0, 2, 1, 4, 6, 5, 8, 10, 9, 7, 3]");
        
        assertTrue(tree.remove(0));
        assertTrue(tree.size()==10);
        assertFalse(tree.contains(0));
        assertTrue(tree.root()==3);
        assertEquals(tree.toString(), "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]");
        assertEquals(tree.preOrder().toString(), "[3, 1, 2, 7, 5, 4, 6, 9, 8, 10]");
        assertEquals(tree.postOrder().toString(), "[2, 1, 4, 6, 5, 8, 10, 9, 7, 3]");
        
        assertTrue(tree.remove(3));
        assertTrue(tree.size()==9);
        assertFalse(tree.contains(3));
        assertTrue(tree.root()==4);
        assertEquals(tree.toString(), "[1, 2, 4, 5, 6, 7, 8, 9, 10]");
        assertEquals(tree.preOrder().toString(), "[4, 1, 2, 7, 5, 6, 9, 8, 10]");
        assertEquals(tree.postOrder().toString(), "[2, 1, 6, 5, 8, 10, 9, 7, 4]");
        
        assertTrue(tree.remove(4));
        assertTrue(tree.size()==8);
        assertFalse(tree.contains(4));
        assertTrue(tree.root()==5);
        assertEquals(tree.toString(), "[1, 2, 5, 6, 7, 8, 9, 10]");
        assertEquals(tree.preOrder().toString(), "[5, 1, 2, 7, 6, 9, 8, 10]");
        assertEquals(tree.postOrder().toString(), "[2, 1, 6, 8, 10, 9, 7, 5]");
        
        assertTrue(tree.remove(2));
        assertTrue(tree.size()==7);
        assertFalse(tree.contains(2));
        assertTrue(tree.root()==7);
        assertEquals(tree.toString(), "[1, 5, 6, 7, 8, 9, 10]");
        assertEquals(tree.preOrder().toString(), "[7, 5, 1, 6, 9, 8, 10]");
        assertEquals(tree.postOrder().toString(), "[1, 6, 5, 8, 10, 9, 7]");
        
        assertTrue(tree.remove(9));
        assertTrue(tree.size()==6);
        assertFalse(tree.contains(9));
        assertTrue(tree.root()==7);
        assertEquals(tree.toString(), "[1, 5, 6, 7, 8, 10]");
        assertEquals(tree.preOrder().toString(), "[7, 5, 1, 6, 10, 8]");
        assertEquals(tree.postOrder().toString(), "[1, 6, 5, 8, 10, 7]");
        
        assertTrue(tree.remove(10));
        assertTrue(tree.size()==5);
        assertFalse(tree.contains(10));
        assertTrue(tree.root()==7);
        assertEquals(tree.toString(), "[1, 5, 6, 7, 8]");
        assertEquals(tree.preOrder().toString(), "[7, 5, 1, 6, 8]");
        assertEquals(tree.postOrder().toString(), "[1, 6, 5, 8, 7]");
        
        assertTrue(tree.remove(1));
        assertTrue(tree.size()==4);
        assertFalse(tree.contains(1));
        assertTrue(tree.root()==7);
        assertEquals(tree.toString(), "[5, 6, 7, 8]");
        assertEquals(tree.preOrder().toString(), "[7, 5, 6, 8]");
        assertEquals(tree.postOrder().toString(), "[6, 5, 8, 7]");
        
        assertTrue(tree.remove(7));
        assertTrue(tree.size()==3);
        assertFalse(tree.contains(7));
        assertTrue(tree.root()==6);
        assertEquals(tree.toString(), "[5, 6, 8]");
        assertEquals(tree.preOrder().toString(), "[6, 5, 8]");
        assertEquals(tree.postOrder().toString(), "[5, 8, 6]");
        
        tree.add(4);
        tree.add(6);
        tree.add(7);
        tree.add(9);
        tree.add(5);
        tree.add(6);
        tree.add(10);
        tree.add(7);
        assertTrue(tree.root()==7);
        
        assertTrue(tree.remove(4));
        assertTrue(tree.size()==10);
        assertFalse(tree.contains(4));
        assertTrue(tree.root()==7);
        assertEquals(tree.toString(), "[5, 5, 6, 6, 6, 7, 7, 8, 9, 10]");
        
        assertTrue(tree.remove(10));
        assertTrue(tree.size()==9);
        assertFalse(tree.contains(10));
        assertTrue(tree.root()==7);
        assertEquals(tree.toString(), "[5, 5, 6, 6, 6, 7, 7, 8, 9]");
        
        assertTrue(tree.remove(9));
        assertTrue(tree.size()==8);
        assertFalse(tree.contains(9));
        assertTrue(tree.root()==7);
        assertEquals(tree.toString(), "[5, 5, 6, 6, 6, 7, 7, 8]");
        
        assertTrue(tree.remove(7));
        assertTrue(tree.size()==7);
        assertFalse(!tree.contains(7));
        assertTrue(tree.root()==6);
        assertEquals(tree.toString(), "[5, 5, 6, 6, 6, 7, 8]");
        
        assertTrue(tree.remove(5));
        assertTrue(tree.size()==6);
        assertFalse(!tree.contains(5));
        assertTrue(tree.root()==6);
        assertEquals(tree.toString(), "[5, 6, 6, 6, 7, 8]");
        
        assertTrue(tree.remove(6));
        assertTrue(tree.size()==5);
        assertFalse(!tree.contains(6));
        assertTrue(tree.root()==6);
        assertEquals(tree.toString(), "[5, 6, 6, 7, 8]");
        
        assertTrue(tree.remove(6));
        assertTrue(tree.size()==4);
        assertFalse(!tree.contains(6));
        assertTrue(tree.root()==7);
        assertEquals(tree.toString(), "[5, 6, 7, 8]");
        
        assertTrue(tree.remove(7));
        assertTrue(tree.size()==3);
        assertFalse(tree.contains(7));
        assertTrue(tree.root()==6);
        assertEquals(tree.toString(), "[5, 6, 8]");
        
        assertTrue(tree.remove(6));
        assertTrue(tree.remove(5));
        assertTrue(tree.remove(8));
        
        testEmptyAVLtree(tree);
        
        tree.add(4);
        tree.add(3);
        tree.add(5);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(7);
        assertTrue(tree.root() == 4);
        assertEquals(tree.preOrder().toString(), "[4, 3, 2, 5, 4, 6, 7]");
        assertEquals(tree.postOrder().toString(), "[2, 3, 4, 7, 6, 5, 4]");
        tree.remove(4);
        assertEquals(tree.preOrder().toString(), "[4, 3, 2, 6, 5, 7]");
        assertEquals(tree.postOrder().toString(), "[2, 3, 5, 7, 6, 4]");
        tree.remove(5);
        tree.remove(6);
        assertEquals(tree.inOrder().toString(), "[2, 3, 4, 7]");
        
    }
    
    @Test
    public void testBestFit() {
        AVLtree<Integer> tree = new AVLtree<Integer>();
        for (int i = 0; i < 11; i++) {
            tree.add((int) Math.pow(2, i));
        }
        
        for (int i = 2; i < 11; i++) {
            assertTrue(tree.bestFit(((int) Math.pow(2, i)) - 1) == Math.pow(2, i));
        }
        
        assertTrue(tree.bestFit(5) == 8);
        assertTrue(tree.bestFit(5000) == null);
        assertTrue(tree.bestFit(1000) == 1024);
        assertTrue(tree.bestFit(50) == 64);
        assertTrue(tree.bestFit(100) == 128);
        assertTrue(tree.bestFit(64) == 64);
        assertTrue(tree.bestFit(1) == 1);
        assertTrue(tree.bestFit(8) == 8);
        assertTrue(tree.bestFit(512) == 512);
        assertTrue(tree.bestFit(32) == 32);
        assertTrue(tree.bestFit(200) == 256);
        assertTrue(tree.bestFit(1025) == null);
    }
    
    @Test
    public void testInOrder() {
        AVLtree<Integer> tree = new AVLtree<Integer>();
        LinkedList<Integer> list = new LinkedList<Integer>();
        assertTrue(tree.inOrder().equals(list));
        
        for (int i = 0; i < 11; i++) {
            tree.add(i);
            list.add(i);
            assertEquals(tree.inOrder(), list);
        }
        
        tree = new AVLtree<Integer>();
        list.clear();
        
        for (int i = 11; i > -1; i--) {
            tree.add(i);
            list.add(0, i);
            assertEquals(tree.inOrder(), list);
        }
    }
}
