package tests;

public class Main {
    public static void main(String[] args) {
        MessageCommunicator messageCommunicator
            = new MessageCommunicator();
        messageCommunicator.deliver("Wanna learn AspectJ?");
        messageCommunicator.deliver("Renan", "having fun?");
        
        System.out.println("Last accessed time for messageCommunicator "
        		+ messageCommunicator.getLastAccessedTime());
    }
}