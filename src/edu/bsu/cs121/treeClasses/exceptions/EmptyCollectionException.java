
package edu.bsu.cs121.treeClasses.exceptions;

//Represents the situation in which a collection is empty.
@SuppressWarnings("serial")
public class EmptyCollectionException extends RuntimeException
{
   /******************************************************************
     Sets up this exception with an appropriate message.
   ******************************************************************/
   public EmptyCollectionException (String collection)
   {
      super ("The " + collection + " is empty.");
   }
}
