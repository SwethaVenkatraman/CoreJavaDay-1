package myPackage;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import myBeans.Book;

public class ShoppingCart {
	
	  HashMap items = null;
	  int numberOfItems = 0;

	  public ShoppingCart() {
	      items = new HashMap();
	  }

	  public void add(String bookId, Book book) {
	    if(items.containsKey(bookId)) {
	        ShoppingCartItem scitem = (ShoppingCartItem) items.get(bookId);
	        scitem.incrementQuantity();
	    } else {
	        ShoppingCartItem newItem = new ShoppingCartItem(book);
	        items.put(bookId, newItem);
	    }

	    numberOfItems++;
	  }

	  public synchronized void remove(String bookId) {
	    if(items.containsKey(bookId)) {
	        ShoppingCartItem scitem = (ShoppingCartItem) items.get(bookId);
	        scitem.decrementQuantity();

	        if(scitem.getQuantity() <= 0)
	            items.remove(bookId);

	        numberOfItems--;
	    }
	  }

	  public synchronized Collection getItems() {
	      return items.values();
	  }

	  protected void finalize() throws Throwable {
	      items.clear();
	  }

	  public synchronized int getNumberOfItems() {
	      return numberOfItems;
	  }
	  public synchronized double getTotal() {
	    double amount = 0.0;

	    for(Iterator i = getItems().iterator(); i.hasNext(); ) {
	        ShoppingCartItem item = (ShoppingCartItem) i.next();
	        Book bookDetails = (Book) item.getItem();

	        amount += item.getQuantity() * bookDetails.getPrice();
	    }
	    return roundOff(amount);
	  }

	  private double roundOff(double x) {
	      long val = Math.round(x*100); // cents
	      return val/100.0;
	  }

	  public synchronized void clear() {
	      items.clear();
	      numberOfItems = 0;
	  }
}
