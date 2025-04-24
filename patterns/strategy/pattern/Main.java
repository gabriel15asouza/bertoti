public class Main {
    public static void main(String[] args) {

        Dispositivo mobile = Dispositivo(new Mobile());
        mobile.transmitir();
        
        Dispositivo windows = Dispositivo(new Windows());
        windows.transmitir();
    }
}
