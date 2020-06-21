import javafx.scene.paint.Color;
import javafx.util.StringConverter;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ColorStringConverter extends StringConverter<Color> {
    @Override
    public String toString(Color object) {
        if (object == null) {
            return "UNKNOWN";
        }
        int r = (int) (object.getRed() * 255);
        int g = (int) (object.getGreen() * 255);
        int b = (int) (object.getBlue() * 255);
        String hex = RGBToHex(r, g, b);
        TreeMap<String, String> map = getColors();
        String str = findName(map, hex);
        if (str != null) {
            return str;
        } else {
            return "UNKNOWN";
        }
    }

    @Override
    public Color fromString(String string) {
        TreeMap<String, String> map = getColors();
        String str = findHex(map, string);
        if (str != null) {
            return HexToRGB(str);
        } else {
            return null;
        }
    }

    public static Color HexToRGB(String hexa) {
        double r = Integer.valueOf(hexa.substring(0, 2), 16);
        double g = Integer.valueOf(hexa.substring(2, 4), 16);
        double b = Integer.valueOf(hexa.substring(4, 6), 16);
        return new Color(r / 255, g / 255, b / 255, 1.0);
    }

    public static String RGBToHex(int r, int g, int b) {
        String r1 = Integer.toString(r, 16);
        String g1 = Integer.toString(g, 16);
        String b1 = Integer.toString(b, 16);
        if (r1.length() == 1) {
            r1 = "0".concat(r1);
        }
        if (g1.length() == 1) {
            g1 = "0".concat(g1);
        }
        if (b1.length() == 1) {
            b1 = "0".concat(b1);
        }
        return (r1.concat(g1).concat(b1)).toUpperCase();
    }

    public static String findHex(TreeMap<String, String> map, String name) {
        String hex = null;
        if (map.containsKey(name)) {
            Set<Map.Entry<String, String>> set = map.entrySet();
            for (Map.Entry<String, String> entry : set) {
                if ((entry.getKey()).equals(name)) {
                    hex = entry.getValue();
                    break;
                }
            }
        }
        return hex;
    }

    public static String findName(TreeMap<String, String> map, String hex) {
        String name = null;
        if (map.containsValue(hex)) {
            Set<Map.Entry<String, String>> set = map.entrySet();
            for (Map.Entry<String, String> entry : set) {
                if ((entry.getValue()).equals(hex)) {
                    name = entry.getKey();
                    break;
                }
            }
        }
        return name;
    }

    public static TreeMap<String, String> getColors() {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("ALICEBLUE", "F0F8FF");
        map.put("ANTIQUEWHITE", "FAEBD7");
        map.put("AQUA", "00FFFF");
        map.put("AQUAMARINE", "7FFFD4");
        map.put("AZURE", "F0FFFF");
        map.put("BEIGE", "F5F5DC");
        map.put("BISQUE", "FFE4C4");
        map.put("BLACK", "000000");
        map.put("BLANCHEDALMOND", "FFEBCD");
        map.put("BLUE", "0000FF");
        map.put("BLUEVIOLET", "8A2BE2");
        map.put("BROWN", "A52A2A");
        map.put("BURLYWOOD", "DEB887");
        map.put("CADETBLUE", "5F9EA0");
        map.put("CHARTREUSE", "7FFF00");
        map.put("CHOCOLATE", "D2691E");
        map.put("CORAL", "FF7F50");
        map.put("CORNFLOWERBLUE", "6495ED");
        map.put("CORNSILK", "FFF8DC");
        map.put("CRIMSON", "DC143C");
        map.put("CYAN", "00FFFF");
        map.put("DARKBLUE", "00008B");
        map.put("DARKCYAN", "008B8B");
        map.put("DARKGOLDENROD", "B8860B");
        map.put("DARKGRAY", "A9A9A9");
        map.put("DARKGREEN", "006400");
        map.put("DARKGREY", "A9A9A9");
        map.put("DARKKHAKI", "BDB76B");
        map.put("DARKMAGENTA", "8B008B");
        map.put("DARKOLIVEGREEN", "556B2F");
        map.put("DARKORANGE", "FF8C00");
        map.put("DARKORCHID", "9932CC");
        map.put("DARKRED", "8B0000");
        map.put("DARKSALMON", "E9967A");
        map.put("DARKSEAGREEN", "8FBC8F");
        map.put("DARKSLATEBLUE", "483D8B");
        map.put("DARKSLATEGRAY", "2F4F4F");
        map.put("DARKSLATEGREY", "2F4F4F");
        map.put("DARKTURQUOISE", "00CED1");
        map.put("DARKVIOLET", "9400D3");
        map.put("DEEPPINK", "FF1493");
        map.put("DEEPSKYBLUE", "00BFFF");
        map.put("DIMGRAY", "696969");
        map.put("DIMGREY", "696969");
        map.put("DODGERBLUE", "1E90FF");
        map.put("FIREBRICK", "B22222");
        map.put("FLORALWHITE", "FFFAF0");
        map.put("FORESTGREEN", "228B22");
        map.put("FUCHSIA", "FF00FF");
        map.put("GAINSBORO", "DCDCDC");
        map.put("GHOSTWHITE", "F8F8FF");
        map.put("GOLD", "FFD700");
        map.put("GOLDENROD", "DAA520");
        map.put("GRAY", "808080");
        map.put("GREEN", "008000");
        map.put("GREENYELLOW", "ADFF2F");
        map.put("GREY", "808080");
        map.put("HONEYDEW", "F0FFF0");
        map.put("HOTPINK", "FF69B4");
        map.put("INDIANRED", "CD5C5C");
        map.put("INDIGO", "4B0082");
        map.put("IVORY", "FFFFF0");
        map.put("KHAKI", "F0E68C");
        map.put("LAVENDER", "E6E6FA");
        map.put("LAVENDERBLUSH", "FFF0F5");
        map.put("LAWNGREEN", "7CFC00");
        map.put("LEMONCHIFFON", "FFFACD");
        map.put("LIGHTBLUE", "ADD8E6");
        map.put("LIGHTCORAL", "F08080");
        map.put("LIGHTCYAN", "E0FFFF");
        map.put("LIGHTGOLDENRODYELLOW", "FAFAD2");
        map.put("LIGHTGRAY", "D3D3D3");
        map.put("LIGHTGREEN", "90EE90");
        map.put("LIGHTGREY", "D3D3D3");
        map.put("LIGHTPINK", "FFB6C1");
        map.put("LIGHTSALMON", "FFA07A");
        map.put("LIGHTSEAGREEN", "20B2AA");
        map.put("LIGHTSKYBLUE", "87CEFA");
        map.put("LIGHTSLATEGRAY", "778899");
        map.put("LIGHTSLATEGREY", "778899");
        map.put("LIGHTSTEELBLUE", "B0C4DE");
        map.put("LIGHTYELLOW", "FFFFE0");
        map.put("LIME", "00FF00");
        map.put("LIMEGREEN", "32CD32");
        map.put("LINEN", "FAF0E6");
        map.put("MAGENTA", "FF00FF");
        map.put("MAROON", "800000");
        map.put("MEDIUMAQUAMARINE", "66CDAA");
        map.put("MEDIUMBLUE", "0000CD");
        map.put("MEDIUMORCHID", "BA55D3");
        map.put("MEDIUMPURPLE", "9370DB");
        map.put("MEDIUMSEAGREEN", "3CB371");
        map.put("MEDIUMSLATEBLUE", "7B68EE");
        map.put("MEDIUMSPRINGGREEN", "00FA9A");
        map.put("MEDIUMTURQUOISE", "48D1CC");
        map.put("MEDIUMVIOLETRED", "C71585");
        map.put("MIDNIGHTBLUE", "191970");
        map.put("MINTCREAM", "F5FFFA");
        map.put("MISTYROSE", "FFE4E1");
        map.put("MOCCASIN", "FFE4B5");
        map.put("NAVAJOWHITE", "FFDEAD");
        map.put("NAVY", "000080");
        map.put("OLDLACE", "FDF5E6");
        map.put("OLIVE", "808000");
        map.put("OLIVEDRAB", "6B8E23");
        map.put("ORANGE", "FFA500");
        map.put("ORANGERED", "FF4500");
        map.put("ORCHID", "DA70D6");
        map.put("PALEGOLDENROD", "EEE8AA");
        map.put("PALEGREEN", "98FB98");
        map.put("PALETURQUOISE", "AFEEEE");
        map.put("PALEVIOLETRED", "DB7093");
        map.put("PAPAYAWHIP", "FFEFD5");
        map.put("PEACHPUFF", "FFDAB9");
        map.put("PERU", "CD853F");
        map.put("PINK", "FFC0CB");
        map.put("PLUM", "DDA0DD");
        map.put("POWDERBLUE", "B0E0E6");
        map.put("PURPLE", "800080");
        map.put("RED", "FF0000");
        map.put("ROSYBROWN", "BC8F8F");
        map.put("ROYALBLUE", "4169E1");
        map.put("SADDLEBROWN", "8B4513");
        map.put("SALMON", "FA8072");
        map.put("SANDYBROWN", "F4A460");
        map.put("SEAGREEN", "2E8B57");
        map.put("SEASHELL", "FFF5EE");
        map.put("SIENNA", "A0522D");
        map.put("SILVER", "C0C0C0");
        map.put("SKYBLUE", "87CEEB");
        map.put("SLATEBLUE", "6A5ACD");
        map.put("SLATEGRAY", "708090");
        map.put("SLATEGREY", "708090");
        map.put("SNOW", "FFFAFA");
        map.put("SPRINGGREEN", "00FF7F");
        map.put("STEELBLUE", "4682B4");
        map.put("TAN", "D2B48C");
        map.put("TEAL", "008080");
        map.put("THISTLE", "D8BFD8");
        map.put("TOMATO", "FF6347");
        map.put("TRANSPARENT", "00000000");
        map.put("TURQUOISE", "40E0D0");
        map.put("VIOLET", "EE82EE");
        map.put("WHEAT", "F5DEB3");
        map.put("WHITE", "FFFFFF");
        map.put("WHITESMOKE", "F5F5F5");
        map.put("YELLOW", "FFFF00");
        map.put("YELLOWGREEN", "9ACD32");
        return map;
    }
}
