package download;
import org.xbill.DNS.*;
import java.net.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {

        getAddressByDomain("www.google.com");
        getAddressByDomain("www.baidu.com");
        getAddressByDomain("www.facebook.com");
        getAddressByDomain("www.sina.com");
        getAddressByDomain("blackboard.andrew.cmu.edu");
        getAddressByDomain("www.javalobby.org");
        getAddressByDomain("www.toggl.com");
        getAddressByDomain("www.cs.cmu.edu");
        getAddressByDomain("www.instagram.com");
        getAddressByDomain("www.groupme.com");
        System.out.println("Finding ten known domains done!\n");

        getAddressByDomain("www.nsadfianf.com");
        getAddressByDomain("www.werkopqwmf.com");
        getAddressByDomain("www.scmkamciewe.com");
        getAddressByDomain("www.meiwewcw.com");
        getAddressByDomain("www.sajdnfuialwenciwe.com");
        getAddressByDomain("www.asmiencenue.org");
        getAddressByDomain("www.mciemfiomcwieo.com");
        getAddressByDomain("www.cmiowmlbgreb.edu");
        getAddressByDomain("www.miuerfuiewnvrue.com");
        getAddressByDomain("www.cmiencieniwe.com");
        System.out.println("Finding ten unexistent domains done!\n");

        getDomainByAddr("74.125.127.106");
        getDomainByAddr("31.13.80.36");
        getDomainByAddr("54.243.83.153");
        getDomainByAddr("128.2.42.83");
        getDomainByAddr("208.91.135.47");
        System.out.println("Finding existent IP done!\n");

        getDomainByAddr("32.4.21.123");
        getDomainByAddr("231.9.12.221");
        getDomainByAddr("32.8.111.123");
        getDomainByAddr("32.1.122.1");
        getDomainByAddr("254.34.212.12");
        System.out.println("Finding five unexistent IP done!\n");


        TCPByIP("74.125.127.106");
        TCPByIP("31.13.80.36");
        TCPByIP("192.70.222.155");
        TCPByIP("128.2.42.83");
        TCPByIP("208.91.135.47");
        System.out.println("try tcp connection to known IP done!\n");

        TCPByIP("32.4.21.123");
        TCPByIP("231.9.12.221");
        TCPByIP("32.8.111.123");
        TCPByIP("32.1.122.1");
        TCPByIP("254.34.212.12");
        System.out.println("try tcp connection to unknown IP done!\n");



    }

    public static boolean TCPByIP(String ip)
    {
        Socket MyClient=null;
        try {
            MyClient = new Socket(ip, 80);
            DataOutputStream dout=new DataOutputStream(MyClient.getOutputStream());
            dout.writeUTF("Hello Server");
            dout.flush();
            dout.close();
            MyClient.close();
        }
        catch (IOException e) {
            System.out.println(e);
            return false;
        }
        System.out.println("try TCP connect to "+MyClient.getInetAddress());

        return true;
    }


    public static boolean getAddressByDomain(String domain)
    {
        InetAddress addr= null;
        try {
            addr = Address.getByName(domain);
        }catch(UnknownHostException e){
            System.out.println("domain unknown");
            return false;
        }
        System.out.println("IP found!"+ addr);
        return true;
    }

    public static boolean getDomainByAddr(String addr)
    {
        InetAddress inet_addr= null;
        try {
            inet_addr = Address.getByName(addr);
        }catch(UnknownHostException e){
            System.out.println("IP unknown");
            return false;
        }
        if(inet_addr.getCanonicalHostName().equals(addr)) {
            System.out.println("IP unknown");
            return false;
        }
        else{
            System.out.println(addr + "'s domain found:" + inet_addr.getCanonicalHostName());
            return true;
        }
    }

}
