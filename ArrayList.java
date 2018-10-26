public class ArrayList implements List {
    private Object[] arr;
    private int numObjects; //#of objects in the arraylist

    public ArrayList(){
        arr = new Object[10]; //instantiate with size 10
        numObjects = 0; //starts with 0 objects
    }

    public void grow_array(){
        Object[] newArr = new Object[2*arr.length]; //create a new array of twice the size
        for(int i=0; i<arr.length; i++){
            newArr[i] = arr[i]; //fill the new array with the contents of the old array
        }
        arr = newArr; //set the variable array to be the new array
    }

    public void add(Object obj){
        if(numObjects==arr.length){ //if the array is full, grow it
            grow_array();
        }
        arr[numObjects] = obj; //fill the last space with the new object
        numObjects++; //increment the number of objects in the array
    }

    public void add(int pos, Object obj){
        if(numObjects==arr.length){ //if the array is full grow it
            grow_array();
        }
        if(pos==numObjects) //if the overloaded function is called on the end of the array, manually set it to the new value
            arr[pos] = obj;
        else {
            Object[] newArr = new Object[arr.length]; //create a new array
            for (int i = 0; i < pos; i++) { //copy all of the data before the position where new data will be added
                newArr[i] = arr[i];
            }
            newArr[pos] = obj; //add the new object at the specified position
            for (int j = pos; j < numObjects; j++) {
                newArr[j + 1] = arr[j]; //copy the rest of the data to the remainder of the array
            }
        }
        numObjects++; //increment the number of objects in the array
    }

    public Object get(int pos){
        return arr[pos]; //return the object at the position
    }

    public Object remove(int pos){
        Object[] newArr = new Object[arr.length]; //create a new array
        Object return_object = arr[pos]; //set the object to be returned so it doesn't get overwritten
        for(int i=0;i<numObjects-1;i++){
            if(i<pos)
                newArr[i] = arr[i]; //copy all of the items from the old array before the item being removed to the new array
            else
                newArr[i] = arr[i+1]; //left shift the rest of the old array omitting the removed object
        }
        numObjects--; //decrement the number of objects
        arr = newArr; //set the variable array to be the new array
        return return_object; //return the removed object
    }

    public int size(){
        return numObjects; //return the number of objects in the array
    }
}
