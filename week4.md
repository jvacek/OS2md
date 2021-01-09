# Week 4

## Network Sockets

## Creating socket at server side
~~~ java
ServiceSocket ss = new ServerSocket(port);
while(true)
{
    Socket sc = ss.accept();
    Runnable r  = new ClientHandler(sc);
    Thread t = nre Thread(r);
    t.start();
}
~~~ 

##  Creating socket at client side
~~~ java
Socket s = new Socket(ipaddress,port);
~~~ 

## Use wrapper classes (Scanner and PrintWriter) for text based communication 

## By creating sockets

~~~ java

InputStream is = s.getInputStream();
Scanner sc = new Scanner(is);
OutputStream os = s.getOutputStream();
PrinterWriter pw = new PrintWriter(os,true);
~~~

## Use wrapper classes (ObjectInputStream and ObjectOutputStream) for object based communication   

## By creating sockets

## Must create ObjectOutputStream before  ObjectInputstream

~~~ java

InputStream is = s.getInputStream();
OutputStream os = s.getOutputStream();
ObjectOutputStream oos = new ObjectOutputStream(os,true);
ObjectInputStream  ois = new ObjectInputStream(is);


~~~

## Example of communication
~~~java
Person p = new Person(name,age);
oos.WriteObject(p);
Object o = ois.ReadObject();
Person pers = (Person)o;
~~~

## When sending objects, the corresponding classes should be serialized

## Example 
~~~ java

public class Person implements Serializable
{}

~~~