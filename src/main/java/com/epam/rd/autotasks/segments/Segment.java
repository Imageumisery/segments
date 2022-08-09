package com.epam.rd.autotasks.segments;

class Segment {
    private Point start;
    private Point end;

    public Segment(Point start, Point end) {
        if (start.equals(end) || (start == null || (end == null))) {
           throw new RuntimeException();
        }
            this.start = start;
            this.end = end;

    }


    double length() {
        double x = Math.pow((end.getX() - start.getX()), 2);
        double y = Math.pow(end.getY() - start.getY(), 2);
        double length = Math.sqrt(x + y);
        return length;
    }

    Point middle() {
        double middleX = (start.getX() + end.getX()) / 2;
        double middleY = (end.getY() + start.getY()) / 2;
        return new Point(middleX, middleY);
    }


    Point intersection(Segment another) {

        double x1 = start.getX();
        double x2 = end.getX();
        double x3 = another.start.getX();
        double x4 = another.end.getX();

        double y1 = start.getY();
        double y2 = end.getY();
        double y3 = another.start.getY();
        double y4 = another.end.getY();

        double a1 = (x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4);
        double a2 = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        double a3 = (x1 - x3) * (y1 - y2) - (y1 - y3) * (x1 - x2);
        double t = a1 / a2;
        double u = a3 / a2;

        if ((t >= 0 && t <= 1) && (u >= 0 && u <= 1)) {
            return new Point(x1 + t * (x2 - x1), y1 + t * (y2 - y1));
        } else {
            return null;
        }
    }
}
