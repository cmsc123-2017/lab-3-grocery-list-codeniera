class GroceryListArray implements IGroceryList {
  
  int max = 10;
  GroceryItem items[] = new GroceryItem[max];
  int size = 0;
  
  GroceryListArray() {}
    
  
  public boolean add(GroceryItem item) {
    if (size == max) {
      // create new array with bigger length
       int biggerMax = max * 2;
       GroceryItem biggerA[] = new GroceryItem[biggerMax];
      // copy items to new array
      // assign new array to items
      System.arraycopy(this.items, 0, biggerA, 0, size);
      this.items = biggerA;
      max = biggerMax;
      // return false; // don't return instead
    }
    
    int i = indexOf(item.name);
    if (i > -1) {
      items[i].addQuantity(item.quantity);
    } else {    
      items[this.size] = item;
      this.size++;
      
    }
    return true;
  }
  
  // TEMPLATE
  /*  Fields:
   *    this.max
   *    this.items   --GroceryItem[]
   *    this.size
   * 
   *  Methods:
   *    this.add
   *    this.indexOf
   *    this.remove
   *    this.markAsBought
   *    this.display
   * 
   *  Methods on this.items[i]:
   *    this.items[i].addQuantity()
   *    this.items[i].equals()
   *    this.items[i].toString()
   */
  
   
  // String -> int
  // Given the name of a GroceryItem, returns the
  // corresponding GroceryItem index from the list. If it is not in the list,
  //  returns -1
  public int indexOf(String name) {
    for (int i = 0; i < this.size; i++) {
      if (this.items[i].equals(new GroceryItem(name, 0))) {
        return i;
      }
    }
    
    return -1;
  }
  
  
  public boolean remove(String name) {
    if(indexOf(name) == -1)
      return false;
    else{
      GroceryItem temp = new GroceryItem(items[size-1].name, items[size-1].quantity);
      items[indexOf(name)] = temp;
    }
    size--;
    return true;
  }
  
  public boolean markAsBought(String name) {
    if(indexOf(name) == -1)
      return false;
    items[indexOf(name)].bought();
    return true;
  }
  
  public void display() {
    for (int i = 0; i < this.size; i++) {
      System.out.println(items[i]);
    }
  }
  
  public int totalQuantity(){
    int answer=0;
    for(int i = 0; i < this.size; i++){
      answer+=items[i].quantity;
    }
    return answer;
  }
  
  public boolean reduceQuantity(String itemName, int quantity){
    if(indexOf(itemName) == -1)
      return false;
    else
      items[indexOf(itemName)].quantity -=quantity;
    if(items[indexOf(itemName)].quantity < 1)
      remove(itemName);
    return true;
  }
  
}