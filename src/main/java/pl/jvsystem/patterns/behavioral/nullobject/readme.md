Specific problems and implementations
=====================================

1. Null Object and Factory
------------------------
The Null Object design pattern is more likely to be used in conjunction with the Factory pattern. The reason for this is obvious: A Concrete Classes need to be instantiated and then to be served to the client. The client uses the concrete class. The concrete class can be a Real Object or a Null Object.


2. Null Object and Template Method
-------------------------------
The Template method design pattern need to define an abstract class that define the template and each concrete class implements the steps for the template. If there are cases when sometimes template is called and sometimes not then, in order to avoid the checking a Null Object can be use to implement a Concrete Template that does nothing.


3. Removing old functionality
--------------------------
The Null Object can be used to remove old functionality by replacing it with null objects. The big advantage is that the existing code doesn't need to be touched.


Conclusion
-----------
The Null Object Pattern is used to avoid special if blocks for do nothing code, by putting the “do nothing” code in the Null Object which becomes responsible for doing nothing. The client is not aware anymore if the real object or the null object is called so the 'if' section is removed from client implementation.

