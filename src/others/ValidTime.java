package others;

public class ValidTime {

    boolean validTime(String time) {
        int hours = Integer.parseInt(time.substring(0, 2));
        int minutes = Integer.parseInt(time.substring(3));

        return hours < 24 && minutes < 60;
    }

    public static void main(String[] args) {
        ValidTime validTime = new ValidTime();
        System.out.println(validTime.validTime("13:58"));
        System.out.println(validTime.validTime("25:51"));
    }
}
