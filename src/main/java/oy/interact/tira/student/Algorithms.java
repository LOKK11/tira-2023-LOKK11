package oy.interact.tira.student;

import java.util.Comparator;

import javax.print.attribute.standard.PresentationDirection;

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
      int low = fromIndex;
      int high = toIndex - 1;
      while (low != high) {
         int middle = low + (high - low) / 2;
         if (aValue.compareTo(fromArray[middle]) <= 0) {
            high = middle;
         } else {
            low = middle + 1;
         }
      }
      if (aValue.compareTo(fromArray[low]) == 0) {
         return low;
      }
      return -1;
   }

   public static <T extends Comparable<T>> int binarySearchR(T aValue, T[] fromArray, int fromIndex, int toIndex) {
      int low = fromIndex;
      int high = toIndex - 1;
      int middle = low + (high - low) / 2;
      if (low == high) {
         if (aValue.compareTo(fromArray[low]) == 0) {
            return low;
         } else {
            return -1;
         }
      }
      if (aValue.compareTo(fromArray[middle]) <= 0) {
         return binarySearchR(aValue, fromArray, low, middle + 1);
      } else {
         return binarySearchR(aValue, fromArray, middle + 1, high + 1);
      }
   }

   ///////////////////////////////////////////
   // Binary search using a Comparator
   ///////////////////////////////////////////

   public static <T> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex, Comparator<T> comparator) {
      int low = fromIndex;
      int high = toIndex - 1;
      while (low != high) {
         int middle = low + (high - low) / 2;
         if (comparator.compare(aValue, fromArray[middle]) <= 0) {
            high = middle;
         } else {
            low = middle + 1;
         }
      }
      if (comparator.compare(aValue, fromArray[low]) == 0) {
         return low;
      }
      return -1;
   }

   public static <T> int binarySearchR(T aValue, T[] fromArray, int fromIndex, int toIndex, Comparator<T> comparator) {
      int low = fromIndex;
      int high = toIndex - 1;
      int middle = low + (high - low) / 2;
      if (low == high) {
         if (comparator.compare(aValue, fromArray[low]) == 0) {
            return low;
         } else {
            return -1;
         }
      }
      if (comparator.compare(aValue, fromArray[middle]) <= 0) {
         return binarySearchR(aValue, fromArray, low, middle + 1, comparator);
      } else {
         return binarySearchR(aValue, fromArray, middle + 1, high + 1, comparator);
      }

   }

   public static <E extends Comparable<E>> void fastSort(E [] array) {
      quickSort(array, 0, array.length - 1);
   }

   public static <E> void fastSort(E [] array, Comparator<E> comparator) {
      //quickSortC(array, 0, array.length - 1, comparator);
      mergeSortC(array, 0, array.length - 1, comparator);
      //heapSortC(array, 0, array.length, comparator);
   }

   public static <E> void fastSort(E [] array, int fromIndex, int toIndex, Comparator<E> comparator) {
      //quickSortC(array, fromIndex, toIndex - 1, comparator);
      mergeSortC(array, fromIndex, toIndex - 1, comparator);
      //heapSortC(array, fromIndex, toIndex, comparator);
   }

   public static <E> void quickSortC(E [] array, int fromIndex, int toIndex, Comparator<E> comparator) {
      if (fromIndex < toIndex) {
         int partitionIndex = partitionQuickC(array, fromIndex, toIndex, comparator);
         quickSortC(array, fromIndex, partitionIndex, comparator);
         quickSortC(array, partitionIndex + 1, toIndex, comparator);
     }      
   }

   private static <E> int partitionQuickC(E[] array, int low, int high, Comparator<E> comparator) {
      int midPoint = (int)(low + (high - low) / 2);
      E pivot = array[midPoint];
      int i = low - 1;
      int j = high + 1;
      while (true) {
         do {
            ++i;
         } while (comparator.compare(array[i], pivot) < 0);
         do {
            --j;
         } while (comparator.compare(array[j], pivot) > 0);
         if (j <= i) {
            return j;
         }
         swap(array, i, j);
      }
   }

   public static <E extends Comparable<E>> void quickSort(E [] array, int fromIndex, int toIndex) {
      if (fromIndex < toIndex) {
         int partitionIndex = partitionQuick(array, fromIndex, toIndex);
         quickSort(array, fromIndex, partitionIndex);
         quickSort(array, partitionIndex + 1, toIndex);
     }      
   }

   private static <E extends Comparable<E>> int partitionQuick(E[] array, int low, int high) {
      int midPoint = (int)(low + (high - low) / 2);
      E pivot = array[midPoint];
      int i = low - 1;
      int j = high + 1;
      while (true) {
         do {
            ++i;
         } while (array[i].compareTo(pivot) < 0);
         do {
            --j;
         } while (array[j].compareTo(pivot) > 0);
         if (j <= i) {
            return j;
         }
         swap(array, i, j);
      }
   }

   public static <E> void heapSortC(E [] array, int fromIndex, int toIndex, Comparator<E> comparator) {
      if (toIndex > fromIndex) {
         int length = toIndex - fromIndex;
         heapify(array, length, fromIndex, comparator);
         int end = length - 1;
         while (end > 0) {
            swap(array, end + fromIndex, fromIndex); 
            --end;
            siftDown(array, 0, end, fromIndex, comparator);
         }
      }
   }

   private static <E> void heapify(E [] array, int count, int startingIndex, Comparator<E> comparator) {
      int start = parent(count - 1);
      while (start >= 0) {
         siftDown(array, start, count - 1, startingIndex, comparator);
         --start;
      }
   }

   private static <E> void siftDown(E [] array, int start, int end, int startingIndex, Comparator<E> comparator) {
      int root = start;
      while (leftChild(root) <= end) {
         int child = leftChild(root);
         int swap = root;
         if (comparator.compare(array[swap + startingIndex], array[child + startingIndex]) < 0) {
            swap = child;
         }
         if (child + 1 <= end && comparator.compare(array[swap + startingIndex], array[child + 1 + startingIndex]) < 0) {
            swap = child + 1;
         }
         if (swap == root) {
            return;
         } else {
            swap(array, root + startingIndex, swap + startingIndex);
            root = swap;
         }
      }
   }

   private static int parent(int node) {
      return (int)Math.floor((node - 1) / 2);
   }

   private static int leftChild(int node) {
      return 2 * node + 1;
   }

   public static <E> void mergeSortC(E [] array, int fromIndex, int toIndex, Comparator<E> comparator) {
      if (toIndex > fromIndex) {
         int mid = (int)Math.floor(fromIndex + (toIndex - fromIndex) / 2);
         mergeSortC(array, fromIndex, mid, comparator);
         mergeSortC(array, mid + 1, toIndex, comparator);
         merge(array, fromIndex, mid, toIndex, comparator);
      }
   }

   @SuppressWarnings("unchecked")
   private static <E> void merge(E array[], int fromIndex, int middle, int toIndex, Comparator<E> comparator) {
      int i, j, k;
      int n1 = middle - fromIndex + 1;
      int n2 = toIndex - middle;
      Object leftArray[] = new Object[n1];
      Object rightArray[] = new Object[n2];

      for (i = 0; i < n1; i++) {
         leftArray[i] = array[fromIndex + i];
      }
      for (j = 0; j < n2; j++) {
         rightArray[j] = array[middle + 1 + j];
      }
      
      i = 0;
      j = 0;
      k = fromIndex;

      while (i < n1 && j < n2) {
         if (comparator.compare((E)leftArray[i], (E)rightArray[j]) <= 0) {
            array[k] = (E)leftArray[i];
            ++i;
         } else {
            array[k] = (E)rightArray[j];
            ++j;
         }
         ++k;
      }

      while (i < n1) {
         array[k] = (E)leftArray[i];
         ++i;
         ++k;
      }

      while (j < n2) {
         array[k] = (E)rightArray[j];
         ++j;
         ++k;
      }      
   }

}
