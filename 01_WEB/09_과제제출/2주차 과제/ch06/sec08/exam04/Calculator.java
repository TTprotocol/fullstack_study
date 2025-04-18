package ch06.sec08.exam04;

public class Calculator {
    //정사각형의 넓이
    double areaRectangle(double width) {
        return width * width;

    }

    // 직사각형의 넓이
    // 메소드 오버로딩 : 매서드 이름은 같지만 매개변수의 개수가 다르다.
    double areaRectangle(double width, double height) {
        return width * height;
    }
}