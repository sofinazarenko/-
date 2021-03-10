package Point2d;

public class point2d {
    private double xCoord;  // координата X
    private double yCoord;  // координата Y

    public point2d(double x, double y) {
        /* Конструктор инициализации */
        xCoord = x;
        yCoord = y;
    }

    public point2d() {
        /* Конструктор по умолчанию. */
        //Вызовите конструктор с двумя параметрами и определите источник.
        this(0, 0);
    }

    // Разве для этого нет какого-нибудь сахара?
    // чтоб писать point.x, point.y
    // а он уже там как-то сам вызывал getX(), getY()?

    public double getX() {
        /* Возвращение координаты X */
        return xCoord;
    }

    public double getY() {
        /* Возвращение координаты Y */
        return yCoord;
    }

    public void setX(double val) {
        /* Установка значения координаты X. */
        xCoord = val;
    }

    public void setY ( double val) {
        /* Установка значения координаты Y. */
        yCoord = val;
    }
}
