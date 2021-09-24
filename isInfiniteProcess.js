/*
Given integers a and b, determine whether the following pseudocode results in an infinite loop
*/

function isInfiniteProcess(a, b) {
    
    if(Math.abs(a-b) == 1 || Math.abs(a-b) == 2 || Math.abs(a-b) == 5 || Math.abs(a-b) == 10) return true;
    else return false;

}
