package dev.lpa.util;

import dev.lpa.model.Student;

import java.util.ArrayList;
import java.util.List;

//we can use multiple upper bounds to be more restrictive, with the use of the ampersand operator '&'
//the conditions require a type argument to implement all interfaces declared and be a subtype of any class specified
//it is possible to extend only one class at most, and zero or many interfaces
//we use extends either for a class or an interface or both
//if we do extend a class as well, it is important to type it first, and only after that the interfaces, otherwise we'll get a compiler error
public class QueryList <T extends Student & QueryItem> {

    private List<T> items;

    public QueryList(List<T> items){
        this.items = items;
    }

    //this is a generic static method, we could have still used T as parameter name, but we are going to use S to avoid confusion
    public static <S extends QueryItem> List<S> getMatches(List<S> items, String field, String value){
        List<S> matches = new ArrayList<>();
        for (var item : items){
            if (item.matchFieldValue(field, value)){
                matches.add(item);
            }
        }
        return matches;
    }

    public List<T> getMatches(String field, String value){
        List<T> matches = new ArrayList<>();
        for (var item : items){
            if (item.matchFieldValue(field, value)){
                matches.add(item);
            }
        }
        return matches;
    }
}
