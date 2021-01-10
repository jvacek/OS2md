# Week 4



## Sockets
### Creating Server side
~~~ java
ServiceSocket ss = new ServerSocket(port);
while(true) // If we're expecting more than one connection, otherwise you can do everything on the same thread
{
    Socket sc = ss.accept();
    Runnable r  = new ClientHandler(sc);
    Thread t = nre Thread(r);
    t.start();
}
~~~ 

### Creating Client side
~~~ java
Socket s = new Socket(ipaddress,port);
~~~ 


### Closing sockets
You generally close sockets after you're done like so

~~~ java
try {
    // all your code
}
catch (Exception e){
    // Handle any exception above
}
finally { // The socket needs to be closed even if exceptions are encountered
    try{
        if (socket != null){
            socket.close();
        }
    }
    catch (IOException e){
        // Handle exception e
    }
}
~~~


## Text-based communication
Use wrapper classes (`Scanner` and `PrintWriter`) for text based communication 

~~~ java
InputStream is = s.getInputStream();
Scanner sc = new Scanner(is);

OutputStream os = s.getOutputStream();
PrinterWriter pw = new PrintWriter(os,true);
~~~

## Object-based communication
Use wrapper classes (`ObjectInputStream` and `ObjectOutputStream`) for object based communication   

Must create ObjectOutputStream before  ObjectInputstream

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

## Object rules
Remember! When sending objects, the corresponding classes should be serialized

~~~ java
public class Person implements Serializable
{
    //
}
~~~