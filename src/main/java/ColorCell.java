import javafx.scene.control.ListCell;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ColorCell extends ListCell<Color> {

    @Override
    protected void updateItem(Color item, boolean empty) {
        super.updateItem(item, empty);
        ColorStringConverter csc = new ColorStringConverter();
        Rectangle rect = new Rectangle(30, 10);
        if (item != null) {
            rect.setFill(item);
            setText(csc.toString(item));
            setGraphic(rect);
        } else {
            setText("");
            rect.setFill(Color.WHITE);
            setGraphic(rect);
        }
    }

    public static Color getContrastColor(Color color) {
        double r = color.getRed();
        double g = color.getGreen();
        double b = color.getBlue();
        double rgb = (299 * r + 587 * g + 114 * b) / 1000;
        return rgb >= 128 ? Color.BLACK : Color.WHITE;
    }
}
