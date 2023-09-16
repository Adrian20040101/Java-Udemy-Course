package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class Layer<T extends Mappable> {

    private List<T> elements;

    public Layer() {
        this.elements = new ArrayList<>();
    }

    public void addElement(T t){
        if (!elements.contains(t)){
            elements.add(t);
        } else {
            System.out.println("Element is already present in the layer");
        }
    }

    public void addElements(T... t){
        elements.addAll(List.of(t));
    }

    public void renderLayer(){
        if (elements == null) System.out.println("Layer doesn't contain anything");
        else {
            for (T element : elements) {
//                if (element instanceof Point point) {
//                    point.render();
//                } else if (element instanceof Line line) {
//                    line.render();
//                } else {
//                    System.out.println("Couldn't render data");
//                }
                element.render();  //it is way more simple like this, but the above code describes good what is actually going on
            }
        }
    }
}
