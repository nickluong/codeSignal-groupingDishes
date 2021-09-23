/*
You are given a list dishes, where each element consists of a list of strings beginning with the name of the dish, followed by all the ingredients used in preparing it. 
You want to group the dishes by ingredients, so that for each ingredient you'll be able to find all the dishes that contain it (if there are at least 2 such dishes).
Return an array where each element is a list beginning with the ingredient name, followed by the names of all the dishes that contain this ingredient. 
The dishes inside each list should be sorted lexicographically, and the result array should be sorted lexicographically by the names of the ingredients.
*/

String[][] groupingDishes(String[][] dishes) {
    HashMap<String, ArrayList<String>> map = new HashMap<>();
    for(String[] ingred: dishes){
        for(int i = 1; i < ingred.length; i++){
            if(map.containsKey(ingred[i])){
                ArrayList<String> foods = map.get(ingred[i]);
                foods.add(ingred[0]);
                map.put(ingred[i],foods);
            }else{
                ArrayList<String> foods = new ArrayList<>();
                foods.add(ingred[0]);
                map.put(ingred[i],foods);
            }
        }
    }
    
    ArrayList<String[]> list = new ArrayList<>();
    for(String ingred:map.keySet()){
        ArrayList<String> foods = map.get(ingred);
        if(foods.size()>1){
            Collections.sort(foods);
            String[] fin = new String[foods.size()+1];
            fin[0]=ingred;
            for(int i = 0; i < foods.size(); i++)
                fin[i+1]=foods.get(i);
            list.add(fin);
        }
    }
    
    
    Collections.sort(list,(a,b)->a[0].compareTo(b[0]));
    return list.toArray(new String[0][]);
}
