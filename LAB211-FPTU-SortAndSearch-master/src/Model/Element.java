/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
/**
 *
 * @author hoang
 */
public class Element {

    private int arraySize;
    private static int[] arr;

    public Element() {
    }
   
    
    public Element(int arraySize, int[] arr) {
        this.arraySize = arraySize;
        this.arr = arr;
    }

    public int getArraySize() {
        return arraySize;
    }

    public void setArraySize(int arraySize) {
        this.arraySize = arraySize;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

//    public int[] inputArray() {        
//        Scanner sc = new Scanner(System.in); 
//        System.out.println("Enter array size");
//        arraySize = sc.nextInt();        
//        arr = new int[arraySize];
//        Random rd = new Random();
//        for (int i = 0; i < arraySize; i++) {
//            arr[i] = rd.nextInt(100);
//        }
//        return arr;
//    }
    
}
