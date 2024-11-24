package factory;

public class ShapeFactory {
    public Shape getShape(String shapeType){
        if(shapeType == null)
            return null;

        switch(shapeType){
            case "Rectangle":
                return new Rectangle();
            case "Square":
                return new Square();
            case "Circle":
                return new Circle();
        }

        return null;
    }
}
