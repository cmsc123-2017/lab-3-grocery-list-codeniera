import junit.framework.TestCase;

public class GroceryListTest extends TestCase {
  
  public void testIndexOf() {
    
    GroceryListArray list = new GroceryListArray();   // add items to list
    GroceryItem a = new GroceryItem("appa", 1);
    GroceryItem b = new GroceryItem("bappa", 12);
    GroceryItem c = new GroceryItem("cappa", 13);
    GroceryItem d = new GroceryItem("dappa", 3);
    list.add(a);
    list.add(b);
    list.add(c);
    list.add(d);
    
    assertEquals(list.indexOf("appa"), 0);
    assertEquals(list.indexOf("bappa"), 1);
    assertEquals(list.indexOf("Kappa"), -1);
  }
  
  public void testadd() {
    
    GroceryListArray list = new GroceryListArray();   
    GroceryItem a = new GroceryItem("appa", 1);
    GroceryItem b = new GroceryItem("bappa", 12);
    GroceryItem c = new GroceryItem("cappa", 13);
    GroceryItem d = new GroceryItem("dappa", 3);
    list.add(a);
    list.add(b);
    list.add(c);
    list.add(d);
    
    assertEquals(list.items[0].quantity, 1);
    assertEquals(list.items[1].quantity, 12);
    assertEquals(list.items[2].quantity, 13);
    assertEquals(list.items[3].quantity, 3);
    
    list.add(b);
    
    assertEquals(list.items[1].quantity, 24);
  }
   
  public void testmarkAsBought() {
    
    GroceryListArray list = new GroceryListArray();   
    GroceryItem a = new GroceryItem("appa", 1);
    
    list.add(a);
    
    assertFalse(list.items[0].isBought);
    
    list.markAsBought("appa");
    
    assertTrue(list.items[0].isBought);
  }
  
  public void testtotalQuantity(){
   
    GroceryListArray list = new GroceryListArray();   
    GroceryItem a = new GroceryItem("appa", 1);
    GroceryItem b = new GroceryItem("bappa", 12);
    GroceryItem c = new GroceryItem("cappa", 13);
    GroceryItem d = new GroceryItem("dappa", 3);
    
    list.add(a);
    list.add(b);
    list.add(c);
    
    assertEquals(list.totalQuantity(), 26);
    list.add(d);
    assertEquals(list.totalQuantity(), 29);
  }
  
  public void testreduceQuantity(){
  
    GroceryListArray list = new GroceryListArray();   

    GroceryItem b = new GroceryItem("bappa", 12);

    
    list.add(b);
    
    list.reduceQuantity("bappa", 2);
    
    assertEquals(list.items[0].quantity, 10);
    
  }
  
  public void testremove(){
    GroceryListArray list = new GroceryListArray();   
    GroceryItem a = new GroceryItem("appa", 1);
    GroceryItem b = new GroceryItem("bappa", 12);
    GroceryItem c = new GroceryItem("cappa", 13);
    GroceryItem d = new GroceryItem("dappa", 3);
    
    list.add(a);
    list.add(b);
    list.add(c);
    list.add(d);
    
    assertEquals(list.totalQuantity(), 29);
    list.remove("dappa");
    assertEquals(list.totalQuantity(), 26);
  }
}