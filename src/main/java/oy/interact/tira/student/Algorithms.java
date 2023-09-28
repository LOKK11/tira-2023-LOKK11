package oy.interact.tira.student;

import java.util.Comparator;

public class Algorithms {

   private Algorithms() {
      // nada
   }

   ///////////////////////////////////////////
   // Insertion Sort for the whole array
   ///////////////////////////////////////////

   public static <T extends Comparable<T>> void insertionSort(T[] array) {
      // TODO: Student, implement this.
      T temp = null; 
      for (int i = 0; i < array.length - 1; i++) {
         for (int j = i + 1; j < array.length; j++) {
            if (array[i].compareTo(array[j]) > 0) {
               temp = array[i];
               array[i] = array[j];
               array[j] = temp;
            }
         }
      }
   }

   ///////////////////////////////////////////
   // Insertion Sort for a slice of the array
   ///////////////////////////////////////////

   public static <T extends Comparable<T>> void insertionSort(T[] array, int fromIndex, int toIndex) {
      // TODO: Student, implement this.
      T temp = null; 
      for (int i = fromIndex; i < toIndex - 1; i++) {
         for (int j = i + 1; j < toIndex; j++) {
            if (array[i].compareTo(array[j]) > 0) {
               temp = array[i];
               array[i] = array[j];
               array[j] = temp;
            }
         }
      }
   }

   //////////////////////////////////////////////////////////
   // Insertion Sort for the whole array using a Comparator
   //////////////////////////////////////////////////////////

   public static <T> void insertionSort(T[] array, Comparator<T> comparator) {
      // TODO: Student, implement this.
   }

   ////////////////////////////////////////////////////////////
   // Insertion Sort for slice of the array using a Comparator
   ////////////////////////////////////////////////////////////

   public static <T> void insertionSort(T[] array, int fromIndex, int toIndex, Comparator<T> comparator) {
      // TODO: Student, implement this.
   }

   ///////////////////////////////////////////
   // Reversing an array
   ///////////////////////////////////////////

   public static <T> void reverse(T[] array) {
      // TODO: Student, implement this.
   }

   ///////////////////////////////////////////
   // Reversing a slice of an array
   ///////////////////////////////////////////

   public static <T> void reverse(T[] array, int fromIndex, int toIndex) {
      // TODO: Student, implement this.
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
