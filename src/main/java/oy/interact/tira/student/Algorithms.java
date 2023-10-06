package oy.interact.tira.student;

import java.util.Comparator;

public class Algorithms {

   private Algorithms() {
      // nada
   }

   public static <T> void swap(T[] array, int first, int second) {
      //This function swaps the places of 2 values in an array.
      T temp = null;
      temp = array[first];
      array[first] = array[second];
      array[second] = temp;
   }

   ///////////////////////////////////////////
   // Insertion Sort for the whole array
   ///////////////////////////////////////////

   public static <T extends Comparable<T>> void insertionSort(T[] array) {
      insertionSort(array, 0, array.length);
   }

   ///////////////////////////////////////////
   // Insertion Sort for a slice of the array
   ///////////////////////////////////////////

   public static <T extends Comparable<T>> void insertionSort(T[] array, int fromIndex, int toIndex) {
      for (int i = fromIndex + 1; i < toIndex; i++) {
          T k = array[i];
          int j = i - 1;
  
          while (j >= fromIndex && array[j].compareTo(k) > 0) {
              array[j + 1] = array[j];
              j--;
          }
          array[j + 1] = k;
      }
  }

   //////////////////////////////////////////////////////////
   // Insertion Sort for the whole array using a Comparator
   //////////////////////////////////////////////////////////

   public static <T> void insertionSort(T[] array, Comparator<T> comparator) {
      insertionSort(array, 0, array.length, comparator);
   }

   ////////////////////////////////////////////////////////////
   // Insertion Sort for slice of the array using a Comparator
   ////////////////////////////////////////////////////////////

   public static <T> void insertionSort(T[] array, int fromIndex, int toIndex, Comparator<T> comparator) {
      for (int i = fromIndex + 1; i < toIndex; i++) {
          T k = array[i];
          int j = i - 1;
  
          while (j >= fromIndex && comparator.compare(array[j], k) > 0) {
              array[j + 1] = array[j];
              j--;
          }
          array[j + 1] = k;
         }
   }

   ///////////////////////////////////////////
   // Reversing an array
   ///////////////////////////////////////////

   public static <T> void reverse(T[] array) {
      int i = 0;
      int j = array.length -1;
      while (true) {
         if (i < j) {
            swap(array, i, j);
            i++;
            j--;
         } else {
            break;
         }
      }
   }

   ///////////////////////////////////////////
   // Reversing a slice of an array
   ///////////////////////////////////////////

   public static <T> void reverse(T[] array, int fromIndex, int toIndex) {
      // TODO: Student, implement this.
      int i = fromIndex;
      int j = toIndex -1;
      while (true) {
         if (i < j) {
            swap(array, i, j);
            i++;
            j--;
         } else {
            break;
         }
      }
   }




   ///////////////////////////////////////////
   // Binary search bw indices
   ///////////////////////////////////////////

   public static <T extends Comparable<T>> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex) {
      return -1;
   }

   ///////////////////////////////////////////
   // Binary search using a Comparator
   ///////////////////////////////////////////

   public static <T> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex, Comparator<T> comparator) {
      return -1;
   }

   public static <E extends Comparable<E>> void fastSort(E [] array) {
      // TODO: Student, implement this.
   }

   public static <E> void fastSort(E [] array, Comparator<E> comparator) {
      // TODO: Student, implement this.
   }

   public static <E> void fastSort(E [] array, int fromIndex, int toIndex, Comparator<E> comparator) {
      // TODO: Student, implement this.
   }

}
